package com.railway.helloworld.services.impl;

import com.railway.helloworld.dto.CourseDto;
import com.railway.helloworld.models.Course;
import com.railway.helloworld.models.Tutor;
import com.railway.helloworld.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService{

    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void create(CourseDto courseDto) throws Exception{




    }

    public void update(Course course, Long courseId) {
        Course currentCourse = courseRepository.findById(courseId).get();

        currentCourse.setCourseName(course.getCourseName());
        currentCourse.setCourseDescription(course.getCourseDescription());
        currentCourse.setCourseDetail(course.getCourseDetail());
        currentCourse.setCourseDifficulty(course.getCourseDifficulty());
        currentCourse.setCourseUrl(course.getCourseUrl());
        currentCourse.setImgUrl(course.getImgUrl());
        currentCourse.setTutor(course.getTutor());

        courseRepository.save(currentCourse);

    }

    public void delete(Course course) { courseRepository.delete(course); }


    public List<Course> getAll() {
        return courseRepository.findAll();
    }


    public List<Course> listAllPublished() {
        return courseRepository.findByPublishedTrue();
    }

    public Optional<Object> getBySlug(String slug) {

        return null;
    }
}

