package com.example.SpringDataJpaCourse.managers;

import com.example.SpringDataJpaCourse.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class EmployeeManager {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager entityManager;

    public void insert(Employee employee){
        entityManager.persist(employee);
    }
}
