package com.example.vip.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name="Gift")
public class Gift implements Serializable{
    private static final long serialVersionUID = 2711201708013908747L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "G_id",nullable = false)
    private Long G_id;

    @Column(name = "G_name", length = 255,nullable = false)
    private String G_name;

    @Column(name = "G_integral",nullable = false)
    private Integer G_integral;

    @Column(name = "photo")
    private String photo;

    public Gift(){

    }
    public Gift(String G_name, Integer G_integral, String photo){
        this.G_name=G_name;
        this.G_integral=G_integral;
        this.photo=photo;
    }
}
