package com.railway.helloworld.services.impl;

import com.railway.helloworld.dto.CourseDto;
import com.railway.helloworld.dto.TutorDto;
import com.railway.helloworld.models.Course;
import com.railway.helloworld.models.Tutor;
import com.railway.helloworld.repositories.CourseRepository;
import com.railway.helloworld.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CourseService {

    private final CourseRepository courseRepository;
    private final TutorRepository tutorRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, TutorRepository tutorRepository) {
        this.courseRepository = courseRepository;
        this.tutorRepository = tutorRepository;
    }

    public CourseDto create(CourseDto courseDto) {
        try {
            // Validate input
            if (courseDto == null) {
                throw new IllegalArgumentException("Course data cannot be null");
            }
            
            // Check if slug already exists
            Course existingCourse = courseRepository.findBySlug(courseDto.getSlug());
            if (existingCourse != null) {
                throw new IllegalArgumentException("Course with slug '" + courseDto.getSlug() + "' already exists");
            }
            
            // Find the tutor
            Tutor tutor = tutorRepository.findById(courseDto.getTutor().id)
                    .orElseThrow(() -> new IllegalArgumentException("Tutor not found with ID: " + courseDto.getTutor().id));
            
            // Create new course entity
            Course course = new Course();
            course.setTitle(courseDto.getTitle());
            course.setCourseName(courseDto.getCourseName());
            course.setCourseDescription(courseDto.getCourseDescription());
            course.setSummary(courseDto.getSummary());
            course.setCourseDetail(courseDto.getDetail());
            course.setCourseDifficulty(courseDto.getDifficulty());
            course.setSlug(courseDto.getSlug());
            course.setCourseUrl("/courses/" + courseDto.getSlug());
            course.setImgUrl(courseDto.getImgUrl());
            course.setHeroImageUrl(courseDto.getHeroImageUrl());
            course.setPublished(courseDto.getPublished() != null ? courseDto.getPublished() : true);
            course.setTutor(tutor);
            
            // Save the course
            Course savedCourse = courseRepository.save(course);
            
            // Convert back to DTO
            return convertToDto(savedCourse);
            
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create course: " + e.getMessage(), e);
        }
    }

    public CourseDto update(Long courseId, CourseDto courseDto) {
        try {
            Course existingCourse = courseRepository.findById(courseId)
                    .orElseThrow(() -> new IllegalArgumentException("Course not found with ID: " + courseId));

            // Check if slug is changing and if new slug already exists
            if (!existingCourse.getSlug().equals(courseDto.getSlug())) {
                Course courseWithSameSlug = courseRepository.findBySlug(courseDto.getSlug());
                if (courseWithSameSlug != null && !courseWithSameSlug.getId().equals(courseId)) {
                    throw new IllegalArgumentException("Course with slug '" + courseDto.getSlug() + "' already exists");
                }
            }

            // Find the tutor if tutor is being updated
            if (courseDto.getTutor() != null && courseDto.getTutor().id != null) {
                Tutor tutor = tutorRepository.findById(courseDto.getTutor().id)
                        .orElseThrow(() -> new IllegalArgumentException("Tutor not found with ID: " + courseDto.getTutor().id));
                existingCourse.setTutor(tutor);
            }

            // Update course fields
            existingCourse.setTitle(courseDto.getTitle());
            existingCourse.setCourseName(courseDto.getCourseName());
            existingCourse.setCourseDescription(courseDto.getCourseDescription());
            existingCourse.setSummary(courseDto.getSummary());
            existingCourse.setCourseDetail(courseDto.getDetail());
            existingCourse.setCourseDifficulty(courseDto.getDifficulty());
            existingCourse.setSlug(courseDto.getSlug());
            existingCourse.setCourseUrl("/courses/" + courseDto.getSlug());
            existingCourse.setImgUrl(courseDto.getImgUrl());
            existingCourse.setHeroImageUrl(courseDto.getHeroImageUrl());
            if (courseDto.getPublished() != null) {
                existingCourse.setPublished(courseDto.getPublished());
            }

            Course updatedCourse = courseRepository.save(existingCourse);
            return convertToDto(updatedCourse);

        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to update course: " + e.getMessage(), e);
        }
    }

    public void delete(Long courseId) {
        try {
            Course course = courseRepository.findById(courseId)
                    .orElseThrow(() -> new IllegalArgumentException("Course not found with ID: " + courseId));
            courseRepository.delete(course);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete course: " + e.getMessage(), e);
        }
    }

    public CourseDto findById(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course not found with ID: " + courseId));
        return convertToDto(course);
    }

    public List<CourseDto> findAll() {
        return courseRepository.findAllWithTutor().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<CourseDto> findAllPublished() {
        return courseRepository.findByPublishedTrue().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CourseDto findBySlug(String slug) {
        Course course = courseRepository.findBySlug(slug);
        if (course == null) {
            throw new IllegalArgumentException("Course not found with slug: " + slug);
        }
        return convertToDto(course);
    }

    // Helper method to convert Course entity to CourseDto
    private CourseDto convertToDto(Course course) {
        CourseDto dto = new CourseDto();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setCourseName(course.getCourseName());
        dto.setCourseDescription(course.getCourseDescription());
        dto.setSummary(course.getSummary());
        dto.setDetail(course.getCourseDetail());
        dto.setDifficulty(course.getCourseDifficulty());
        dto.setSlug(course.getSlug());
        dto.setUrl(course.getCourseUrl());
        dto.setImgUrl(course.getImgUrl());
        dto.setHeroImageUrl(course.getHeroImageUrl());
        dto.setPublished(course.isPublished());
        
        // Convert tutor to TutorDto
        if (course.getTutor() != null) {
            TutorDto tutorDto = new TutorDto();
            tutorDto.id = course.getTutor().getId();
            tutorDto.name = course.getTutor().getName();
            dto.setTutor(tutorDto);
        }
        
        return dto;
    }

    // Legacy methods for backwards compatibility
    @Deprecated
    public void update(Course course, Long courseId) {
        Course currentCourse = courseRepository.findById(courseId).orElseThrow();
        currentCourse.setCourseName(course.getCourseName());
        currentCourse.setCourseDescription(course.getCourseDescription());
        currentCourse.setCourseDetail(course.getCourseDetail());
        currentCourse.setCourseDifficulty(course.getCourseDifficulty());
        currentCourse.setCourseUrl(course.getCourseUrl());
        currentCourse.setImgUrl(course.getImgUrl());
        currentCourse.setTutor(course.getTutor());
        courseRepository.save(currentCourse);
    }

    @Deprecated
    public void delete(Course course) { 
        courseRepository.delete(course); 
    }

    @Deprecated
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Deprecated
    public List<Course> listAllPublished() {
        return courseRepository.findByPublishedTrue();
    }

    @Deprecated
    public Optional<Course> getBySlug(String slug) {
        return courseRepository.findAll().stream()
                .filter(course -> slug.equals(course.getSlug()))
                .findFirst();
    }
}

