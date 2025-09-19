package com.railway.helloworld.data;

          // your JPA entity
import com.railway.helloworld.repositories.CourseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.boot.CommandLineRunner;

@Configuration
@Profile("dev") // runs only when spring.profiles.active=dev
public class DataSeeder {

    @Bean
    CommandLineRunner seedCourses(CourseRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                // optional: de-dup by slug if CourseData may be re-run
                CourseData.all().forEach(c -> {

                });
            }
        };
    }
}