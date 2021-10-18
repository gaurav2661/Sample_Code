package com.example.SpringDataJpaCourse.managers;

import com.example.SpringDataJpaCourse.entity.Course;
import com.example.SpringDataJpaCourse.entity.Review;
import com.example.SpringDataJpaCourse.repository.CourseRepository;
import com.example.SpringDataJpaCourse.repository.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class CourseManager {

    @Autowired
    EntityManager entityManager;

     private final ReviewRepository reviewRepository;
     private final CourseRepository courseRepository;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public CourseManager(ReviewRepository reviewRepository, CourseRepository courseRepository) {
        this.reviewRepository = reviewRepository;
        this.courseRepository = courseRepository;
    }


    public Course findById(Long id){
        return entityManager.find(Course.class,id);
    }


    public String addReviewToCourse() {
        Course course = findById(800200L);
        logger.info("reviews in this course : "+course);
        Review review = new Review();
        review.setId(800290L);
        review.setDescription("this was awesome course");
        review.setCourse(course);
        courseRepository.save(course);
        reviewRepository.save(review);

        return "Saved";

    }
}
