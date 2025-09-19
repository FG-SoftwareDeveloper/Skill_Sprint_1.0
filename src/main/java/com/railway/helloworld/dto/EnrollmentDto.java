package com.railway.helloworld.dto;

import com.railway.helloworld.models.Course;
import com.railway.helloworld.models.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class EnrollmentDto {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private User user;
    private Course course;
}
