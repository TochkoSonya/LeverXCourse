package leverXCourse.service.impl;

import leverXCourse.models.Role;
import leverXCourse.models.Status;
import leverXCourse.models.User;
import leverXCourse.repository.UserRepository;
import leverXCourse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void save(User user, String password) {
        user.setRole(Role.TRADER);
        user.setStatus(Status.PROCESSING);
        user.setPassword(password.hashCode());
        userRepository.save(user);
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public User get(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findByEmailAndPassword(String email, int password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}