package com.example.vip.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor//全参沟槽方法
@AllArgsConstructor//无参构造方法
@Entity
@Table(name="JExchange")
public class JExchange implements Serializable {
    private static final long serialVersionUID = 2711201708013908747L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)

    @JoinColumn(name = "vipname", referencedColumnName = "name")
    private Vip vip;

    @OneToOne(cascade = CascadeType.ALL)

    @JoinColumn(name = "giftname", referencedColumnName = "G_name")
    private Gift gift;

    @Column(name = "Edate",nullable = false)
    private Date Edate;

    @Column(name = "E_amount",nullable = false)
    private Integer E_amount;

    @Column(name = "E_integral",nullable = false)
    private Integer E_integral;


public  JExchange(Vip vip,Gift gift,Date date, Integer e_amount , Integer E_intergral){
    this.E_amount=e_amount;
    this.vip=vip;
    this.gift=gift;
    this.Edate=date;
    this.E_integral=E_intergral;

}

}
