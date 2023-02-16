package web.service;


import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    @Transactional
    public List<User> getUsersList() {
        return userDao.getUsersList();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(int id, User updateUser) {
        userDao.updateUser(id, updateUser); ///  updateUser(id, updateUser);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id); // deleteUser(id);
    }
}

    /////////////////////////////////////////////////////////////////////////////

//    @Override
//    public User showOneUser(int id) {
//        return userDao.show(id);
//    }
//    @Override
//    public void save(User user) {
//        userDao.save(user);
//    }
//    @Override
//    public void update(int id, User updatedUser) { // User updatedUser-- человек пришедший из формы
//        userDao.update(id, updatedUser);
//    }
//    @Override
//    public void delete(int id) {
//        userDao.delete(id);
//    }

