package com.viktor.springboot.dao;

import com.viktor.springboot.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUserById(int id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("select distinct u FROM User u LEFT JOIN FETCH u.roles", User.class).getResultList();
    }

    @Override
    public User getUserByName(String name) {
        Query query = entityManager.createQuery("select distinct u from User u LEFT JOIN FETCH u.roles where u.name =: name");
        query.setParameter("name", name);
        User user = (User) query.getSingleResult();
        return entityManager.find(User.class, user.getId());
    }
}
