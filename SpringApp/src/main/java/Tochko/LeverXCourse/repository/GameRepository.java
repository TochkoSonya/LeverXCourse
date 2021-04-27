package Tochko.LeverXCourse.repository;

import Tochko.LeverXCourse.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface GameRepository extends JpaRepository<Game, Serializable> {
}
