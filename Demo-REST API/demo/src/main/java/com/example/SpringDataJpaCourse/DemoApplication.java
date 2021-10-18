package com.example.SpringDataJpaCourse;

import com.example.SpringDataJpaCourse.managers.CourseManager;
import com.example.SpringDataJpaCourse.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private CourseManager courseManager;
    StudentRepository studentRepository;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) throws Exception {
        logger.info("Course info u enquired  "+courseManager.findById(800199L));
        logger.info("adding a review to a existing course : "+courseManager.addReviewToCourse());

    }
}
