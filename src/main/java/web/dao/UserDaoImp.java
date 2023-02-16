package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsersList() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(int id, User updateUser) {

        User userToBeUpdate = getUserById(id);
        userToBeUpdate.setFirstName(updateUser.getFirstName()); //setName(updateUser.getName());
        userToBeUpdate.setLastName(updateUser.getLastName());
        userToBeUpdate.setEmail(updateUser.getEmail());
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUserById(id));
    }

}



