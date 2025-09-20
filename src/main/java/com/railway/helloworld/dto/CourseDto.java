package com.railway.helloworld.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(description = "Course Data Transfer Object")
public class CourseDto {
    
    @Schema(description = "Course ID", example = "1")
    public Long id;
    
    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 255, message = "Title must be between 3 and 255 characters")
    @Schema(description = "Course title", example = "Frontend Programming Fundamentals", required = true)
    public String title;
    
    @NotBlank(message = "Course name is required")
    @Size(min = 3, max = 255, message = "Course name must be between 3 and 255 characters")
    @Schema(description = "Course name", example = "Frontend Programming Fundamentals", required = true)
    public String courseName;
    
    @NotBlank(message = "Course description is required")
    @Size(min = 10, max = 2000, message = "Course description must be between 10 and 2000 characters")
    @Schema(description = "Detailed course description", example = "Master modern frontend development with HTML5, CSS3, JavaScript ES6+, and React.", required = true)
    public String courseDescription;
    
    @NotBlank(message = "Course summary is required")
    @Size(min = 10, max = 500, message = "Course summary must be between 10 and 500 characters")
    @Schema(description = "Course summary", example = "Comprehensive course covering modern frontend development", required = true)
    public String summary;
    
    @Size(max = 2000, message = "Course detail must not exceed 2000 characters")
    @Schema(description = "Detailed course content outline", example = "• HTML5 semantic elements\n• CSS3 features\n• JavaScript ES6+")
    public String detail;
    
    @NotBlank(message = "Difficulty level is required")
    @Pattern(regexp = "^(Beginner|Intermediate|Advanced)$", message = "Difficulty must be one of: Beginner, Intermediate, Advanced")
    @Schema(description = "Course difficulty level", example = "Beginner", allowableValues = {"Beginner", "Intermediate", "Advanced"}, required = true)
    public String difficulty;
    
    @NotBlank(message = "Course URL slug is required")
    @Pattern(regexp = "^[a-z0-9_-]+$", message = "Slug must contain only lowercase letters, numbers, underscores, and hyphens")
    @Schema(description = "Course URL slug", example = "frontend_programming", required = true)
    public String slug;
    
    @Schema(description = "Course URL path", example = "/courses/frontend_programming")
    public String url;
    
    @Schema(description = "Course image URL", example = "/static/img/frontend-course.jpg")
    public String imgUrl;
    
    @Schema(description = "Course hero image URL", example = "/static/img/frontend-hero.jpg")
    public String heroImageUrl;
    
    @Schema(description = "Whether the course is published", example = "true")
    public Boolean published = true;
    
    @NotNull(message = "Tutor is required")
    @Schema(description = "Course tutor information", required = true)
    public TutorDto tutor;
    
    // Constructors
    public CourseDto() {}
    
    public CourseDto(String title, String courseName, String courseDescription, String summary, 
                     String difficulty, String slug, TutorDto tutor) {
        this.title = title;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.summary = summary;
        this.difficulty = difficulty;
        this.slug = slug;
        this.tutor = tutor;
    }

    // Getters and Setters
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    
    public String getCourseDescription() { return courseDescription; }
    public void setCourseDescription(String courseDescription) { this.courseDescription = courseDescription; }
    
    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }
    
    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }
    
    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
    
    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }
    
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    
    public String getImgUrl() { return imgUrl; }
    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }
    
    public String getHeroImageUrl() { return heroImageUrl; }
    public void setHeroImageUrl(String heroImageUrl) { this.heroImageUrl = heroImageUrl; }
    
    public Boolean getPublished() { return published; }
    public void setPublished(Boolean published) { this.published = published; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public TutorDto getTutor() { return tutor; }
    public void setTutor(TutorDto tutor) { this.tutor = tutor; }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}

