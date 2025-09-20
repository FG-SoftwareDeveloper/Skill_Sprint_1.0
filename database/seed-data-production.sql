-- Production Database Seeding Script for Skill Sprint LMS
-- This script provides comprehensive seed data for production environments
-- Run this after your database schema is created

-- Note: This script uses placeholders for password hashes
-- Replace 'BCRYPT_HASH_PLACEHOLDER' with actual BCrypt hashes in production

-- ========================================
-- USERS TABLE SEEDING
-- ========================================

-- Admin user
INSERT INTO users (username, password, email, firstName, lastName) VALUES
('admin', 'BCRYPT_HASH_PLACEHOLDER', 'admin@skillsprint.com', 'System', 'Administrator');

-- Instructor accounts
INSERT INTO users (username, password, email, firstName, lastName) VALUES
('dr_sarah_johnson', 'BCRYPT_HASH_PLACEHOLDER', 'sarah.johnson@skillsprint.com', 'Sarah', 'Johnson'),
('prof_michael_chen', 'BCRYPT_HASH_PLACEHOLDER', 'michael.chen@skillsprint.com', 'Michael', 'Chen'),
('dr_emily_rodriguez', 'BCRYPT_HASH_PLACEHOLDER', 'emily.rodriguez@skillsprint.com', 'Emily', 'Rodriguez'),
('james_thompson', 'BCRYPT_HASH_PLACEHOLDER', 'james.thompson@skillsprint.com', 'James', 'Thompson'),
('dr_aisha_okonkwo', 'BCRYPT_HASH_PLACEHOLDER', 'aisha.okonkwo@skillsprint.com', 'Aisha', 'Okonkwo'),
('dr_raj_patel', 'BCRYPT_HASH_PLACEHOLDER', 'raj.patel@skillsprint.com', 'Raj', 'Patel');

-- Student accounts (diverse demographics)
INSERT INTO users (username, password, email, firstName, lastName) VALUES
('john_doe', 'BCRYPT_HASH_PLACEHOLDER', 'john.doe@student.com', 'John', 'Doe'),
('jane_smith', 'BCRYPT_HASH_PLACEHOLDER', 'jane.smith@student.com', 'Jane', 'Smith'),
('mike_wilson', 'BCRYPT_HASH_PLACEHOLDER', 'mike.wilson@student.com', 'Mike', 'Wilson'),
('alice_chen', 'BCRYPT_HASH_PLACEHOLDER', 'alice.chen@student.com', 'Alice', 'Chen'),
('david_martinez', 'BCRYPT_HASH_PLACEHOLDER', 'david.martinez@student.com', 'David', 'Martinez'),
('sarah_brown', 'BCRYPT_HASH_PLACEHOLDER', 'sarah.brown@student.com', 'Sarah', 'Brown'),
('robert_garcia', 'BCRYPT_HASH_PLACEHOLDER', 'robert.garcia@professional.com', 'Robert', 'Garcia'),
('lisa_patel', 'BCRYPT_HASH_PLACEHOLDER', 'lisa.patel@professional.com', 'Lisa', 'Patel'),
('kevin_lee', 'BCRYPT_HASH_PLACEHOLDER', 'kevin.lee@professional.com', 'Kevin', 'Lee'),
('maria_gonzalez', 'BCRYPT_HASH_PLACEHOLDER', 'maria.gonzalez@professional.com', 'Maria', 'Gonzalez'),
('ahmed_hassan', 'BCRYPT_HASH_PLACEHOLDER', 'ahmed.hassan@international.com', 'Ahmed', 'Hassan'),
('priya_sharma', 'BCRYPT_HASH_PLACEHOLDER', 'priya.sharma@international.com', 'Priya', 'Sharma'),
('yuki_tanaka', 'BCRYPT_HASH_PLACEHOLDER', 'yuki.tanaka@international.com', 'Yuki', 'Tanaka'),
('elena_petrov', 'BCRYPT_HASH_PLACEHOLDER', 'elena.petrov@international.com', 'Elena', 'Petrov'),
('carlos_silva', 'BCRYPT_HASH_PLACEHOLDER', 'carlos.silva@international.com', 'Carlos', 'Silva');

