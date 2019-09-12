package com.example.vip.model;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data//使用lombok插件省略 get() set() 方法
@Entity//表明该 Java 类为实体类，将映射到指定的数据库表
@Table(name = "vip")//使用的表
public class Vip implements Serializable {
    private static final long serialVersionUID = 2711201708013908747L;
    @Id//声明此属性为数据库主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//标注主键的生成策略,这个是采用数据库自增长。

    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "name", length = 255,nullable = false)
    private String name;

    @Column(name = "gender",nullable = false)
    private String gender;

    @Column(name = "number",nullable = false)
    private String number;
    @Column( name = "birthday" )

    private Date birthday;

    @Column( name = "integral" )//积分
    private int integral;

    @Column( name = "balance" )//余额
    private int  balance;

    @Column( name = "ljintegral" )//累计积分
    private int ljintegral;



public  Vip(){

}
    public Vip (String name , String gender,String number,Date birthday){
        this.name=name;
        this.gender=gender;
        this.number=number;
        this.birthday=birthday;
        this.integral=0;
        this.balance=0;
        this.ljintegral=0;
    }
}





