package com.example.vote;

import java.util.Date;

public class votes {
    private String id;
    private String Question;
    private String datefin;
    String re1;
    String re2;
    String re3;
    String re4;
    String re5;


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

    public votes(String id, String question, String datefin, String re1, String re2, String re3, String re4, String re5) {
        this.id = id;
        Question = question;
        this.datefin = datefin;
        this.re1 = re1;
        this.re2 = re2;
        this.re3 = re3;
        this.re4 = re4;
        this.re5 = re5;
    }

    public String getRe1() {
        return re1;
    }

    public void setRe1(String re1) {
        this.re1 = re1;
    }

    public String getRe2() {
        return re2;
    }

    public void setRe2(String re2) {
        this.re2 = re2;
    }

    public String getRe3() {
        return re3;
    }

    public void setRe3(String re3) {
        this.re3 = re3;
    }

    public String getRe4() {
        return re4;
    }

    public void setRe4(String re4) {
        this.re4 = re4;
    }

    public String getRe5() {
        return re5;
    }

    public void setRe5(String re5) {
        this.re5 = re5;
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