-- ========================================
-- TUTORS TABLE SEEDING
-- ========================================

INSERT INTO tutor (name, surname, email, description, detail, imgUrl) VALUES
('Dr. Sarah', 'Johnson', 'sarah.johnson@skillsprint.com', 
 'Full-stack developer with 10+ years experience in web technologies. Specializes in React, Node.js, and modern JavaScript frameworks. Former lead developer at Google and Meta.',
 'PhD in Computer Science from MIT. Published author of 3 technical books on web development. Speaker at 50+ international conferences. Mentored over 200 developers.',
 '/static/img/tutors/sarah-johnson.jpg'),

('Prof. Michael', 'Chen', 'michael.chen@skillsprint.com',
 'Machine Learning engineer and AI researcher with 15+ years in the field. Expert in Python, TensorFlow, PyTorch, and deep learning applications.',
 'Professor of AI at Stanford University. Former research scientist at OpenAI and DeepMind. Published 100+ research papers. Expert in NLP, Computer Vision, and Reinforcement Learning.',
 '/static/img/tutors/michael-chen.jpg'),

('Dr. Emily', 'Rodriguez', 'emily.rodriguez@skillsprint.com',
 'IoT and embedded systems specialist with 15+ years in electronics engineering and mechatronics. Expert in Arduino, Raspberry Pi, and industrial automation.',
 'PhD in Electrical Engineering from Caltech. Former senior engineer at Tesla and SpaceX. Specialist in autonomous systems, robotics, and industrial IoT solutions.',
 '/static/img/tutors/emily-rodriguez.jpg'),

('James', 'Thompson', 'james.thompson@skillsprint.com',
 'Backend development expert specializing in Java, Spring Boot, microservices, and database design. 12+ years building scalable enterprise systems.',
 'Senior Software Architect at Netflix and Amazon. Expert in cloud computing, distributed systems, and DevOps. Certified AWS Solutions Architect and Kubernetes specialist.',
 '/static/img/tutors/james-thompson.jpg'),

('Dr. Aisha', 'Okonkwo', 'aisha.okonkwo@skillsprint.com',
 'Cybersecurity expert and ethical hacker with 8+ years protecting enterprise systems. Specialist in penetration testing and security architecture.',
 'PhD in Cybersecurity from Carnegie Mellon. Former security consultant for Fortune 500 companies. CISSP and CEH certified. Expert in blockchain security.',
 '/static/img/tutors/aisha-okonkwo.jpg'),

('Dr. Raj', 'Patel', 'raj.patel@skillsprint.com',
 'Data Science and Analytics expert with 10+ years in business intelligence and big data. Expert in Python, R, SQL, and cloud data platforms.',
 'Former Data Science Director at Microsoft. Expert in machine learning, statistical modeling, and data visualization. Certified in Azure, AWS, and GCP data services.',
 '/static/img/tutors/raj-patel.jpg');

-- ========================================
-- COURSES TABLE SEEDING
-- ========================================

INSERT INTO courses (slug, title, course_name, course_description, summary, course_detail, course_difficulty, course_url, img_url, hero_image_url, published, tutor_id, created_at, updated_at) VALUES

-- Frontend Programming Course
('frontend_programming', 'Frontend Programming Fundamentals', 'Frontend Programming Fundamentals',
 'Master modern frontend development with HTML5, CSS3, JavaScript ES6+, and React. Learn responsive design, performance optimization, and best practices for building user-friendly web applications.',
 'Comprehensive course covering modern frontend development from basics to advanced concepts including React, responsive design, and web performance.',
 '• HTML5 semantic elements and accessibility\n• CSS3 advanced features, Flexbox, and Grid\n• JavaScript ES6+ features and DOM manipulation\n• React.js fundamentals and hooks\n• Responsive design and mobile-first approach\n• Web performance optimization\n• Testing with Jest and React Testing Library\n• Modern build tools (Webpack, Vite)\n• Git version control and deployment strategies',
 'Beginner', '/courses/frontend_programming', '/static/img/frontend-course.jpg', '/static/img/frontend-hero.jpg', true,
 (SELECT tutorId FROM tutor WHERE email = 'sarah.johnson@skillsprint.com'),
 NOW(), NOW()),

