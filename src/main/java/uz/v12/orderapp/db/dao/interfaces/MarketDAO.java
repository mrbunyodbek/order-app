package uz.v12.orderapp.db.dao.interfaces;

import uz.v12.orderapp.db.entities.Market;

import java.util.List;

public interface MarketDAO {
    List<Market> getAll();

    Market getByName(String name);

    Market getById(int id);

    void saveMarket(Market market);

    void editMarket(Market market);

    void deleteById(Integer id);
}
