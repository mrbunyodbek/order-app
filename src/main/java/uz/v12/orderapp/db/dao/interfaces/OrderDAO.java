package uz.v12.orderapp.db.dao.interfaces;

import uz.v12.orderapp.collections.FullOrder;
import uz.v12.orderapp.db.entities.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderDAO {

    List<Order> getAll();

    Order getByUserId(int id);
    Order getByMarketId(int id);
    Order getByDate(LocalDate date);

    void saveOrder(FullOrder fullOrder);
    void deleteOrder(int id);

}