-- Backend Programming Course
('backend_programming', 'Backend Programming with Spring Boot', 'Backend Programming with Spring Boot',
 'Build robust backend applications using Java Spring Boot. Learn REST API development, database integration, security, testing, and deployment to cloud platforms.',
 'Master backend development with Spring Boot, covering REST APIs, database integration, security, microservices, and cloud deployment.',
 '• Java fundamentals and object-oriented programming\n• Spring Boot framework and dependency injection\n• REST API design and implementation\n• Spring Data JPA and database integration\n• Spring Security and authentication\n• Unit and integration testing\n• Microservices architecture\n• Docker containerization\n• Cloud deployment (AWS, Azure, GCP)\n• API documentation with OpenAPI/Swagger',
 'Intermediate', '/courses/backend_programming', '/static/img/backend-course.jpg', '/static/img/backend-hero.jpg', true,
 (SELECT tutorId FROM tutor WHERE email = 'james.thompson@skillsprint.com'),
 NOW(), NOW()),

-- AI/ML Course
('llm_ai', 'LLM & AI Fundamentals', 'Large Language Models & AI Fundamentals',
 'Explore the world of artificial intelligence and large language models. Learn machine learning algorithms, neural networks, natural language processing, and practical AI applications.',
 'Comprehensive introduction to AI and machine learning with hands-on projects using Python, TensorFlow, and modern LLM frameworks.',
 '• Python for data science and ML\n• Machine learning fundamentals and algorithms\n• Neural networks and deep learning\n• Natural Language Processing (NLP)\n• Large Language Models (LLMs) and transformers\n• Computer vision basics\n• AI ethics and responsible AI\n• MLOps and model deployment\n• Working with APIs (OpenAI, Hugging Face)\n• Building AI-powered applications',
 'Advanced', '/courses/llm_ai', '/static/img/ai-course.jpg', '/static/img/ai-hero.jpg', true,
 (SELECT tutorId FROM tutor WHERE email = 'michael.chen@skillsprint.com'),
 NOW(), NOW()),

-- IoT Course
('iot_edge', 'IoT & Edge Computing', 'Internet of Things & Edge Computing',
 'Learn to build connected devices and implement edge computing solutions. Cover Arduino, Raspberry Pi, sensors, wireless communication, and industrial IoT applications.',
 'Hands-on course in IoT development covering hardware programming, sensor integration, wireless protocols, and edge computing implementations.',
 '• Electronics fundamentals and circuit design\n• Arduino and Raspberry Pi programming\n• Sensor integration and data acquisition\n• Wireless communication (WiFi, Bluetooth, LoRa)\n• MQTT and IoT protocols\n• Edge computing and real-time processing\n• Cloud IoT platforms (AWS IoT, Azure IoT)\n• Industrial IoT and automation\n• IoT security and best practices\n• Project: Build a complete IoT solution',
 'Intermediate', '/courses/iot_edge', '/static/img/iot-course.jpg', '/static/img/iot-hero.jpg', true,
 (SELECT tutorId FROM tutor WHERE email = 'emily.rodriguez@skillsprint.com'),
 NOW(), NOW()),

