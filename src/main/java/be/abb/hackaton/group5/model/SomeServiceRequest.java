package be.abb.hackaton.group5.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SomeServiceRequest {
    private String someSearchCriteria;

    // Constructors, getters, and setters
    public SomeServiceRequest() {}

    public String getSomeSearchCriteria() {
        return someSearchCriteria;
    }

    public void setSomeSearchCriteria(String someSearchCriteria) {
        this.someSearchCriteria = someSearchCriteria;
    }

}
