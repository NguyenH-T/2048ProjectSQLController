package com.example.twenty_forty_eight_rest;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "scores")
class Score implements Serializable {
    
    @Column(nullable = false)
    private String username;
    
    @Column(nullable = false)
    private int score;
    
    @Column(nullable = false)
    private int time;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long scoreid;

    private Score() {
    }
    
    public Score(String username, int score, int time) {
        this.username = username;
        this.score = score;
        this.time = time;
    }

    public String getUsername() {
        return this.username;
    }

    public int getScore() {
        return this.score;
    }

    public int getTime() {
        return this.time;
    }
}
