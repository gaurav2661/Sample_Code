package com.example.SpringDataJpaCourse.repository;

import com.example.SpringDataJpaCourse.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long> {


}
