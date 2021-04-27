package Tochko.LeverXCourse.service;

import Tochko.LeverXCourse.models.Game;
import Tochko.LeverXCourse.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public void save(Game game) {
        gameRepository.save(game);
    }

    public List<Game> listAll() {
        return gameRepository.findAll();
    }
}



