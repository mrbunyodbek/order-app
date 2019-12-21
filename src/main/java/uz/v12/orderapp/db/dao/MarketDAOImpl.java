package uz.v12.orderapp.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.v12.orderapp.db.entities.Market;
import uz.v12.orderapp.db.dao.interfaces.MarketDAO;
import uz.v12.orderapp.db.repos.MarketRepository;

import java.util.List;

@Service
public class MarketDAOImpl implements MarketDAO {
    private MarketRepository repository;


    @Autowired
    public MarketDAOImpl(MarketRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Market> getAll() {
        return repository.findAll();
    }


    @Override
    public Market getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Market getById(int id) {
        return repository.findById(id);
    }

    @Override
    public void saveMarket(Market market) {
        repository.save(market);
    }

    @Override
    public void editMarket(Market market) {
        Market temp = repository.findById(market.getId());
        temp.setName(market.getName());
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
