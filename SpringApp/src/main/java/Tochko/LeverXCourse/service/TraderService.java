package Tochko.LeverXCourse.service;

import Tochko.LeverXCourse.models.Status;
import Tochko.LeverXCourse.models.Trader;
import Tochko.LeverXCourse.models.User;
import Tochko.LeverXCourse.repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class TraderService {

    @Autowired
    private TraderRepository traderRepository;

    public void save(Trader trader) {
        traderRepository.save(trader);
    }

    public List<Trader> listAll() {
        return traderRepository.findAll();
    }

    public Trader get(int id) {
        return traderRepository.findOne(id);
    }

//    public List<Trader> findTraderWithProcessingStatus(Status status) {
//        return traderRepository.findTraderWithProcessingStatus(status.getCode());
//    }

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