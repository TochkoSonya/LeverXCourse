package Tochko.LeverXCourse.repository;
import Tochko.LeverXCourse.models.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface TraderRepository extends JpaRepository<Trader, Serializable>{
}
