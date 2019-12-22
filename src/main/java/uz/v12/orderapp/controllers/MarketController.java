package uz.v12.orderapp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import uz.v12.orderapp.db.entities.Market;
import uz.v12.orderapp.db.dao.interfaces.MarketDAO;

import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/markets")
@Service
public class MarketController {
    private MarketDAO marketDAO;

    @Autowired
    public MarketController(MarketDAO marketDAO) {
        this.marketDAO = marketDAO;
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<Market>> getAllMarkets() {
        return new ResponseEntity<>(marketDAO.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Market> getMarket(@PathVariable int id) {
        return new ResponseEntity<>(marketDAO.getById(id), HttpStatus.OK);
    }

    @GetMapping(value = "delete/{id}")
    public ResponseEntity<Market> deleteMarket(@PathVariable int id) {
        marketDAO.deleteById(id);
        return new ResponseEntity<>(marketDAO.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<List<Market>> saveMarket(@RequestBody Market market) {
        marketDAO.saveMarket(market);
        return new ResponseEntity<>(marketDAO.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<List<Market>> updateUser(@RequestBody Market market) {
        marketDAO.editMarket(market);
        return new ResponseEntity<>(marketDAO.getAll(), HttpStatus.OK);
    }

}
