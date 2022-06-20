package com.example.vote;

import java.util.Date;

public class votes {
    private String id;
    private String Question;
    private String datefin;

    public votes(String question, String datefin) {
        Question = question;
        this.datefin = datefin;
    }

    public votes(String id, String question, String datefin) {
        this.id = id;
        Question = question;
        this.datefin = datefin;
    }

    public votes(String question) {
        Question = question;
    }


    public votes() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

}
