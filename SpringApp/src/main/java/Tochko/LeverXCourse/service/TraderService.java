package Tochko.LeverXCourse.service;

import Tochko.LeverXCourse.models.Trader;
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

//    public User get(Integer id) {
//        return userRepository.findById(id).get();
//    }
//
//    public void delete(Integer id) {
//    	userRepository.deleteById(id);
//    }
}