package com.example.twenty_forty_eight_rest;

import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;

import org.springframework.data.domain.Sort;
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
    
    @GetMapping("/scores")
    public String getMethodName(@RequestParam(value = "sortState", defaultValue = "score") String sortState) {

        //TODO: Actual implementation later
        return this.db.getAllScores(sortState);
    }
    
    @PostMapping("/submitScore")
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return "501 not implemented";
    }
    
}
