package com.railway.helloworld.services.impl;

import com.railway.helloworld.models.Course;
import com.railway.helloworld.models.Enrollment;
import com.railway.helloworld.models.User;
import com.railway.helloworld.repositories.CourseRepository;
import com.railway.helloworld.repositories.EnrollmentRepository;
import com.railway.helloworld.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EnrollmentService {

    private EnrollmentRepository enrollmentRepository;
    private CourseRepository courseRepository;
    private UserRepository userRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository, CourseRepository courseRepository, UserRepository userRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public void createEnrollment(Long courseId, String username) throws Exception {
        Course course = courseRepository.findById(courseId).get();
        User user = userRepository.findByUsername(username);

        if (null != enrollmentRepository.findByCourseAndUserName(course, user)) {
            throw new Exception("You already enrolled in this course");
        }
        LocalDate date = LocalDate.now();
        Enrollment enrollment = new Enrollment(date, user, course);
        enrollmentRepository.save(enrollment);
    }
}

