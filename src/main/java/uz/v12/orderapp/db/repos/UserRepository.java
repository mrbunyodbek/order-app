package uz.v12.orderapp.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.v12.orderapp.db.entities.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();

    User findById(int id);

    User findByLastName(String lastName);

    User findByFirstName(String firstName);

    User findByUsername(String username);

}
