package com.example.eazilydone.DTO;

import java.time.LocalDateTime;

public class ScoreDTO {
    private String name;
    private String mail;
    private int score;

    public ScoreDTO(String name, String email, int score) {
        this.name = name;
        this.mail = email;
        this.score = score;
    }
}
