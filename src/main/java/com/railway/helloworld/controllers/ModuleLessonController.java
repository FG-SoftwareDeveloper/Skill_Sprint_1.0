package com.railway.helloworld.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// ModuleLessonController.java
@RestController
@RequestMapping("/api/v1")
public class ModuleLessonController {
    @GetMapping("/modules/{moduleId}")
    public Map<String, Object> moduleDetail(@PathVariable Long moduleId) { return Map.of(); }

    @GetMapping("/modules/{moduleId}/lessons")
    public List<Map<String, Object>> moduleLessons(@PathVariable Long moduleId) { return List.of(); }

    @PostMapping("/modules/{moduleId}/lessons")
    public ResponseEntity<?> createLesson(@PathVariable Long moduleId, @RequestBody Map<String, Object> body) {
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/lessons/{lessonId}")
    public Map<String, Object> lessonDetail(@PathVariable Long lessonId) { return Map.of(); }
}
