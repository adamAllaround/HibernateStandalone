package com.allaroundjava.hibernate.dao;

import com.allaroundjava.hibernate.model.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class CarDaoImpl implements CarDao {
    private EntityManagerFactory entityManagerFactory;

    CarDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public Car getById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Car car = entityManager.find(Car.class, id);

        transaction.commit();
        entityManager.close();

        return car;
    }

    public Long persist(Car car) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(car);

        transaction.commit();
        entityManager.close();

        return car.getId();
    }
}
