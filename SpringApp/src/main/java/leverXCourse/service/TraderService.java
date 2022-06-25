package leverXCourse.service;

import leverXCourse.models.Trader;

import java.util.List;

public interface TraderService {

    void save(Trader trader);

    void save(Trader trader, String title, String description);

    List<Trader> listAll();

    Trader get(Integer id);

    void delete(int id);

    List<Trader> findTraderWithActiveStatus();

    List<Trader> listTraderByUserId(int userId);
}
