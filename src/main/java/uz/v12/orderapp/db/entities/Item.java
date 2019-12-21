package uz.v12.orderapp.db.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name="items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "serial")
    private int id;

    @Column(name = "order_id", unique = true)
    private int orderId;

    @Column(name = "product_id", unique = true)
    private int productId;

    @Nullable
    @Column(name = "amount")
    private String amount;

    @Nullable
    @Column(name = "cost")
    private double cost;

}
