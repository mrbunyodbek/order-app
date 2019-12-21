package uz.v12.orderapp.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.v12.orderapp.db.entities.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Integer> {

    List<Item> findAll();
    Item findById(int id);
    Item findByOrderId(int id);
    Item findByCost(double cost);


}
