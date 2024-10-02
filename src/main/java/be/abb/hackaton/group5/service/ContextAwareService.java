package be.abb.hackaton.group5.service;

import be.abb.hackaton.group5.model.UserContext;
import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;
import org.apache.jena.riot.RDFLanguages;
import org.apache.jena.riot.RDFWriter;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

@Component
public class ContextAwareService {
    public String someFunctionality(String jsonLdData) {
        System.out.println ("Request received : " + jsonLdData);
        /*String jsonLdData = """
        {
            "@context": {
                "foaf": "http://xmlns.com/foaf/0.1/",
                "geo": "http://www.w3.org/2003/01/geo/wgs84_pos#",
                "xsd": "http://www.w3.org/2001/XMLSchema#"
            },
            "@type": "foaf:Person",
            "foaf:name": "Klaas de Vries",
            "foaf:member": {
                "@type": "foaf:Organization",
                "foaf:name": "Gemeente Merchtem"
            },
            "foaf:based_near": {
                "@type": "geo:Point",
                "geo:lat": 52.3676,
                "geo:long": 4.9041
            },
            "foaf:role": "employee",
            "foaf:device": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36",
            "foaf:language": "en-US",
            "foaf:timezone": "Europe/Brussels",
            "serviceRequest": {
                "@type": "foaf:Document",
                "foaf:title": "paspoort"
            }
        }
        """;*/
        String turtleData = this.getJsonLDAsTurtle(jsonLdData);
        System.out.println(turtleData);

        this.saveToTripleStore(turtleData);


        return "{\"result\": \"OK\"}";
    }

    private void saveToTripleStore(String turtleData) {
        // Het Virtuoso SPARQL endpoint URL
        String sparqlEndpoint = "http://database:8890/sparql";

        // SPARQL INSERT DATA query
        ParameterizedSparqlString pss = new ParameterizedSparqlString();
        pss.append("PREFIX foaf: <http://xmlns.com/foaf/0.1/> ");
        pss.append("PREFIX geo:  <http://www.w3.org/2003/01/geo/wgs84_pos#> ");
        pss.append("PREFIX xsd:  <http://www.w3.org/2001/XMLSchema#> ");
        pss.append("INSERT DATA { ");
        pss.append("GRAPH <http://www.abb.be/lpdc/context-graph> {");
        pss.append(turtleData);
        pss.append(" }");
        pss.append(" }");

        // Voer de SPARQL update uit naar het Virtuoso endpoint
        UpdateRequest update = pss.asUpdate();
        UpdateProcessor processor = UpdateExecutionFactory.createRemote(update, sparqlEndpoint);
        processor.execute();
    }

    private String getJsonLDAsTurtle(String jsonLdData){
        // Maak een input stream van de JSON-LD string
        InputStream inputStream = new ByteArrayInputStream(jsonLdData.getBytes());

        // Maak een leeg Jena model
        Model model = ModelFactory.createDefaultModel();

        // Parse het JSON-LD bericht en laad het in het Jena model
        RDFDataMgr.read(model, inputStream, RDFLanguages.JSONLD);

        // Serialiseer het model naar Turtle formaat
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        RDFWriter.create()
                .source(model)
                .format(RDFFormat.TURTLE)
                .output(outputStream);

        // Turtle string
        String turtleData = outputStream.toString();
        // Verwijder de @prefix lijnen handmatig (als ze nog steeds worden toegevoegd)
        turtleData = turtleData.replaceAll("@prefix.*\\n", "");

        // Sluit de streams
        try {
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return turtleData;
    }
}
