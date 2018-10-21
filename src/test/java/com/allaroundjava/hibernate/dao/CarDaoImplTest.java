package com.allaroundjava.hibernate.dao;

import com.allaroundjava.hibernate.model.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class CarDaoImplTest {

    private static final String PERSISTENCE_UNIT_NAME = "hibernatePlayground";
    private CarDao carDao;
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    @Before
    public void setUp() {
        carDao = new CarDaoImpl(entityManagerFactory);
    }

    @Test
    public void whenPersistingNewCar_thenIdIsAssigned() {
        Car car = new Car();
        car.setMake("Honda");
        car.setModel("Civic");
        car.setManufacturedAt(LocalDate.of(2018, 10, 21));
        Long carId = carDao.persist(car);

        Assert.assertNotNull(carId);// Id is set when Car is persisted and it's assigned
        //even though there's no setId method.
    }

    @Test
    public void havingCarBeingPersisted_whenGetCarById_thenValidCarIsReturned() {
        //having
        Car car = new Car();
        car.setMake("Mini");
        car.setModel("Cooper");
        car.setManufacturedAt(LocalDate.of(2018, 9, 21));
        Long carId = carDao.persist(car);

        //when
        Car result = carDao.getById(carId);

        //then
        Assert.assertEquals(car.getId(), result.getId());
        Assert.assertEquals(car.getMake(), result.getMake());
    }
}