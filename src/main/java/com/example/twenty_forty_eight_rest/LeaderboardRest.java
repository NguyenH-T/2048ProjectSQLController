package com.example.twenty_forty_eight_rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class LeaderboardRest {
    
    @GetMapping("/scores")
    public String getMethodName(@RequestParam(value = "sort", defaultValue = "score") String sort) {

        //TEMP. Actual implementation later
        switch (sort) {
            case "score":
                return "{username: John, score: 1283, time: 105}\r\n{username: Doe, score: 1003, time: 93}";
            case "time":
                return "{username: Doe, score: 1003, time: 93}\r\n{username: John, score: 1283, time: 105}";
            default:
                return "501 not implemented";
        }
    }
    
    @PostMapping("/submitScore")
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return "501 not implemented";
    }
    
}
