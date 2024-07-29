package com.example.twenty_forty_eight_rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class LeaderboardRest {

    private final DatabaseController db;
    
    public LeaderboardRest(DatabaseController db) {
        this.db = db;
    }
    
    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/scores")
    public ResponseEntity<String> getMethodName(
            @RequestParam(value = "sortState", defaultValue = "score") String sortState) {
        switch (sortState) {
            case "score":
                return ResponseEntity.ok().body(this.db.getAllScores());
            case "time":
                return ResponseEntity.ok().body(this.db.getAllTimes());
        }
        return ResponseEntity.badRequest().body("Invalid query");
    }
    
    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/submitScore")
    public ResponseEntity<String> postMethodName(@RequestBody String entity) {
        if (this.db.addScore(entity)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.internalServerError().build();
    }
    
    
}
