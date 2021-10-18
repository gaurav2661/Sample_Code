package com.example.SpringDataJpaCourse.repository;

import com.example.SpringDataJpaCourse.entity.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review,Long> {
}
