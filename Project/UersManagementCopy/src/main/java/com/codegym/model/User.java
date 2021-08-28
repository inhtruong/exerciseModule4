package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements Comparable<User>{
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column (name = "name_user")
    protected String name;
    @Column (name = "email")
    protected String email;
    @Column (name = "country")
    protected String country;
    @Column (name = "balance")
    protected float balance;

    public User() {}

    public User(String name, String email, String country) {
        this.name = name;
        this.email = email;
        this.country = country;
    }

    public User( String name, String email, String country, float balance) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.balance = balance;
    }

    public User(int id, String name, String email, String country, float balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.balance = balance;
    }

    public User(int id, String name, String email, String country) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
    }

    public User(int id, String name, float balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public int compareTo(User user) {
        return (int)(this.id - user.getId());
    }
}
