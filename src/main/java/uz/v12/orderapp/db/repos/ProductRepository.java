package uz.v12.orderapp.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.v12.orderapp.db.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer>{

    List<Product> findAll();

     Product  findById(int id);
     Product findByName(String name);

}
