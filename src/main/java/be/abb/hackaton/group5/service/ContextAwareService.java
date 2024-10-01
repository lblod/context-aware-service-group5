package be.abb.hackaton.group5.service;

import be.abb.hackaton.group5.model.UserContext;
import org.springframework.stereotype.Component;

@Component
public class ContextAwareService {
    public String someFunctionality(UserContext userContext) {
        System.out.println ("Request received!");

        return "{\"result\": \"OK\"}";
    }
}
