package uz.v12.orderapp.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.v12.orderapp.db.dao.interfaces.ItemDAO;
import uz.v12.orderapp.db.entities.Item;
import uz.v12.orderapp.db.repos.ItemRepository;

import java.util.List;
@Service
public class ItemDAOImpl implements ItemDAO {
    private ItemRepository repository;

    @Autowired
    public ItemDAOImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Item> getAll() {
        List<Item> itemList=repository.findAll();
        return itemList;
    }

    @Override
    public Item getByOrderId(int id) {

        return repository.findByOrderId(id);
    }

    @Override
    public Item getByCost(double cost) {
        return repository.findByCost(cost);
    }

    @Override
    public void saveItem(Item item) {

        repository.save(item);
    }

    @Override
    public void editItem(Item item) {
        Item temp = repository.findById(item.getId());
        temp.setOrderId(item.getOrderId());
        temp.setProductId(item.getProductId());
        temp.setAmount(item.getAmount());
        temp.setCost(item.getCost());
        repository.save(temp);
    }

    @Override
    public void deleteItem(int id) {
        repository.deleteById(id);
    }
}
