package com.example.SpringDataJpaCourse.repository;

import com.example.SpringDataJpaCourse.entity.Passport;
import org.springframework.data.repository.CrudRepository;

public interface PassportRepository extends CrudRepository<Passport,Long> {
}
