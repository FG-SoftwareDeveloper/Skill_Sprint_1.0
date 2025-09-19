
package com.railway.helloworld.models;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "courses", indexes = {
        @Index(name = "ux_courses_slug", columnList = "slug", unique = true)
})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true, length = 200)
    private String slug;


    @Column(nullable = false, length = 255)
    private String title;


    @Column(length = 2000)
    private String summary;

    @Column(nullable = false)
    private boolean published = false;


    @Column(name = "hero_image_url", length = 512)
    private String heroImageUrl;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, columnDefinition = "timestamp with time zone")
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false, columnDefinition = "timestamp with time zone")
    private OffsetDateTime updatedAt;

    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_description")
    private String courseDescription;
    @Column(name = "course_detail")
    private String courseDetail;
    @Column(name = "course_difficulty")
    private String courseDifficulty;
    @Column(name = "course_url")
    private String courseUrl;
    @Column(name = "img_url")
    private String imgUrl;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    public Course(String courseName, String courseDescription, String courseDetail, String courseDifficulty, String courseUrl, String imgUrl, Tutor tutor) {
        // Required by JPA
    }

    public Course(String slug, String title, String summary) {
        this.slug = slug;
        this.title = title;
        this.summary = summary;
    }

    public Long getId() { return id; }

    public String getSlug() { return slug; }
    public String getTitle() { return title; }
    public String getSummary() { return summary; }
    public boolean isPublished() { return published; }
    public String getHeroImageUrl() { return heroImageUrl; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public OffsetDateTime getUpdatedAt() { return updatedAt; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setSummary(String summary){
        this.summary = summary;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public void setHeroImageUrl(String heroImageUrl) {
        this.heroImageUrl = heroImageUrl;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Getters and setters
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getCourseDescription() { return courseDescription; }
    public void setCourseDescription(String courseDescription) { this.courseDescription = courseDescription; }

    public String getCourseDetail() { return courseDetail; }
    public void setCourseDetail(String courseDetail) { this.courseDetail = courseDetail; }

    public String getCourseDifficulty() { return courseDifficulty; }
    public void setCourseDifficulty(String courseDifficulty) { this.courseDifficulty = courseDifficulty; }

    public String getCourseUrl() { return courseUrl; }
    public void setCourseUrl(String courseUrl) { this.courseUrl = courseUrl; }

    public String getImgUrl() { return imgUrl; }
    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }

    public Tutor getTutor() { return tutor; }
    public void setTutor(Tutor tutor) { this.tutor = tutor; }
}


