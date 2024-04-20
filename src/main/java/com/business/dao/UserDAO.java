package com.business.dao;

import com.business.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDAO {

    private EntityManager entityManager;

    public UserDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("YourPersistenceUnitName");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void createUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public User getUserById(int userId) {
        return entityManager.find(User.class, userId);
    }

    public void updateUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    public void deleteUser(int userId) {
        User user = getUserById(userId);
        if (user != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        }
    }
}
