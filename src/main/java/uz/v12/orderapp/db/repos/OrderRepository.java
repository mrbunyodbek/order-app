package uz.v12.orderapp.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.v12.orderapp.db.entities.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findAll();

    Order findById(int id);
    Order findByUserId(int userId);
    Order findByMarketId(int matkerId);
    Order findByDate(LocalDate date);
    Order findByReference(UUID uuid);

}