-- Mechatronics I Course
('mechatronics_I', 'Mechatronics I - Fundamentals', 'Mechatronics Fundamentals',
 'Introduction to mechatronics systems combining mechanical, electrical, and software engineering. Learn sensors, actuators, control systems, and system integration.',
 'Foundation course in mechatronics covering mechanical systems, electronics, sensors, actuators, and basic control theory.',
 '• Mechanical engineering fundamentals\n• Electronics and circuit analysis\n• Sensors and transducers\n• Actuators and motor control\n• Microcontroller programming\n• PLC programming basics\n• Control theory fundamentals\n• System modeling and simulation\n• CAD design for mechatronic systems\n• Hands-on lab projects and prototyping',
 'Beginner', '/courses/mechatronics_I', '/static/img/mechatronics1-course.jpg', '/static/img/mechatronics1-hero.jpg', true,
 (SELECT tutorId FROM tutor WHERE email = 'emily.rodriguez@skillsprint.com'),
 NOW(), NOW()),

-- Mechatronics II Course
('mechatronics_II', 'Mechatronics II - Advanced Systems', 'Advanced Mechatronics & Robotics',
 'Advanced mechatronics covering robotics, automation, complex control systems, and industrial applications. Build autonomous systems and learn advanced manufacturing concepts.',
 'Advanced course in mechatronics and robotics covering autonomous systems, advanced control, robotics programming, and industrial automation.',
 '• Advanced control systems and PID tuning\n• Robotics kinematics and dynamics\n• Robot programming (ROS)\n• Computer vision for robotics\n• Industrial automation and SCADA\n• Autonomous navigation systems\n• Machine learning for robotics\n• Advanced manufacturing (3D printing, CNC)\n• Project management for engineering\n• Capstone project: Autonomous robot system',
 'Advanced', '/courses/mechatronics_II', '/static/img/mechatronics2-course.jpg', '/static/img/mechatronics2-hero.jpg', true,
 (SELECT tutorId FROM tutor WHERE email = 'emily.rodriguez@skillsprint.com'),
 NOW(), NOW()),

-- Data Science Course
('data_science', 'Data Science & Analytics', 'Data Science & Business Analytics',
 'Master data science techniques using Python, R, and SQL. Learn statistical analysis, data visualization, machine learning, and business intelligence for data-driven decision making.',
 'Comprehensive data science course covering statistical analysis, machine learning, data visualization, and business intelligence using modern tools and techniques.',
 '• Python and R for data analysis\n• SQL and database querying\n• Statistical analysis and hypothesis testing\n• Data cleaning and preprocessing\n• Exploratory data analysis (EDA)\n• Data visualization with Matplotlib, Seaborn, ggplot\n• Machine learning algorithms and evaluation\n• Business intelligence and reporting\n• Big data tools (Spark, Hadoop)\n• Real-world capstone projects',
 'Intermediate', '/courses/data_science', '/static/img/data-science-course.jpg', '/static/img/data-science-hero.jpg', true,
 (SELECT tutorId FROM tutor WHERE email = 'raj.patel@skillsprint.com'),
 NOW(), NOW()),

-- Cybersecurity Course
('cybersecurity', 'Cybersecurity Fundamentals', 'Cybersecurity & Ethical Hacking',
 'Learn cybersecurity fundamentals, ethical hacking, penetration testing, and security architecture. Protect systems and networks from cyber threats with hands-on security labs.',
 'Comprehensive cybersecurity course covering ethical hacking, penetration testing, security architecture, and incident response with practical lab exercises.',
 '• Cybersecurity fundamentals and threat landscape\n• Network security and firewalls\n• Ethical hacking and penetration testing\n• Web application security (OWASP Top 10)\n• Cryptography and encryption\n• Security architecture and design\n• Incident response and forensics\n• Security compliance and frameworks\n• Cloud security best practices\n• Hands-on labs with real security tools',
 'Intermediate', '/courses/cybersecurity', '/static/img/cybersecurity-course.jpg', '/static/img/cybersecurity-hero.jpg', true,
 (SELECT tutorId FROM tutor WHERE email = 'aisha.okonkwo@skillsprint.com'),
 NOW(), NOW());

-- ========================================
-- ENROLLMENT TABLE SEEDING
-- Historical enrollment data with realistic patterns
-- ========================================

-- Sample enrollments with historical dates (past 6 months)
-- Note: Replace user IDs and course IDs with actual values from your database

