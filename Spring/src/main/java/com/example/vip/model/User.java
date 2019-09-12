package com.example.vip.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER")
public class User implements Serializable {
    private static final long serialVersionUID = 2711201708013908747L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name", length = 255)
    private String name;
    @Column(name = "pass", length = 255)
    private String pass;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}