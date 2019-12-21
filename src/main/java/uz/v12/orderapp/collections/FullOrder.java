package uz.v12.orderapp.collections;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.v12.orderapp.db.entities.Item;
import uz.v12.orderapp.db.entities.Order;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FullOrder {

    private Order order;
    private List<Item> items;

}
