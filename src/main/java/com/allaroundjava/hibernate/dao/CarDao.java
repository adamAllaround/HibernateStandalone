package com.allaroundjava.hibernate.dao;

import com.allaroundjava.hibernate.model.Car;

interface CarDao {
    Car getById(Long id);
    Long persist(Car c);
}
