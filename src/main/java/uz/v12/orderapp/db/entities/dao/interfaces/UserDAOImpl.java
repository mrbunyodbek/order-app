package uz.v12.orderapp.db.entities.dao.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.v12.orderapp.db.entities.User;
import uz.v12.orderapp.db.entities.repos.UserRepository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
public abstract class UserDAOImpl implements UserDAO {
    private UserRepository repository;

    @Autowired
    public UserDAOImpl(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<User> getAll() {
        List<User> userList = repository.findAll();
        return userList;
    }

    @Override
    public User getById(int id) {
        return repository.findById(id);
    }

    @Override
    public User getByUsername(String userName) {
        return repository.findByUsername(userName);
    }

    @Override
    public User getByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    @Override
    public User getByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    @Override
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public void editUser(User user) {
        User temp = repository.findById(user.getId());
        temp.setFirstName(user.getFirstName());
        temp.setId(user.getId());
        temp.setLastName(user.getLastName());
        temp.setPassword(user.getPassword());
    }


    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
