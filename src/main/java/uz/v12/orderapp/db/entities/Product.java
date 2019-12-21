package uz.v12.orderapp.db.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name="products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "serial")
    private int id;


    @Column(name="name")
    private String name;

    @Column(name="rate")
    private double rate;

    @Column(name="count")
    private int cout;

    @Column(name="order_count")
    private int orderCout;

    @Column(name="image",columnDefinition = "text")
    private String image;

}

