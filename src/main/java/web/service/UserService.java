package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;
@Service
public interface UserService {

    List<User> findAll();

    void save(User user);

    User findOne(Long id);

    void update(Long id, User updateUser);

    void delete(Long id);

}

