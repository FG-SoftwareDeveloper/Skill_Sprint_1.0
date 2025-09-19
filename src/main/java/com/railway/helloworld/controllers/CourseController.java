package com.railway.helloworld.controllers;

import com.railway.helloworld.models.Course;
import com.railway.helloworld.services.impl.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Course> index() {
        return service.listAllPublished();
    }

    @GetMapping("/{slug}")
    public ResponseEntity<Object> detail(@PathVariable String slug) {
        return service.getBySlug(slug)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}