package com.railway.helloworld.controllers.CourseManagementControllers;

import com.railway.helloworld.models.Course;
import com.railway.helloworld.models.User;
import com.railway.helloworld.repositories.CourseRepository;
import com.railway.helloworld.repositories.UserRepository;
import com.railway.helloworld.services.impl.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/enrollment")

public class EnrollmentController {

    private EnrollmentService enrollmentService;
    private UserRepository userRepository;
    private CourseRepository courseRepository;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService, UserRepository userRepository, CourseRepository courseRepository) {
        this.enrollmentService = enrollmentService;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

}
