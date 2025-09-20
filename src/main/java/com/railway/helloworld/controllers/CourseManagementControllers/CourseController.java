package com.railway.helloworld.controllers.CourseManagementControllers;

import com.railway.helloworld.dto.CourseDto;
import com.railway.helloworld.dto.TutorDto;
import com.railway.helloworld.repositories.CourseRepository;
import com.railway.helloworld.services.impl.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
@Tag(name = "Courses", description = "Course management and REST API")
public class CourseController {
    
    private final CourseService courseService;
    private final CourseRepository courseRepository;
    
    public CourseController(CourseService courseService, CourseRepository courseRepository) {
        this.courseService = courseService;
        this.courseRepository = courseRepository;
    }

    // Template endpoints
    @GetMapping
    public String courses(Model model) {
        List<CourseDto> courses = courseService.findAllPublished();
        model.addAttribute("courses", courses);
        return "courses";
    }

    @GetMapping("/backend_programming")
    public String backendProgramming(Model model) {
        try {
            CourseDto course = courseService.findBySlug("backend_programming");
            model.addAttribute("course", course);
            return "courses/backend_programming/index";
        } catch (Exception e) {
            return "courses/backend_programming/index";
        }
    }

    @GetMapping("/frontend_programming")
    public String frontendProgramming(Model model) {
        try {
            CourseDto course = courseService.findBySlug("frontend_programming");
            model.addAttribute("course", course);
            return "courses/frontend_programming/index";
        } catch (Exception e) {
            return "courses/frontend_programming/index";
        }
    }

    @GetMapping("/iot_edge")
    public String iotEdge(Model model) {
        try {
            CourseDto course = courseService.findBySlug("iot_edge");
            model.addAttribute("course", course);
            return "courses/iot_edge/index";
        } catch (Exception e) {
            return "courses/iot_edge/index";
        }
    }

    @GetMapping("/llm_ai")
    public String llmAi(Model model) {
        try {
            CourseDto course = courseService.findBySlug("llm_ai");
            model.addAttribute("course", course);
            return "courses/llm_ai/index";
        } catch (Exception e) {
            return "courses/llm_ai/index";
        }
    }

    @GetMapping("/mechatronics_I")
    public String mechatronicsI(Model model) {
        try {
            CourseDto course = courseService.findBySlug("mechatronics_I");
            model.addAttribute("course", course);
            return "courses/mechatronics_I/index";
        } catch (Exception e) {
            return "courses/mechatronics_I/index";
        }
    }

    @GetMapping("/mechatronics_II")
    public String mechatronicsII(Model model) {
        try {
            CourseDto course = courseService.findBySlug("mechatronics_II");
            model.addAttribute("course", course);
            return "courses/mechatronics_II/index";
        } catch (Exception e) {
            return "courses/mechatronics_II/index";
        }
    }

    // REST API endpoints
    @RestController
    @RequestMapping("/api/courses")
    @Tag(name = "Course API", description = "REST API for course CRUD operations")
    public static class CourseRestController {

        private final CourseService courseService;

        public CourseRestController(CourseService courseService) {
            this.courseService = courseService;
        }

        @Operation(summary = "Get all courses", description = "Retrieve a list of all courses")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Successfully retrieved courses",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = CourseDto.class))),
                @ApiResponse(responseCode = "500", description = "Internal server error")
        })
        @GetMapping
        public ResponseEntity<List<CourseDto>> getAllCourses() {
            try {
                List<CourseDto> courses = courseService.findAll();
                return ResponseEntity.ok(courses);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @Operation(summary = "Get published courses", description = "Retrieve a list of all published courses")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Successfully retrieved published courses",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = CourseDto.class))),
                @ApiResponse(responseCode = "500", description = "Internal server error")
        })
        @GetMapping("/published")
        public ResponseEntity<List<CourseDto>> getPublishedCourses() {
            try {
                List<CourseDto> courses = courseService.findAllPublished();
                return ResponseEntity.ok(courses);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @Operation(summary = "Get course by ID", description = "Retrieve a specific course by its ID")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Successfully retrieved course",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = CourseDto.class))),
                @ApiResponse(responseCode = "404", description = "Course not found"),
                @ApiResponse(responseCode = "500", description = "Internal server error")
        })
        @GetMapping("/{id}")
        public ResponseEntity<CourseDto> getCourseById(
                @Parameter(description = "Course ID", required = true) @PathVariable Long id) {
            try {
                CourseDto course = courseService.findById(id);
                return ResponseEntity.ok(course);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.notFound().build();
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @Operation(summary = "Get course by slug", description = "Retrieve a specific course by its URL slug")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Successfully retrieved course",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = CourseDto.class))),
                @ApiResponse(responseCode = "404", description = "Course not found"),
                @ApiResponse(responseCode = "500", description = "Internal server error")
        })
        @GetMapping("/slug/{slug}")
        public ResponseEntity<CourseDto> getCourseBySlug(
                @Parameter(description = "Course URL slug", required = true) @PathVariable String slug) {
            try {
                CourseDto course = courseService.findBySlug(slug);
                return ResponseEntity.ok(course);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.notFound().build();
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @Operation(summary = "Create a new course", description = "Create a new course with the provided information")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201", description = "Course successfully created",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = CourseDto.class))),
                @ApiResponse(responseCode = "400", description = "Invalid input data"),
                @ApiResponse(responseCode = "409", description = "Course with same slug already exists"),
                @ApiResponse(responseCode = "500", description = "Internal server error")
        })
        @PostMapping
        public ResponseEntity<CourseDto> createCourse(
                @Parameter(description = "Course data", required = true) @Valid @RequestBody CourseDto courseDto) {
            try {
                CourseDto createdCourse = courseService.create(courseDto);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().build();
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @Operation(summary = "Update an existing course", description = "Update an existing course with the provided information")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Course successfully updated",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = CourseDto.class))),
                @ApiResponse(responseCode = "400", description = "Invalid input data"),
                @ApiResponse(responseCode = "404", description = "Course not found"),
                @ApiResponse(responseCode = "409", description = "Course with same slug already exists"),
                @ApiResponse(responseCode = "500", description = "Internal server error")
        })
        @PutMapping("/{id}")
        public ResponseEntity<CourseDto> updateCourse(
                @Parameter(description = "Course ID", required = true) @PathVariable Long id,
                @Parameter(description = "Updated course data", required = true) @Valid @RequestBody CourseDto courseDto) {
            try {
                CourseDto updatedCourse = courseService.update(id, courseDto);
                return ResponseEntity.ok(updatedCourse);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.notFound().build();
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @Operation(summary = "Delete a course", description = "Delete an existing course by its ID")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "204", description = "Course successfully deleted"),
                @ApiResponse(responseCode = "404", description = "Course not found"),
                @ApiResponse(responseCode = "500", description = "Internal server error")
        })
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCourse(
                @Parameter(description = "Course ID", required = true) @PathVariable Long id) {
            try {
                courseService.delete(id);
                return ResponseEntity.noContent().build();
            } catch (IllegalArgumentException e) {
                return ResponseEntity.notFound().build();
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
    }

    // Legacy method for backwards compatibility
    public List<CourseDto> list() {
        return courseRepository.findAllWithTutor().stream()
                .map(c -> {
                    CourseDto dto = new CourseDto();
                    dto.id = c.getId();
                    dto.title = c.getTitle();
                    TutorDto t = new TutorDto();
                    t.id = c.getTutor().getId();
                    t.name = c.getTutor().getName();
                    dto.tutor = t;
                    return dto;
                })
                .toList();
    }
}