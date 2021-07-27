package com.example.rabbitStreams.controller;

import com.example.rabbitStreams.model.ApplicationData;
import com.example.rabbitStreams.model.ApplicationDataConfirmation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;


@RestController
public class ApplicationDataController {

    final static Logger LOGGER = LoggerFactory.getLogger(ApplicationDataController.class);

    private final RestTemplate restTemplate;

    public ApplicationDataController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(path = "/", method = {RequestMethod.GET})
    public String index(HttpSession session) {
        session.setAttribute("color", "blue");
        return "index";
    }

    @RequestMapping(path = "/kill", method = {RequestMethod.GET})
    public void kill() {
        LOGGER.info("killing the job");
        System.exit(1);
    }

    @PostMapping("/processApplicationData")
    public ApplicationDataConfirmation processApplicationData(@RequestBody final ApplicationData applicationData) {
        LOGGER.info("received applicationData: " + applicationData.toString());
        ApplicationData applicationDataOut = (ApplicationData) restTemplate.postForObject("http://localhost:8080/persistApplicationData", applicationData, ApplicationData.class);
        if(applicationDataOut.getId()!=null) {
            return new ApplicationDataConfirmation(ApplicationDataConfirmation.SUCCESS);
        }
        throw new RuntimeException("did not save application data");
    }

}

