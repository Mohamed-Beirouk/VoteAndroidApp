package com.example.vote;

public class User {
    public int id;
    public String nom,email, password, empreinte;

    public User(){

    }

    public User(int id, String nom, String email, String password, String empreinte) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.empreinte = empreinte;
    }
    public User(String nom, String empreinte) {
        this.nom = nom;
        this.empreinte = empreinte;
    }
}
