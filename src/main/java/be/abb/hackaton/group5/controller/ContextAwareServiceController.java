package be.abb.hackaton.group5.controller;

import be.abb.hackaton.group5.model.UserContext;
import be.abb.hackaton.group5.service.ContextAwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/context-aware-service")
public class ContextAwareServiceController {

    @Autowired
    private ContextAwareService contextAwareService;

    /*@PostMapping("/someFunctionality")
    public String someFunctionality(@RequestBody UserContext userContext) {
        return this.contextAwareService.someFunctionality(userContext);
    }*/

    @PostMapping("/someFunctionality")
    public String someFunctionality(@RequestBody String userContext) {
        return this.contextAwareService.someFunctionality(userContext);
    }
}
