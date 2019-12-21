package uz.v12.orderapp.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.v12.orderapp.db.entities.Market;

import java.util.List;

public interface MarketRepository extends JpaRepository<Market, Integer> {


    Market findById(int id);

    Market findByName(String name);

}
