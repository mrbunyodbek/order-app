package uz.v12.orderapp.db.dao.interfaces;

import uz.v12.orderapp.db.entities.Item;

import java.util.List;

public interface ItemDAO {

    List<Item> getAll();

    Item getByOrderId(int id);
    Item getByCost(double cost);

    void saveItem(Item item);
    void editItem(Item item);
    void deleteItem(int id);

}
