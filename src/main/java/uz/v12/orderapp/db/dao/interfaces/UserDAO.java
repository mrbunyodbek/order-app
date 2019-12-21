package uz.v12.orderapp.db.dao.interfaces;

import uz.v12.orderapp.db.entities.User;

import java.util.List;

public interface UserDAO {

    List<User> getAll();

    User getById(int id);

    User getByUsername(String userName);

    User getByFirstName(String firstName);

    User getByLastName(String lastName);

    void saveUser(User user);

    void editUser(User user);

    void deleteById(Integer id);
}
