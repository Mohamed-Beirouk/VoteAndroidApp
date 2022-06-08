package com.example.vote;

public class User {
    public int id;
    public String nom, prenom, email, password, empreinte;

    public User(){

    }

    public User(int id, String nom, String prenom, String email, String password, String empreinte) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.empreinte = empreinte;
    }
}
