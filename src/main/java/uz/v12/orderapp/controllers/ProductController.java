package uz.v12.orderapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import uz.v12.orderapp.db.dao.interfaces.ProductDAO;
import uz.v12.orderapp.db.entities.Product;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
@Service
public class ProductController {

    private ProductDAO dao;

    @Autowired
    public ProductController(ProductDAO productDAO){
        this.dao=productDAO;
    }
    @GetMapping(value="/get")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }

    @GetMapping(value="/get/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        return new ResponseEntity<>(dao.getByProductId(id), HttpStatus.OK);
    }
    @GetMapping(value="/getName")
    public ResponseEntity<Product> getName(@PathVariable String name){
        return new ResponseEntity<>(dao.getByName(name), HttpStatus.OK);
    }
    @PostMapping(value = "/save")
    public ResponseEntity<List<Product>> saveEmployee(@Valid @RequestBody Product product) {
        dao.saveProduct(product);
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<List<Product>> deleteEmployee(@PathVariable int id) {
        dao.deleteProduct(id);
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }
}
