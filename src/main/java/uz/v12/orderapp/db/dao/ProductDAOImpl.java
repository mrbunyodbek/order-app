package uz.v12.orderapp.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.v12.orderapp.db.dao.interfaces.ProductDAO;
import uz.v12.orderapp.db.entities.Product;
import uz.v12.orderapp.db.repos.ProductRepository;

import java.util.List;

@Service
public class ProductDAOImpl implements ProductDAO {
    private ProductRepository repository;

    @Autowired
    public ProductDAOImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getByProductId(int id) {
        return repository.findById(id);
    }

    @Override
    public Product getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void saveProduct(Product product) {
        repository.save(product);
    }

    @Override
    public void editProduct(Product product) {

        Product temp=repository.findById(product.getId());
        temp.setCount(product.getCount());
        temp.setName(product.getName());
        temp.setRate(product.getRate());
        repository.save(temp);
    }

    @Override
    public void deleteProduct(int id) {
        repository.deleteById(id);
    }
}
