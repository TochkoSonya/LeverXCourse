package leverXCourse.service;

import leverXCourse.models.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void save(User user, String password);

    List<User> listAll();

    User get(Integer id);

    User findByEmailAndPassword(String email, int password);
}
