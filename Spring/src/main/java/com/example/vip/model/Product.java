package com.example.vip.model;
import javax.persistence.*;
import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor//全参沟槽方法
@AllArgsConstructor//无参构造方法
@Entity
@Table(name = "Product")
//商品
public class Product  implements Serializable{
    private static final long serialVersionUID = 2711201708013908747L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", length = 255)
    private String name;
    @Column(name = "value", length = 255)
    private String value;
    @Column(name = "kind", length = 255)
    private String kind;

}
