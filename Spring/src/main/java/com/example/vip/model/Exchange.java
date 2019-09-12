package com.example.vip.model;
import javax.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor//全参沟槽方法
@AllArgsConstructor//无参构造方法
@Entity
@Table(name = "exchange")
//消费记录
public class Exchange implements Serializable{
    private static final long serialVersionUID = 2711201708013908747L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vipname", referencedColumnName = "name")
    private Vip vip;


    @OneToOne(cascade = CascadeType.ALL)

    @JoinColumn(name = "productname", referencedColumnName = "name")
    private Product product;

    @Column(name = "value", length = 255)
    private String value;
    @Column(name = "kind", length = 255)
    private String kind;
    private  int quantity;
    private java.sql.Date Date;

}
