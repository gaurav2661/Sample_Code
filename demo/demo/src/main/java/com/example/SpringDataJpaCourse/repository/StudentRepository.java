package com.example.SpringDataJpaCourse.repository;

import com.example.SpringDataJpaCourse.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
