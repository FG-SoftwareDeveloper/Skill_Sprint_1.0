package com.railway.helloworld.models;

import java.util.List;
import java.util.Optional;

/**
 * Deprecated: replaced by services.CourseService and services.impl.CourseServiceImpl.
 * Left for reference during transition and is not a Spring bean anymore.
 */
@Deprecated
public class CourseService {
    public final List<Course> courses = List.of(
            new Course("backend_programming", "Backend Programming", "APIs, data, auth, and deployments."),
            new Course("frontend_programming", "Frontend Programming", "HTML/CSS/JS + component patterns."),
            new Course("iot_edge", "IoT & Edge", "Sensors, MQTT, Pi/Arduino, and data logging.")
    );

    public List<Course> listAll() {
        return courses;
    }

    public Optional<Course> getBySlug(String slug) {
        return courses.stream().filter(c -> c.getSlug().equals(slug)).findFirst();
    }
}