package org.logaidetector.controllers;
import org.logaidetector.Model.AIResponse;
import org.logaidetector.Model.AiRequest;
import org.logaidetector.Model.Log;
import org.logaidetector.services.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin
public class AIController {
    private AIService aiService;

    @Autowired
    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/analyze/{id}")
    public ResponseEntity<String> analyzeLogs(@PathVariable("id") Long id) {
        String response = aiService.analyse(id);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @PostMapping("/summarize-incident/{id}")
    public ResponseEntity<String> summarizeIncident(@PathVariable("id") Long id) {
        String response = aiService.summarise(id);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @PostMapping("/detect-anomaly/{id}")
    public ResponseEntity<String> detectAnomaly(@PathVariable("id") Long id) {
        String response = aiService.detectAnomalies(id);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @PostMapping("/recommend-fix/{id}")
    public ResponseEntity<String> recommendFix(@PathVariable("id") Long id) {
        String response = aiService.recommendFix(id);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @PostMapping("/devops-chat")
    public ResponseEntity<String> devopsChat(@RequestBody String prompt) {
        String response = aiService.chat(prompt);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
