package Tochko.LeverXCourse.service;
import Tochko.LeverXCourse.models.User;
import Tochko.LeverXCourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User get(int id) {
        return userRepository.findOne(id);
    }

    public User findByEmailAndPassword(String email, int password) {
        return userRepository.findByEmailAndPassword(email, password); }

}