package com.example.SpringDataJpaCourse.Resources;

import com.example.SpringDataJpaCourse.entity.Course;
import com.example.SpringDataJpaCourse.entity.Student;
import com.example.SpringDataJpaCourse.repository.CourseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseResource {

    private final CourseRepository courseRepository;

    public CourseResource(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping(path = "/allCourses")
    public Iterable<Course> returnAllCourses(){
        return courseRepository.findAll();
    }
    @GetMapping(path = "/findCourse/{courseId}")
    public Course returnCourse(@PathVariable Long courseId){
        Optional<Course> course = courseRepository.findById(courseId);
        if(course.isPresent()){
            return course.get();
        }else{
            throw  new CourseNotFoundException("Course not found for Course ID :"+ courseId);
        }
    }
    @GetMapping(path = "/studentsincourse/{courseId}")
    public List<Student> returnStudentList(@PathVariable Long courseId){
        Optional<Course> course = courseRepository.findById(courseId);
        if(course.isPresent()){
            return course.get().getStudents();
        }else{
            throw  new CourseNotFoundException("Course not found for Course ID :"+ courseId);
        }
    }
    @PostMapping(path = "/createcourse")
    public ResponseEntity<Object> createCourse(@RequestBody Course course){
        Course savedCourse = courseRepository.save(course);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCourse.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
