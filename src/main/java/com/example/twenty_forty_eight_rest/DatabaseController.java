package com.example.twenty_forty_eight_rest;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DatabaseController {

    public enum SortOrder {
        score, time
    }

    private final ScoreRepo repo;
    
    public DatabaseController(ScoreRepo repo) {
        this.repo = repo;
    }

    public boolean addScore(String username, int score, int time) {
        this.repo.save(new Score(username, score, time));
        return true;
    }
    
    public String getAllScores() {
        var scores = this.repo.findAll(Sort.by(Sort.Direction.DESC, "score"));
        ObjectMapper objmap = new ObjectMapper();
        try {
            String stringJson = objmap.writeValueAsString(scores);
            return stringJson;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getAllTimes() {
        var times = this.repo.findAll(Sort.by(Sort.Direction.ASC, "time"));
        ObjectMapper objmap = new ObjectMapper();
        try {
            String stringJson = objmap.writeValueAsString(times);
            return stringJson;
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
