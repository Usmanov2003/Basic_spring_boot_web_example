package com.business.dao;

import com.business.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class ProductDAO {

    private EntityManager entityManager;

    public ProductDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("YourPersistenceUnitName");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void createProduct(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    public Product getProductById(int productId) {
        return entityManager.find(Product.class, productId);
    }

    public void updateProduct(Product product) {
        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();
    }

    public void deleteProduct(int productId) {
        Product product = getProductById(productId);
        if (product != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(product);
            entityManager.getTransaction().commit();
        }
    }
}
