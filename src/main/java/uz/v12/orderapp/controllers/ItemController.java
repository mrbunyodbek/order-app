package uz.v12.orderapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.v12.orderapp.db.dao.interfaces.ItemDAO;
import uz.v12.orderapp.db.entities.Item;
import uz.v12.orderapp.db.entities.Order;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private ItemDAO dao;

    @Autowired
    public ItemController(ItemDAO itemDAO){
        this.dao=itemDAO;
    }
    @GetMapping(value="/get")
    public ResponseEntity<List<Item>> getAllOrderes(){
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }

    @GetMapping(value="/getCost")
    public ResponseEntity<Item> getCost(@PathVariable double cost) {
        return new ResponseEntity<>(dao.getByCost(cost), HttpStatus.OK);
    }
    @PostMapping(value = "/save")
    public ResponseEntity<List<Item>> saveEmployee(@Valid @RequestBody Item item) {
        dao.saveItem(item);
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<List<Item>> deleteEmployee(@PathVariable int id) {
        dao.deleteItem(id);
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }
}
