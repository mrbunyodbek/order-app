package uz.v12.orderapp.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import uz.v12.orderapp.collections.FullOrder;
import uz.v12.orderapp.db.dao.interfaces.ItemDAO;
import uz.v12.orderapp.db.dao.interfaces.OrderDAO;
import uz.v12.orderapp.db.entities.Order;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/order")
@Service
public class OrderController {
    private OrderDAO dao;
    private ItemDAO itemDAO;

    @Autowired
    public OrderController(OrderDAO orderDAO,ItemDAO itemDAO){
        this.dao=orderDAO;
        this.itemDAO=itemDAO;
    }

    @GetMapping(value="/get")
    public ResponseEntity<List<Order>> getAllOrderes(){
        return new ResponseEntity<>(dao.getAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/getUserId/{id}")
    public ResponseEntity<Order> getUsertId(@PathVariable int id) {
        return new ResponseEntity<>(dao.getByUserId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/getMarketId/{id}")
    public ResponseEntity<Order> getMarketId(@PathVariable int id) {
        return new ResponseEntity<>(dao.getByMarketId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/getDate/{id}")
    public ResponseEntity<Order> getDate(@PathVariable LocalDate data) {
        return new ResponseEntity<>(dao.getByDate(data), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<List<Order>> saveEmployee(@Valid @RequestBody FullOrder order) {
        dao.saveOrder(order);
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<List<Order>> deleteEmployee(@PathVariable int id) {
        dao.deleteOrder(id);
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }

}
