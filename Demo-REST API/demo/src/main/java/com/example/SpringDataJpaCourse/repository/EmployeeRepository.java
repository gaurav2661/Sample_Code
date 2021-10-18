package com.example.SpringDataJpaCourse.repository;

import com.example.SpringDataJpaCourse.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long>  {
}
