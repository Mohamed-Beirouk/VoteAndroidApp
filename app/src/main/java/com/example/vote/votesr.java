package com.example.vote;

public class votesr {

    private String id;
    private String idv;
    private String rep;
    private String userid;

    public votesr() {
    }

    public votesr(String id, String idv, String rep, String userid) {
        this.id = id;
        this.idv = idv;
        this.rep = rep;
        this.userid=userid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdv() {
        return idv;
    }

    public void setIdv(String idv) {
        this.idv = idv;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
