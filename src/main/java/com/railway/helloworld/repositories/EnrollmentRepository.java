package com.railway.helloworld.repositories;

import com.railway.helloworld.models.Course;
import com.railway.helloworld.models.Enrollment;
import com.railway.helloworld.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findAllByCourse(Course course);
    List<Enrollment> findAllByUserName(User user);
    Enrollment findByCourseAndUserName(Course course, User user);
}
