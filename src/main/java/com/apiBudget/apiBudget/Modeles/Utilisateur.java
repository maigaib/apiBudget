package com.apiBudget.apiBudget.Modeles;

import jakarta.persistence.*;

import java.util.List;

public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

   /* @OneToMany(mappedBy = "utilisateur",cascade = CascadeType.ALL)
    private List<Quiz> quiz;*/

    public Utilisateur() {
    }

    public Utilisateur(int id, String name, String email, String password, List<Quiz> quiz) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
