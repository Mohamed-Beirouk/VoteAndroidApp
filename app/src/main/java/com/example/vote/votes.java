package com.example.vote;

import java.util.Date;

public class votes {
    private int id;
    private String Question;
    private String datefin;

    public votes(String question, String datefin) {
        Question = question;
        this.datefin = datefin;
    }

    public votes(String question) {
        Question = question;
    }


    public votes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