-- High-demand courses (Frontend, Backend, Data Science)
INSERT INTO enrollment (userId, courseId, date) VALUES
-- Frontend Programming enrollments
((SELECT id FROM users WHERE username = 'john_doe'), (SELECT id FROM courses WHERE slug = 'frontend_programming'), DATE_SUB(NOW(), INTERVAL 120 DAY)),
((SELECT id FROM users WHERE username = 'jane_smith'), (SELECT id FROM courses WHERE slug = 'frontend_programming'), DATE_SUB(NOW(), INTERVAL 90 DAY)),
((SELECT id FROM users WHERE username = 'david_martinez'), (SELECT id FROM courses WHERE slug = 'frontend_programming'), DATE_SUB(NOW(), INTERVAL 100 DAY)),
((SELECT id FROM users WHERE username = 'sarah_brown'), (SELECT id FROM courses WHERE slug = 'frontend_programming'), DATE_SUB(NOW(), INTERVAL 75 DAY)),
((SELECT id FROM users WHERE username = 'lisa_patel'), (SELECT id FROM courses WHERE slug = 'frontend_programming'), DATE_SUB(NOW(), INTERVAL 60 DAY)),
((SELECT id FROM users WHERE username = 'kevin_lee'), (SELECT id FROM courses WHERE slug = 'frontend_programming'), DATE_SUB(NOW(), INTERVAL 45 DAY)),
((SELECT id FROM users WHERE username = 'ahmed_hassan'), (SELECT id FROM courses WHERE slug = 'frontend_programming'), DATE_SUB(NOW(), INTERVAL 30 DAY)),
((SELECT id FROM users WHERE username = 'yuki_tanaka'), (SELECT id FROM courses WHERE slug = 'frontend_programming'), DATE_SUB(NOW(), INTERVAL 15 DAY)),

-- Backend Programming enrollments
((SELECT id FROM users WHERE username = 'john_doe'), (SELECT id FROM courses WHERE slug = 'backend_programming'), DATE_SUB(NOW(), INTERVAL 80 DAY)),
((SELECT id FROM users WHERE username = 'david_martinez'), (SELECT id FROM courses WHERE slug = 'backend_programming'), DATE_SUB(NOW(), INTERVAL 50 DAY)),
((SELECT id FROM users WHERE username = 'robert_garcia'), (SELECT id FROM courses WHERE slug = 'backend_programming'), DATE_SUB(NOW(), INTERVAL 70 DAY)),
((SELECT id FROM users WHERE username = 'kevin_lee'), (SELECT id FROM courses WHERE slug = 'backend_programming'), DATE_SUB(NOW(), INTERVAL 40 DAY)),
((SELECT id FROM users WHERE username = 'carlos_silva'), (SELECT id FROM courses WHERE slug = 'backend_programming'), DATE_SUB(NOW(), INTERVAL 25 DAY)),
((SELECT id FROM users WHERE username = 'mike_wilson'), (SELECT id FROM courses WHERE slug = 'backend_programming'), DATE_SUB(NOW(), INTERVAL 35 DAY)),

-- Data Science enrollments
((SELECT id FROM users WHERE username = 'priya_sharma'), (SELECT id FROM courses WHERE slug = 'data_science'), DATE_SUB(NOW(), INTERVAL 90 DAY)),
((SELECT id FROM users WHERE username = 'jane_smith'), (SELECT id FROM courses WHERE slug = 'data_science'), DATE_SUB(NOW(), INTERVAL 65 DAY)),
((SELECT id FROM users WHERE username = 'lisa_patel'), (SELECT id FROM courses WHERE slug = 'data_science'), DATE_SUB(NOW(), INTERVAL 55 DAY)),
((SELECT id FROM users WHERE username = 'elena_petrov'), (SELECT id FROM courses WHERE slug = 'data_science'), DATE_SUB(NOW(), INTERVAL 40 DAY)),
((SELECT id FROM users WHERE username = 'maria_gonzalez'), (SELECT id FROM courses WHERE slug = 'data_science'), DATE_SUB(NOW(), INTERVAL 20 DAY)),

