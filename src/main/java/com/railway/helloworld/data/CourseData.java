package com.railway.helloworld.data;

import com.railway.helloworld.models.Course;
import java.time.OffsetDateTime;
import java.util.List;

public final class CourseData {

    private CourseData() {}

    public static List<Course> all() {
        OffsetDateTime now = OffsetDateTime.now();
        return List.of(
                build("backend_programming",   "Backend Programming",
                        "APIs, data, auth, and deployments with Spring Boot.", now),
                build("frontend_programming",  "Frontend Programming",
                        "HTML/CSS/JS + component patterns and performance.", now),
                build("iot_edge",              "IoT & Edge",
                        "Sensors, MQTT, Pi/Arduino, and data logging.", now),
                build("llm_ai",                "LLM & AI",
                        "Prompting, API integration, and guardrails.", now),
                build("mechatronic_i",         "Mechatronics I",
                        "Circuits, microcontrollers, and motor control.", now),
                build("mechatronics_ii",       "Mechatronics II",
                        "Sensor fusion, PID, and autonomy.", now)
        );
    }

    private static Course build(String slug, String title, String summary, OffsetDateTime t) {
        var c = new Course(slug, title, summary);
        c.setPublished(true);
        c.setHeroImageUrl("/images/courses/" + slug + ".png");
        c.setCreatedAt(t);
        c.setUpdatedAt(t);
        return c;
    }
}
