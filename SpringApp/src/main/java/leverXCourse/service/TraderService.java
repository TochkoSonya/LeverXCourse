package leverXCourse.service;

import leverXCourse.models.Trader;
import leverXCourse.repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class TraderService implements CommonService<Trader>{

    @Autowired
    private TraderRepository traderRepository;

    public void save(Trader trader) {
        traderRepository.save(trader);
    }

    public List<Trader> listAll() {
        return traderRepository.findAll();
    }

    public Trader get(Integer id) {
        return traderRepository.findOne(id);
    }

    public void delete(int id) {
    	 traderRepository.delete(id);
    }

    public List<Trader> findTraderWithActiveStatus() {
        return traderRepository.findTraderWithActiveStatus();
    }

    public List<Trader> listTraderByUserId(int userId) {
        return traderRepository.findTraderByUserId(userId);
    }


}