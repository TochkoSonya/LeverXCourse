package leverXCourse.service.impl;

import leverXCourse.models.Trader;
import leverXCourse.repository.TraderRepository;
import leverXCourse.service.TraderService;
import leverXCourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TraderServiceImpl implements TraderService {

    private final TraderRepository traderRepository;
    private final UserService userService;

    @Autowired
    public TraderServiceImpl(TraderRepository traderRepository,
                             UserService userService) {
        this.traderRepository = traderRepository;
        this.userService = userService;
    }

    @Override
    public void save(Trader trader, String title, String description) {
        trader.setTitle(title);
        trader.setDescription(description);
        trader.setUser(userService.get(9));
        traderRepository.save(trader);
    }

    @Override
    public void save(Trader trader) {
        traderRepository.save(trader);
    }

    @Override
    public List<Trader> listAll() {
        return traderRepository.findAll();
    }

    @Override
    public Trader get(Integer id) {
        return traderRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        traderRepository.delete(id);
    }

    @Override
    public List<Trader> findTraderWithActiveStatus() {
        return traderRepository.findTraderWithActiveStatus();
    }

    @Override
    public List<Trader> listTraderByUserId(int userId) {
        return traderRepository.findTraderByUserId(userId);
    }
}