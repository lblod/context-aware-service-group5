package be.abb.hackaton.group5.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserContext {

    @JsonProperty("foaf:name")
    private String name;

    @JsonProperty("foaf:member")
    private Organization member;

    @JsonProperty("foaf:based_near")
    private Point basedNear;

    @JsonProperty("foaf:role")
    private String role;

    @JsonProperty("foaf:device")
    private String device;

    @JsonProperty("foaf:language")
    private String language;

    @JsonProperty("foaf:timezone")
    private String timezone;

    @JsonProperty("serviceRequest")
    private SomeServiceRequest serviceRequest;

    // Constructors, getters, and setters
    public UserContext() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organization getMember() {
        return member;
    }

    public void setMember(Organization member) {
        this.member = member;
    }

    public Point getBasedNear() {
        return basedNear;
    }

    public void setBasedNear(Point basedNear) {
        this.basedNear = basedNear;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public SomeServiceRequest getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(SomeServiceRequest serviceRequest) {
        this.serviceRequest = serviceRequest;
    }
}
