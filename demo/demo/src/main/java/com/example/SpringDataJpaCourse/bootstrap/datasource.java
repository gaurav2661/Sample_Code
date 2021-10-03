package com.example.SpringDataJpaCourse.bootstrap;

import com.example.SpringDataJpaCourse.entity.Course;
import com.example.SpringDataJpaCourse.entity.Passport;
import com.example.SpringDataJpaCourse.entity.Review;
import com.example.SpringDataJpaCourse.entity.Student;
import com.example.SpringDataJpaCourse.repository.CourseRepository;
import com.example.SpringDataJpaCourse.repository.PassportRepository;
import com.example.SpringDataJpaCourse.repository.ReviewRepository;
import com.example.SpringDataJpaCourse.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Component
public class datasource implements ApplicationListener<ContextRefreshedEvent> {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final PassportRepository passportRepository;
    private final ReviewRepository reviewRepository;

    public datasource(CourseRepository courseRepository, StudentRepository studentRepository,
                      PassportRepository passportRepository, ReviewRepository reviewRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.passportRepository = passportRepository;
        this.reviewRepository = reviewRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        setData();
    }
    private void setData() {
        List<Student> studentList=new ArrayList<>();

        Student student1 = new Student();
        Student student6 = new Student();
        Student student5 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();

        Course d = new Course();
        Course c = new Course();
        Course f = new Course();
        Course e = new Course();
        Course b = new Course();
        Course a = new Course();

        List<Course> courseList = new ArrayList<>(2);



        c.setId(800197L);
        c.setName("Learn Python like a Professional Start from the basics and go all the way to creating your own applications and games");
        courseList.add(c);


        d.setId(800198L);
        d.setName("Spring Framework");
        d.setCreatedDate(LocalDateTime.now());
        d.setLastUpdatedDate(LocalDateTime.now());
        courseList.add(d);


        a.setId(800199L);
        a.setName("Excel with this A-Z Microsoft Excel Course. Microsoft Excel 2010, 2013, 2016, Excel 2019 and Office 365");
        a.setCreatedDate(LocalDateTime.now());
        a.setLastUpdatedDate(LocalDateTime.now());
        courseList.add(a);


        b.setId(800200L);
        b.setName("Pass the AWS Certified Solutions Architect Associate Certification SAA-C02. Complete Amazon Web Services Cloud training!");
        b.setCreatedDate(LocalDateTime.now());
        b.setLastUpdatedDate(LocalDateTime.now());
        courseList.add(b);


        f.setId(800201L);
        f.setCreatedDate(LocalDateTime.now());
        f.setLastUpdatedDate(LocalDateTime.now());
        f.setName("Learn to create Machine Learning Algorithms in Python and R from two Data Science experts. Code templates included.");
        courseList.add(f);


        e.setId(800202L);
        e.setCreatedDate(LocalDateTime.now());
        e.setLastUpdatedDate(LocalDateTime.now());
        e.setName("Complete Data Science Training: Mathematics, Statistics, Python, Advanced Statistics in Python, Machine & Deep Learning");
        courseList.add(e);

        a.addStudents(student1);
        b.addStudents(student1);
        c.addStudents(student1);
        a.addStudents(student3);

        courseRepository.saveAll(courseList);


        student1.setId(1415031001L);
        student2.setId(1415031002L);
        student3.setId(1415031003L);
        student4.setId(14150310014L);
        student5.setId(1415031005L);
        student6.setId(1415031006L);
        student1.setName("Leonardo DiCaprio");
        student2.setName("Johnny Depp");
        student3.setName("Robert Downey Jr.");
        student4.setName("Robin Williams");
        student5.setName("Tom Cruise");
        student6.setName("Harrison Ford ");

        student1.addCourses(a);
        student1.addCourses(b);
        student1.addCourses(d);
        student3.addCourses(f);

        List<Passport> passportList = new ArrayList<>();
        Passport passport1 = new Passport();
        Passport passport2 = new Passport();
        Passport passport3 = new Passport();
        Passport passport4 = new Passport();
        Passport passport5 = new Passport();
        Passport passport6 = new Passport();

        passport1.setNumber("5959JJNLC2");
        passport2.setNumber("F8624KW3J6");
        passport3.setNumber("10123NXWP9");
        passport4.setNumber("F424R4W990");
        passport5.setNumber("F424R4W991");
        passport6.setNumber("1327M3YY51");

      passport1.setStudent(student2);
        passport2.setStudent(student4);
        passport3.setStudent(student6);
        passport4.setStudent(student1);
        passport5.setStudent(student3);
        passport6.setStudent(student5);


        passportList.add(passport1);
        passportList.add(passport2);
        passportList.add(passport3);
        passportList.add(passport4);
        passportList.add(passport5);
        passportList.add(passport6);

        passportRepository.saveAll(passportList);


        logger.info("  student from passport"+passport1.getStudent());


        student1.setPassport(passport1);
        student2.setPassport(passport4);
        student3.setPassport(passport6);
        student4.setPassport(passport5);
        student5.setPassport(passport3);
        student6.setPassport(passport2);

        logger.info("passport from student"+student1.getPassport());

        studentList.add(student1);

        studentList.add(student2);

        studentList.add(student3);

        studentList.add(student4);

        studentList.add(student5);

        studentList.add(student6);



        studentRepository.saveAll(studentList);


        List<Review> reviewList = new ArrayList<>(10);
        Review review = new Review();
        Review review1 = new Review();
        Review review2 = new Review();
        Review review4= new Review();
        Review review3 = new Review();
        Review review5 = new Review();
        Review review6 = new Review();
        Review review7 = new Review();
        Review review8 = new Review();
        Review review9 = new Review();


        review.setDescription("I’m thinking of taking computer classes and wanted to get a head start before beginning" +
                " so I’m not lost when I start. I was looking for some sort of book that wasn’t written for computer " +
                "geniuses so I could actually understand what I was reading. I’m not a total idiot and know what I’m" +
                " doing for the most part but am far from an expert. I saw this one and after checking out the table " +
                "of contents decided to give it a shot since it wasn’t too expensive and am glad that I did. It’s very " +
                "easy to follow and covers a lot of subjects in detail and really cleared some things up for me. I’ll" +
                " probably end up reading it again to get more out of it.");
        review1.setDescription("I've read a few books on basic computer skills and this is one of the better ones. It " +
                "covers a lot of topics and its pretty easy to follow. I like that is has a lot of screenshots showing " +
                "you how to do things which makes it easier to follow.");
        review2.setDescription("I usually prefer the training video thing when it comes to learning new stuff but " +
                "lately I have switched to books because they tend to go into more detail and its easier to go back " +
                "and re-read something rather than rewind the video watch that section again. I got this and 3 other" +
                " books for computer skills including and actual dummies book called PCs for Dummies but I like this" +
                " one better because its more to the point and avoids all the extra stuff you don't care about.");
        review3.setDescription("I got this book thinking I was going to give it to my mom to help her learn more about " +
                "computers (and to save me some of that time spent answering her questions over the phone). But after I" +
                " got it and started reading through it, I found that I was able to actually learn some new things from " +
                "it. Some of the information is a little too advanced for my mom, but I'm going to have her read it" +
                " anyway because there are some sections that she will really benefit from. If you are a computer dummy" +
                " then reading this will definitely help to get you out of that category.");
        review4.setDescription("I have been using PC's since they were the size of an RV kitchen appliance - only a user" +
                ", never an expert, and I've done more than my share of crying and swearing over all those funky things" +
                " that can happen through the course of regular use. With no desire to understand everything about them," +
                " this book actually was ideal balance between a good overview and full technical explanations. I did " +
                "learn more than I expected, and it will be a good, ongoing reference guide to doing my own basic" +
                " troubleshooting before calling in the real (good) geeks");
        review5.setDescription("I really ordered this because I want to strengthen my computer skills. This book " +
                "is not doing it for me.\n" +
                "I was hoping to see a diagram of the keyboard with explanation of the function (F) keys. None found.\n" +
                "In other words specific needs were not addressed.");
        review6.setDescription("I HAVE YEARS OF EXPERIENCE AND LEFT DUMMY BOOKS BEHIND LONG AGO. YEARS AGO" +
                ". BUT BERNSTEIN'S BOOK BEGINS ON GEEK LEVEL. HE USES TERMS I AM NOT FAMILIAR WITH AND I" +
                " HAVE A MASTER'S DEGREE. MISLEADING TITLE TO SAY THE VERY LEAST. NO HELP IN THIS BOOK" +
                " FOR A REAL BEGINNER. SHOUTED, VISION PROBLEM. NEEDLESS TO SAY I WILL NOT BUY ANY MORE OF HIS BOOKS.");
        review7.setDescription("Not for a person who does not have command of the basic terminology the autho" +
                "r uses in explaining various techniques. The minimal definitions offered by the author are not " +
                "nearly sufficient. This is not an entry level book. Yes, there are people who need a \"beginning\".");
        review8.setDescription("This book is text heavy with few images making it a pain to read. This could have" +
                " been so much better if he used bulleted points, more diagrams, etc. Also, about a third of this " +
                "is about Windows OS. If you use a mac or chrome book, then this information is useless.");
        review9.setDescription("This book is very basic, which is good. I agree that an explanation of the " +
                "F keys is needed. But even more important is an index. Come on, a book like this must have" +
                " an index. Numerous times I would think of something and thumb to where the index should be." +
                " If I knew there was no index, I would not have bought it. With an index, I would give it 5 stars");

        review.setRating(5);
        review1.setRating(4.6);
        review2.setRating(4.8);
        review3.setRating(4.4);
        review4.setRating(4.6);
        review5.setRating(3.9);
        review6.setRating(3.3);
        review7.setRating(3.5);
        review8.setRating(3.7);
        review9.setRating(3.8);

        review.setCourse(a);
        review1.setCourse(f);
        review2.setCourse(b);
        review3.setCourse(d);
        review4.setCourse(e);
        review5.setCourse(a);
        review6.setCourse(c);
        review7.setCourse(f);
        review8.setCourse(b);
        review9.setCourse(d);


        reviewList.add(review);
        reviewList.add(review1);
        reviewList.add(review2);
        reviewList.add(review3);
        reviewList.add(review4);
        reviewList.add(review5);
        reviewList.add(review6);
        reviewList.add(review7);
        reviewList.add(review9);
        reviewList.add(review8);
        reviewRepository.saveAll(reviewList);









    }

}
