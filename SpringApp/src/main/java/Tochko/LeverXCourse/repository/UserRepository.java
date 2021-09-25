package Tochko.LeverXCourse.repository;
import Tochko.LeverXCourse.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    User findByEmailAndPassword(String email, int password);
}
