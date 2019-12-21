package uz.v12.orderapp.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.v12.orderapp.collections.FullOrder;
import uz.v12.orderapp.db.dao.interfaces.ItemDAO;
import uz.v12.orderapp.db.dao.interfaces.OrderDAO;
import uz.v12.orderapp.db.entities.Item;
import uz.v12.orderapp.db.entities.Order;
import uz.v12.orderapp.db.repos.OrderRepository;

import java.time.LocalDate;
import java.util.List;
@Service
public class OrderDAOImpl implements OrderDAO {
    private OrderRepository repository;
    private ItemDAO dao;

    @Autowired
    public OrderDAOImpl(OrderRepository orderRepository, ItemDAO dao){
        this.repository=orderRepository;
        this.dao = dao;
    }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }

    @Override
    public Order getByUserId(int id) {
        return repository.findByUserId(id);
    }

    @Override
    public Order getByMarketId(int id) {
        return repository.findByMarketId(id);
    }

    @Override
    public Order getByDate(LocalDate date) {
        return repository.findByDate(date);
    }

    @Override
    public void saveOrder(FullOrder fullOrder) {
        repository.save(fullOrder.getOrder());
        int id = repository.findByReference(fullOrder.getOrder().getReference()).getId();

        List<Item> items = fullOrder.getItems();
        for (Item item : items) {
            item.setOrderId(id);
            dao.saveItem(item);
        }
    }

    @Override
    public void deleteOrder(int id) {
    repository.deleteById(id);
    }
}
