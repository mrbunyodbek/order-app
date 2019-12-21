package uz.v12.orderapp.db.dao.interfaces;

import uz.v12.orderapp.db.entities.Order;
import uz.v12.orderapp.db.entities.Product;

import java.time.LocalDate;
import java.util.List;

public interface ProductDAO {

    List<Product> getAll();

    Product getByProductId(int id);
    Product getByName(String name);

    void saveProduct(Product product);
    void editProduct(Product product);
    void deleteProduct(int id);
}
