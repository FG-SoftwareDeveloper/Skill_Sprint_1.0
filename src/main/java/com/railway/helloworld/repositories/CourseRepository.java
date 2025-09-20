package com.railway.helloworld.repositories;

import com.railway.helloworld.models.Course;
import com.railway.helloworld.models.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("select c from Course c join fetch c.tutor")
    List<Course> findAllWithTutor();

    Course findByCourseName(String courseName);
    
    Course findBySlug(String slug);

    List<Course> findByPublishedTrue();

    List<Course> findAllByTutor(Tutor tutor);
}