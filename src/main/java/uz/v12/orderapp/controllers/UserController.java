package uz.v12.orderapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import uz.v12.orderapp.db.entities.User;
import uz.v12.orderapp.db.entities.dao.interfaces.UserDAO;


import java.util.List;

@RestController
@RequestMapping("/users")
@Service
public class UserController {
    private UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userDAO.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        return new ResponseEntity<>(userDAO.getById(id), HttpStatus.OK);
    }

    @GetMapping(value = "delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        userDAO.deleteById(id);
        return new ResponseEntity<>(userDAO.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<List<User>> saveUser(@RequestBody User user) {
        userDAO.saveUser(user);
        return new ResponseEntity<>(userDAO.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<User>> updateUser(@RequestBody User user) {
        userDAO.editUser(user);
        return new ResponseEntity<>(userDAO.getAll(), HttpStatus.OK);
    }


}
