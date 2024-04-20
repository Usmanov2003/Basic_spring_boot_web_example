package com.business.dao;

import com.business.entities.Orders;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OrdersDAO {

    private EntityManager entityManager;

    public OrdersDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("YourPersistenceUnitName");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void createOrders(Orders orders) {
        entityManager.getTransaction().begin();
        entityManager.persist(orders);
        entityManager.getTransaction().commit();
    }

    public Orders getOrdersById(int orderId) {
        return entityManager.find(Orders.class, orderId);
    }

    public void updateOrders(Orders orders) {
        entityManager.getTransaction().begin();
        entityManager.merge(orders);
        entityManager.getTransaction().commit();
    }

    public void deleteOrders(int orderId) {
        Orders orders = getOrdersById(orderId);
        if (orders != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(orders);
            entityManager.getTransaction().commit();
        }
    }
}
