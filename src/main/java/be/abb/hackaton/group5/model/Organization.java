package be.abb.hackaton.group5.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Organization {

    @JsonProperty("foaf:name")
    private String name;

    // Constructors, getters, and setters
    public Organization() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}