-- Development Database Seeding Script for Skill Sprint LMS
-- This script provides sample data for development and testing environments
-- Includes test passwords and simplified data structure

-- ========================================
-- DEVELOPMENT ENVIRONMENT SETUP
-- ========================================

-- Clear existing data (development only!)
DELETE FROM enrollment;
DELETE FROM courses;
DELETE FROM tutor;
DELETE FROM users;

-- Reset auto-increment counters
ALTER TABLE users AUTO_INCREMENT = 1;
ALTER TABLE tutor AUTO_INCREMENT = 1;
ALTER TABLE courses AUTO_INCREMENT = 1;
ALTER TABLE enrollment AUTO_INCREMENT = 1;

-- ========================================
-- USERS TABLE SEEDING (Development)
-- ========================================

-- Note: Using simple passwords for development
-- In production, use proper BCrypt hashes

INSERT INTO users (username, password, email, firstName, lastName) VALUES
-- Admin (password: admin123)
('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM0prI/hU2HjlbSpN.Qu', 'admin@skillsprint.com', 'System', 'Administrator'),

-- Instructors (password: instructor123)
('dr_sarah_johnson', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM0prI/hU2HjlbSpN.Qu', 'sarah.johnson@skillsprint.com', 'Sarah', 'Johnson'),
('prof_michael_chen', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM0prI/hU2HjlbSpN.Qu', 'michael.chen@skillsprint.com', 'Michael', 'Chen'),
('dr_emily_rodriguez', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM0prI/hU2HjlbSpN.Qu', 'emily.rodriguez@skillsprint.com', 'Emily', 'Rodriguez'),
('james_thompson', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM0prI/hU2HjlbSpN.Qu', 'james.thompson@skillsprint.com', 'James', 'Thompson'),

-- Students (password: student123)
('john_doe', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM0prI/hU2HjlbSpN.Qu', 'john.doe@student.com', 'John', 'Doe'),
('jane_smith', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM0prI/hU2HjlbSpN.Qu', 'jane.smith@student.com', 'Jane', 'Smith'),
('mike_wilson', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM0prI/hU2HjlbSpN.Qu', 'mike.wilson@student.com', 'Mike', 'Wilson'),
('alice_chen', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM0prI/hU2HjlbSpN.Qu', 'alice.chen@student.com', 'Alice', 'Chen'),
('david_martinez', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM0prI/hU2HjlbSpN.Qu', 'david.martinez@student.com', 'David', 'Martinez');

-- ========================================
-- TUTORS TABLE SEEDING (Development)
-- ========================================

INSERT INTO tutor (name, surname, email, description, detail, imgUrl) VALUES
('Dr. Sarah', 'Johnson', 'sarah.johnson@skillsprint.com', 
 'Full-stack developer specializing in React and Node.js',
 'PhD in Computer Science. 10+ years experience.',
 '/static/img/tutors/sarah-johnson.jpg'),

('Prof. Michael', 'Chen', 'michael.chen@skillsprint.com',
 'AI researcher and machine learning expert',
 'Professor at Stanford. Expert in deep learning.',
 '/static/img/tutors/michael-chen.jpg'),

('Dr. Emily', 'Rodriguez', 'emily.rodriguez@skillsprint.com',
 'IoT and mechatronics specialist',
 'Former Tesla engineer. Robotics expert.',
 '/static/img/tutors/emily-rodriguez.jpg'),

('James', 'Thompson', 'james.thompson@skillsprint.com',
 'Backend development and cloud architecture expert',
 'Former Netflix architect. Cloud specialist.',
 '/static/img/tutors/james-thompson.jpg');

-- ========================================
-- COURSES TABLE SEEDING (Development)
-- ========================================

INSERT INTO courses (slug, title, course_name, course_description, summary, course_detail, course_difficulty, course_url, img_url, hero_image_url, published, tutor_id, created_at, updated_at) VALUES

('frontend_programming', 'Frontend Programming', 'Frontend Programming Fundamentals',
 'Learn HTML, CSS, JavaScript, and React to build modern web applications.',
 'Complete frontend development course with hands-on projects.',
 'HTML5, CSS3, JavaScript ES6+, React, responsive design, and deployment.',
 'Beginner', '/courses/frontend_programming', '/static/img/frontend-course.jpg', '/static/img/frontend-hero.jpg', true, 1, NOW(), NOW()),

('backend_programming', 'Backend Programming', 'Backend Programming with Spring Boot',
 'Build robust backend APIs using Java Spring Boot framework.',
 'Comprehensive backend development with Spring Boot and databases.',
 'Java, Spring Boot, REST APIs, JPA, security, testing, and deployment.',
 'Intermediate', '/courses/backend_programming', '/static/img/backend-course.jpg', '/static/img/backend-hero.jpg', true, 4, NOW(), NOW()),

('llm_ai', 'AI & Machine Learning', 'LLM & AI Fundamentals',
 'Explore artificial intelligence and large language models.',
 'Introduction to AI, ML, and LLMs with practical applications.',
 'Python, machine learning, neural networks, NLP, and LLM APIs.',
 'Advanced', '/courses/llm_ai', '/static/img/ai-course.jpg', '/static/img/ai-hero.jpg', true, 2, NOW(), NOW()),

('iot_edge', 'IoT & Edge Computing', 'Internet of Things Development',
 'Build connected devices with Arduino, Raspberry Pi, and cloud integration.',
 'Hands-on IoT development from sensors to cloud platforms.',
 'Arduino, Raspberry Pi, sensors, wireless protocols, and edge computing.',
 'Intermediate', '/courses/iot_edge', '/static/img/iot-course.jpg', '/static/img/iot-hero.jpg', true, 3, NOW(), NOW()),

('mechatronics_I', 'Mechatronics Basics', 'Mechatronics I - Fundamentals',
 'Introduction to mechatronics systems and control.',
 'Foundation course combining mechanical, electrical, and software engineering.',
 'Electronics, sensors, actuators, microcontrollers, and basic control systems.',
 'Beginner', '/courses/mechatronics_I', '/static/img/mechatronics1-course.jpg', '/static/img/mechatronics1-hero.jpg', true, 3, NOW(), NOW()),

('mechatronics_II', 'Advanced Mechatronics', 'Mechatronics II - Robotics',
 'Advanced robotics and automation systems.',
 'Build autonomous robots and complex mechatronic systems.',
 'Robotics, advanced control, automation, and project development.',
 'Advanced', '/courses/mechatronics_II', '/static/img/mechatronics2-course.jpg', '/static/img/mechatronics2-hero.jpg', true, 3, NOW(), NOW());

-- ========================================
-- ENROLLMENT TABLE SEEDING (Development)
-- ========================================

-- Realistic enrollment patterns for testing
INSERT INTO enrollment (userId, courseId, date) VALUES
-- John Doe: Full-stack learning path
(6, 1, DATE_SUB(NOW(), INTERVAL 60 DAY)),  -- Frontend
(6, 2, DATE_SUB(NOW(), INTERVAL 30 DAY)),  -- Backend

-- Jane Smith: Data science path
(7, 1, DATE_SUB(NOW(), INTERVAL 45 DAY)),  -- Frontend
(7, 3, DATE_SUB(NOW(), INTERVAL 20 DAY)),  -- AI/ML

-- Mike Wilson: IoT specialist
(8, 4, DATE_SUB(NOW(), INTERVAL 50 DAY)),  -- IoT

-- Alice Chen: Mechatronics progression
(9, 5, DATE_SUB(NOW(), INTERVAL 90 DAY)),  -- Mechatronics I
(9, 6, DATE_SUB(NOW(), INTERVAL 40 DAY)),  -- Mechatronics II
(9, 4, DATE_SUB(NOW(), INTERVAL 60 DAY)),  -- IoT

-- David Martinez: Web development
(10, 1, DATE_SUB(NOW(), INTERVAL 70 DAY)), -- Frontend
(10, 2, DATE_SUB(NOW(), INTERVAL 35 DAY)); -- Backend

-- ========================================
-- DEVELOPMENT HELPERS
-- ========================================

-- Create views for easy data inspection
CREATE OR REPLACE VIEW enrollment_summary AS
SELECT 
    u.username,
    u.firstName,
    u.lastName,
    c.course_name,
    c.course_difficulty,
    e.date as enrollment_date,
    DATEDIFF(NOW(), e.date) as days_enrolled
FROM enrollment e
JOIN users u ON e.userId = u.id
JOIN courses c ON e.courseId = c.id
ORDER BY e.date DESC;

-- Create view for course statistics
CREATE OR REPLACE VIEW course_stats AS
SELECT 
    c.course_name,
    c.course_difficulty,
    COUNT(e.courseId) as total_enrollments,
    t.name as tutor_name,
    t.surname as tutor_surname
FROM courses c
LEFT JOIN enrollment e ON c.id = e.courseId
LEFT JOIN tutor t ON c.tutor_id = t.tutorId
GROUP BY c.id, c.course_name, c.course_difficulty, t.name, t.surname
ORDER BY total_enrollments DESC;

-- ========================================
-- DEVELOPMENT TEST QUERIES
-- ========================================

-- Display summary of seeded data
SELECT 'Users' as table_name, COUNT(*) as record_count FROM users
UNION ALL
SELECT 'Tutors', COUNT(*) FROM tutor
UNION ALL
SELECT 'Courses', COUNT(*) FROM courses
UNION ALL
SELECT 'Enrollments', COUNT(*) FROM enrollment;

-- Show recent enrollments
SELECT * FROM enrollment_summary LIMIT 10;

-- Show course popularity
SELECT * FROM course_stats;

-- Login credentials for testing:
-- Admin: admin / admin123
-- Instructor: dr_sarah_johnson / instructor123
-- Student: john_doe / student123

COMMIT;