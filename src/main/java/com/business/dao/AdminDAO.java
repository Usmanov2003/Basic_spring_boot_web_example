package com.business.dao;

import com.business.entities.Admin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManagerFactory;


public class AdminDAO {

    private EntityManager entityManager;

    public AdminDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("YourPersistenceUnitName");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void createAdmin(Admin admin) {
        entityManager.getTransaction().begin();
        entityManager.persist(admin);
        entityManager.getTransaction().commit();
    }

    public Admin getAdminById(int adminId) {
        return entityManager.find(Admin.class, adminId);
    }

    public void updateAdmin(Admin admin) {
        entityManager.getTransaction().begin();
        entityManager.merge(admin);
        entityManager.getTransaction().commit();
    }

    public void deleteAdmin(int adminId) {
        Admin admin = getAdminById(adminId);
        if (admin != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(admin);
            entityManager.getTransaction().commit();
        }
    }
}
