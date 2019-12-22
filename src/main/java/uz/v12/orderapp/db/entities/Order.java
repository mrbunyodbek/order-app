package uz.v12.orderapp.db.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "serial")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "market_id", unique = true)
    private int marketId;



    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reference",nullable = false)
    private  int reference ;


    @Column(name = "date")
    private LocalDate date ;

    @Nullable
    @Column(name = "cost")
    private String cost;


}
