package com.example.SpringDataJpaCourse.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class FullTimeEmployee extends Employee{

    public FullTimeEmployee(){}
    public FullTimeEmployee(String name,BigDecimal salary){
        super(name);
        super.setSalary(salary);

    }


}