-- AI/ML enrollments
((SELECT id FROM users WHERE username = 'priya_sharma'), (SELECT id FROM courses WHERE slug = 'llm_ai'), DATE_SUB(NOW(), INTERVAL 30 DAY)),
((SELECT id FROM users WHERE username = 'alice_chen'), (SELECT id FROM courses WHERE slug = 'llm_ai'), DATE_SUB(NOW(), INTERVAL 45 DAY)),
((SELECT id FROM users WHERE username = 'elena_petrov'), (SELECT id FROM courses WHERE slug = 'llm_ai'), DATE_SUB(NOW(), INTERVAL 25 DAY)),
((SELECT id FROM users WHERE username = 'yuki_tanaka'), (SELECT id FROM courses WHERE slug = 'llm_ai'), DATE_SUB(NOW(), INTERVAL 10 DAY)),

-- IoT & Edge Computing enrollments
((SELECT id FROM users WHERE username = 'mike_wilson'), (SELECT id FROM courses WHERE slug = 'iot_edge'), DATE_SUB(NOW(), INTERVAL 85 DAY)),
((SELECT id FROM users WHERE username = 'alice_chen'), (SELECT id FROM courses WHERE slug = 'iot_edge'), DATE_SUB(NOW(), INTERVAL 70 DAY)),
((SELECT id FROM users WHERE username = 'robert_garcia'), (SELECT id FROM courses WHERE slug = 'iot_edge'), DATE_SUB(NOW(), INTERVAL 50 DAY)),

-- Mechatronics courses (sequential learning path)
-- Alice takes Mechatronics I first, then II
((SELECT id FROM users WHERE username = 'alice_chen'), (SELECT id FROM courses WHERE slug = 'mechatronics_I'), DATE_SUB(NOW(), INTERVAL 120 DAY)),
((SELECT id FROM users WHERE username = 'alice_chen'), (SELECT id FROM courses WHERE slug = 'mechatronics_II'), DATE_SUB(NOW(), INTERVAL 60 DAY)),
((SELECT id FROM users WHERE username = 'david_martinez'), (SELECT id FROM courses WHERE slug = 'mechatronics_I'), DATE_SUB(NOW(), INTERVAL 95 DAY)),
((SELECT id FROM users WHERE username = 'sarah_brown'), (SELECT id FROM courses WHERE slug = 'mechatronics_I'), DATE_SUB(NOW(), INTERVAL 80 DAY)),

-- Cybersecurity enrollments
((SELECT id FROM users WHERE username = 'ahmed_hassan'), (SELECT id FROM courses WHERE slug = 'cybersecurity'), DATE_SUB(NOW(), INTERVAL 65 DAY)),
((SELECT id FROM users WHERE username = 'carlos_silva'), (SELECT id FROM courses WHERE slug = 'cybersecurity'), DATE_SUB(NOW(), INTERVAL 45 DAY)),
((SELECT id FROM users WHERE username = 'kevin_lee'), (SELECT id FROM courses WHERE slug = 'cybersecurity'), DATE_SUB(NOW(), INTERVAL 30 DAY)),
((SELECT id FROM users WHERE username = 'maria_gonzalez'), (SELECT id FROM courses WHERE slug = 'cybersecurity'), DATE_SUB(NOW(), INTERVAL 15 DAY));

-- ========================================
-- VERIFICATION QUERIES
-- ========================================

-- Uncomment these queries to verify the data was inserted correctly

-- SELECT COUNT(*) as total_users FROM users;
-- SELECT COUNT(*) as total_tutors FROM tutor;
-- SELECT COUNT(*) as total_courses FROM courses;
-- SELECT COUNT(*) as total_enrollments FROM enrollment;

-- SELECT u.username, c.course_name, e.date
-- FROM enrollment e
-- JOIN users u ON e.userId = u.id
-- JOIN courses c ON e.courseId = c.id
-- ORDER BY e.date DESC
-- LIMIT 10;

COMMIT;