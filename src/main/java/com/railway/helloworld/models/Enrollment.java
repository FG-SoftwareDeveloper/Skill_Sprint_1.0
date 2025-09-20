package com.railway.helloworld.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "enrollment")
public class Enrollment {
    @Id
    @Column(name = "enrollmentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    @Column(name = "date")
    private LocalDate enrollmentDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User userName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "courseId", nullable = false)
    private Course course;

    // Default constructor
    public Enrollment() {}

    public Enrollment(LocalDate enrollmentDate, User userName, Course course) {
        this.enrollmentDate = enrollmentDate;
        this.userName = userName;
        this.course = course;
    }

    // Getters and setters
    public Long getId() { return enrollmentId; }
    public void setId(Long enrollmentId) { this.enrollmentId = enrollmentId; }

    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(LocalDate enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    public User getUser() { return userName; }
    public void setUser(User userName) { this.userName = userName; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
