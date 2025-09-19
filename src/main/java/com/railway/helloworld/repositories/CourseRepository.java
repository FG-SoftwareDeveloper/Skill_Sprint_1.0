package com.railway.helloworld.repositories;

import com.railway.helloworld.models.Course;
import com.railway.helloworld.models.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseName(String courseName);

    List<Course> findByPublishedTrue();

    List<Course> findAllByTutor(Tutor tutor);
}