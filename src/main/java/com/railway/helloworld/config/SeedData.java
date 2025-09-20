package com.railway.helloworld.config;

import com.railway.helloworld.models.Course;
import com.railway.helloworld.models.Enrollment;
import com.railway.helloworld.models.Tutor;
import com.railway.helloworld.models.User;
import com.railway.helloworld.repositories.CourseRepository;
import com.railway.helloworld.repositories.EnrollmentRepository;
import com.railway.helloworld.repositories.TutorRepository;
import com.railway.helloworld.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.time.LocalDate;
import java.util.Random;

@Component
public class SeedData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final TutorRepository tutorRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final PasswordEncoder passwordEncoder;

    public SeedData(UserRepository userRepository, 
                   TutorRepository tutorRepository,
                   CourseRepository courseRepository, 
                   EnrollmentRepository enrollmentRepository,
                   PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tutorRepository = tutorRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        seedUsers();
        seedTutors();
        seedCourses();
        seedEnrollments();
    }

    private void seedUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            System.out.println("Seeding users data...");
            
            // Create admin user
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@skillsprint.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setFirstName("System");
            admin.setLastName("Administrator");
            userRepository.save(admin);

            // Create instructor accounts
            User instructor1 = new User();
            instructor1.setUsername("dr_sarah_johnson");
            instructor1.setEmail("sarah.johnson@skillsprint.com");
            instructor1.setPassword(passwordEncoder.encode("instructor123"));
            instructor1.setFirstName("Sarah");
            instructor1.setLastName("Johnson");
            userRepository.save(instructor1);

            User instructor2 = new User();
            instructor2.setUsername("prof_michael_chen");
            instructor2.setEmail("michael.chen@skillsprint.com");
            instructor2.setPassword(passwordEncoder.encode("instructor123"));
            instructor2.setFirstName("Michael");
            instructor2.setLastName("Chen");
            userRepository.save(instructor2);

            User instructor3 = new User();
            instructor3.setUsername("dr_emily_rodriguez");
            instructor3.setEmail("emily.rodriguez@skillsprint.com");
            instructor3.setPassword(passwordEncoder.encode("instructor123"));
            instructor3.setFirstName("Emily");
            instructor3.setLastName("Rodriguez");
            userRepository.save(instructor3);

            User instructor4 = new User();
            instructor4.setUsername("james_thompson");
            instructor4.setEmail("james.thompson@skillsprint.com");
            instructor4.setPassword(passwordEncoder.encode("instructor123"));
            instructor4.setFirstName("James");
            instructor4.setLastName("Thompson");
            userRepository.save(instructor4);

            // Create diverse student profiles
            // Computer Science students
            User student1 = new User();
            student1.setUsername("john_doe");
            student1.setEmail("john.doe@student.com");
            student1.setPassword(passwordEncoder.encode("student123"));
            student1.setFirstName("John");
            student1.setLastName("Doe");
            userRepository.save(student1);

            User student2 = new User();
            student2.setUsername("jane_smith");
            student2.setEmail("jane.smith@student.com");
            student2.setPassword(passwordEncoder.encode("student123"));
            student2.setFirstName("Jane");
            student2.setLastName("Smith");
            userRepository.save(student2);

            User student3 = new User();
            student3.setUsername("mike_wilson");
            student3.setEmail("mike.wilson@student.com");
            student3.setPassword(passwordEncoder.encode("student123"));
            student3.setFirstName("Mike");
            student3.setLastName("Wilson");
            userRepository.save(student3);

            // Engineering students
            User student4 = new User();
            student4.setUsername("alice_chen");
            student4.setEmail("alice.chen@student.com");
            student4.setPassword(passwordEncoder.encode("student123"));
            student4.setFirstName("Alice");
            student4.setLastName("Chen");
            userRepository.save(student4);

            User student5 = new User();
            student5.setUsername("david_martinez");
            student5.setEmail("david.martinez@student.com");
            student5.setPassword(passwordEncoder.encode("student123"));
            student5.setFirstName("David");
            student5.setLastName("Martinez");
            userRepository.save(student5);

            User student6 = new User();
            student6.setUsername("sarah_brown");
            student6.setEmail("sarah.brown@student.com");
            student6.setPassword(passwordEncoder.encode("student123"));
            student6.setFirstName("Sarah");
            student6.setLastName("Brown");
            userRepository.save(student6);

            // Working professionals
            User student7 = new User();
            student7.setUsername("robert_garcia");
            student7.setEmail("robert.garcia@professional.com");
            student7.setPassword(passwordEncoder.encode("student123"));
            student7.setFirstName("Robert");
            student7.setLastName("Garcia");
            userRepository.save(student7);

            User student8 = new User();
            student8.setUsername("lisa_patel");
            student8.setEmail("lisa.patel@professional.com");
            student8.setPassword(passwordEncoder.encode("student123"));
            student8.setFirstName("Lisa");
            student8.setLastName("Patel");
            userRepository.save(student8);

            User student9 = new User();
            student9.setUsername("kevin_lee");
            student9.setEmail("kevin.lee@professional.com");
            student9.setPassword(passwordEncoder.encode("student123"));
            student9.setFirstName("Kevin");
            student9.setLastName("Lee");
            userRepository.save(student9);

            User student10 = new User();
            student10.setUsername("maria_gonzalez");
            student10.setEmail("maria.gonzalez@professional.com");
            student10.setPassword(passwordEncoder.encode("student123"));
            student10.setFirstName("Maria");
            student10.setLastName("Gonzalez");
            userRepository.save(student10);

            // International students
            User student11 = new User();
            student11.setUsername("ahmed_hassan");
            student11.setEmail("ahmed.hassan@international.com");
            student11.setPassword(passwordEncoder.encode("student123"));
            student11.setFirstName("Ahmed");
            student11.setLastName("Hassan");
            userRepository.save(student11);

            User student12 = new User();
            student12.setUsername("priya_sharma");
            student12.setEmail("priya.sharma@international.com");
            student12.setPassword(passwordEncoder.encode("student123"));
            student12.setFirstName("Priya");
            student12.setLastName("Sharma");
            userRepository.save(student12);

            User student13 = new User();
            student13.setUsername("yuki_tanaka");
            student13.setEmail("yuki.tanaka@international.com");
            student13.setPassword(passwordEncoder.encode("student123"));
            student13.setFirstName("Yuki");
            student13.setLastName("Tanaka");
            userRepository.save(student13);

            User student14 = new User();
            student14.setUsername("elena_petrov");
            student14.setEmail("elena.petrov@international.com");
            student14.setPassword(passwordEncoder.encode("student123"));
            student14.setFirstName("Elena");
            student14.setLastName("Petrov");
            userRepository.save(student14);

            User student15 = new User();
            student15.setUsername("carlos_silva");
            student15.setEmail("carlos.silva@international.com");
            student15.setPassword(passwordEncoder.encode("student123"));
            student15.setFirstName("Carlos");
            student15.setLastName("Silva");
            userRepository.save(student15);

            System.out.println("Users seeded successfully! Created 20 users (1 admin, 4 instructors, 15 students)");
        }
    }

    private void seedTutors() {
        List<Tutor> tutors = tutorRepository.findAll();
        if (tutors.isEmpty()) {
            System.out.println("Seeding tutors data...");

            Tutor tutor1 = new Tutor();
            tutor1.setName("Dr. Sarah");
            tutor1.setSurname("Johnson");
            tutor1.setEmail("sarah.johnson@skillsprint.com");
            tutor1.setDescription("Full-stack developer with 10+ years experience in web technologies. Specializes in React, Node.js, and modern JavaScript frameworks. Former lead developer at Google and Meta.");
            tutor1.setDetail("PhD in Computer Science from MIT. Published author of 3 technical books on web development. Speaker at 50+ international conferences. Mentored over 200 developers.");
            tutor1.setImgUrl("/static/img/tutors/sarah-johnson.jpg");
            tutorRepository.save(tutor1);

            Tutor tutor2 = new Tutor();
            tutor2.setName("Prof. Michael");
            tutor2.setSurname("Chen");
            tutor2.setEmail("michael.chen@skillsprint.com");
            tutor2.setDescription("Machine Learning engineer and AI researcher with 15+ years in the field. Expert in Python, TensorFlow, PyTorch, and deep learning applications.");
            tutor2.setDetail("Professor of AI at Stanford University. Former research scientist at OpenAI and DeepMind. Published 100+ research papers. Expert in NLP, Computer Vision, and Reinforcement Learning.");
            tutor2.setImgUrl("/static/img/tutors/michael-chen.jpg");
            tutorRepository.save(tutor2);

            Tutor tutor3 = new Tutor();
            tutor3.setName("Dr. Emily");
            tutor3.setSurname("Rodriguez");
            tutor3.setEmail("emily.rodriguez@skillsprint.com");
            tutor3.setDescription("IoT and embedded systems specialist with 15+ years in electronics engineering and mechatronics. Expert in Arduino, Raspberry Pi, and industrial automation.");
            tutor3.setDetail("PhD in Electrical Engineering from Caltech. Former senior engineer at Tesla and SpaceX. Specialist in autonomous systems, robotics, and industrial IoT solutions.");
            tutor3.setImgUrl("/static/img/tutors/emily-rodriguez.jpg");
            tutorRepository.save(tutor3);

            Tutor tutor4 = new Tutor();
            tutor4.setName("James");
            tutor4.setSurname("Thompson");
            tutor4.setEmail("james.thompson@skillsprint.com");
            tutor4.setDescription("Backend development expert specializing in Java, Spring Boot, microservices, and database design. 12+ years building scalable enterprise systems.");
            tutor4.setDetail("Senior Software Architect at Netflix and Amazon. Expert in cloud computing, distributed systems, and DevOps. Certified AWS Solutions Architect and Kubernetes specialist.");
            tutor4.setImgUrl("/static/img/tutors/james-thompson.jpg");
            tutorRepository.save(tutor4);

            // Additional tutors for more diversity
            Tutor tutor5 = new Tutor();
            tutor5.setName("Dr. Aisha");
            tutor5.setSurname("Okonkwo");
            tutor5.setEmail("aisha.okonkwo@skillsprint.com");
            tutor5.setDescription("Cybersecurity expert and ethical hacker with 8+ years protecting enterprise systems. Specialist in penetration testing and security architecture.");
            tutor5.setDetail("PhD in Cybersecurity from Carnegie Mellon. Former security consultant for Fortune 500 companies. CISSP and CEH certified. Expert in blockchain security.");
            tutor5.setImgUrl("/static/img/tutors/aisha-okonkwo.jpg");
            tutorRepository.save(tutor5);

            Tutor tutor6 = new Tutor();
            tutor6.setName("Dr. Raj");
            tutor6.setSurname("Patel");
            tutor6.setEmail("raj.patel@skillsprint.com");
            tutor6.setDescription("Data Science and Analytics expert with 10+ years in business intelligence and big data. Expert in Python, R, SQL, and cloud data platforms.");
            tutor6.setDetail("Former Data Science Director at Microsoft. Expert in machine learning, statistical modeling, and data visualization. Certified in Azure, AWS, and GCP data services.");
            tutor6.setImgUrl("/static/img/tutors/raj-patel.jpg");
            tutorRepository.save(tutor6);

            System.out.println("Tutors seeded successfully! Created 6 diverse tutors with detailed profiles.");
        }
    }

    private void seedCourses() {
        List<Course> courses = courseRepository.findAll();
        if (courses.isEmpty()) {
            System.out.println("Seeding courses data...");

            // Get tutors by email (since we can't rely on generated IDs)
            List<Tutor> tutors = tutorRepository.findAll();
            Tutor tutor1 = tutors.stream().filter(t -> "sarah.johnson@skillsprint.com".equals(t.getEmail())).findFirst().orElse(null);
            Tutor tutor2 = tutors.stream().filter(t -> "michael.chen@skillsprint.com".equals(t.getEmail())).findFirst().orElse(null);
            Tutor tutor3 = tutors.stream().filter(t -> "emily.rodriguez@skillsprint.com".equals(t.getEmail())).findFirst().orElse(null);
            Tutor tutor4 = tutors.stream().filter(t -> "james.thompson@skillsprint.com".equals(t.getEmail())).findFirst().orElse(null);
            Tutor tutor5 = tutors.stream().filter(t -> "aisha.okonkwo@skillsprint.com".equals(t.getEmail())).findFirst().orElse(null);
            Tutor tutor6 = tutors.stream().filter(t -> "raj.patel@skillsprint.com".equals(t.getEmail())).findFirst().orElse(null);

            // Frontend Programming Course
            Course frontendCourse = new Course();
            frontendCourse.setSlug("frontend_programming");
            frontendCourse.setTitle("Frontend Programming Fundamentals");
            frontendCourse.setCourseName("Frontend Programming Fundamentals");
            frontendCourse.setCourseDescription("Master modern frontend development with HTML5, CSS3, JavaScript ES6+, and React. Learn responsive design, performance optimization, and best practices for building user-friendly web applications.");
            frontendCourse.setSummary("Comprehensive course covering modern frontend development from basics to advanced concepts including React, responsive design, and web performance.");
            frontendCourse.setCourseDetail("• HTML5 semantic elements and accessibility\n• CSS3 advanced features, Flexbox, and Grid\n• JavaScript ES6+ features and DOM manipulation\n• React.js fundamentals and hooks\n• Responsive design and mobile-first approach\n• Web performance optimization\n• Testing with Jest and React Testing Library\n• Modern build tools (Webpack, Vite)\n• Git version control and deployment strategies");
            frontendCourse.setCourseDifficulty("Beginner");
            frontendCourse.setCourseUrl("/courses/frontend_programming");
            frontendCourse.setImgUrl("/static/img/frontend-course.jpg");
            frontendCourse.setHeroImageUrl("/static/img/frontend-hero.jpg");
            frontendCourse.setPublished(true);
            frontendCourse.setTutor(tutor1);
            courseRepository.save(frontendCourse);

            // Backend Programming Course
            Course backendCourse = new Course();
            backendCourse.setSlug("backend_programming");
            backendCourse.setTitle("Backend Programming with Spring Boot");
            backendCourse.setCourseName("Backend Programming with Spring Boot");
            backendCourse.setCourseDescription("Build robust backend applications using Java Spring Boot. Learn REST API development, database integration, security, testing, and deployment to cloud platforms.");
            backendCourse.setSummary("Master backend development with Spring Boot, covering REST APIs, database integration, security, microservices, and cloud deployment.");
            backendCourse.setCourseDetail("• Java fundamentals and object-oriented programming\n• Spring Boot framework and dependency injection\n• REST API design and implementation\n• Spring Data JPA and database integration\n• Spring Security and authentication\n• Unit and integration testing\n• Microservices architecture\n• Docker containerization\n• Cloud deployment (AWS, Azure, GCP)\n• API documentation with OpenAPI/Swagger");
            backendCourse.setCourseDifficulty("Intermediate");
            backendCourse.setCourseUrl("/courses/backend_programming");
            backendCourse.setImgUrl("/static/img/backend-course.jpg");
            backendCourse.setHeroImageUrl("/static/img/backend-hero.jpg");
            backendCourse.setPublished(true);
            backendCourse.setTutor(tutor4);
            courseRepository.save(backendCourse);

            // AI/ML Course
            Course aiCourse = new Course();
            aiCourse.setSlug("llm_ai");
            aiCourse.setTitle("LLM & AI Fundamentals");
            aiCourse.setCourseName("Large Language Models & AI Fundamentals");
            aiCourse.setCourseDescription("Explore the world of artificial intelligence and large language models. Learn machine learning algorithms, neural networks, natural language processing, and practical AI applications.");
            aiCourse.setSummary("Comprehensive introduction to AI and machine learning with hands-on projects using Python, TensorFlow, and modern LLM frameworks.");
            aiCourse.setCourseDetail("• Python for data science and ML\n• Machine learning fundamentals and algorithms\n• Neural networks and deep learning\n• Natural Language Processing (NLP)\n• Large Language Models (LLMs) and transformers\n• Computer vision basics\n• AI ethics and responsible AI\n• MLOps and model deployment\n• Working with APIs (OpenAI, Hugging Face)\n• Building AI-powered applications");
            aiCourse.setCourseDifficulty("Advanced");
            aiCourse.setCourseUrl("/courses/llm_ai");
            aiCourse.setImgUrl("/static/img/ai-course.jpg");
            aiCourse.setHeroImageUrl("/static/img/ai-hero.jpg");
            aiCourse.setPublished(true);
            aiCourse.setTutor(tutor2);
            courseRepository.save(aiCourse);

            // IoT Course
            Course iotCourse = new Course();
            iotCourse.setSlug("iot_edge");
            iotCourse.setTitle("IoT & Edge Computing");
            iotCourse.setCourseName("Internet of Things & Edge Computing");
            iotCourse.setCourseDescription("Learn to build connected devices and implement edge computing solutions. Cover Arduino, Raspberry Pi, sensors, wireless communication, and industrial IoT applications.");
            iotCourse.setSummary("Hands-on course in IoT development covering hardware programming, sensor integration, wireless protocols, and edge computing implementations.");
            iotCourse.setCourseDetail("• Electronics fundamentals and circuit design\n• Arduino and Raspberry Pi programming\n• Sensor integration and data acquisition\n• Wireless communication (WiFi, Bluetooth, LoRa)\n• MQTT and IoT protocols\n• Edge computing and real-time processing\n• Cloud IoT platforms (AWS IoT, Azure IoT)\n• Industrial IoT and automation\n• IoT security and best practices\n• Project: Build a complete IoT solution");
            iotCourse.setCourseDifficulty("Intermediate");
            iotCourse.setCourseUrl("/courses/iot_edge");
            iotCourse.setImgUrl("/static/img/iot-course.jpg");
            iotCourse.setHeroImageUrl("/static/img/iot-hero.jpg");
            iotCourse.setPublished(true);
            iotCourse.setTutor(tutor3);
            courseRepository.save(iotCourse);

            // Mechatronics I Course
            Course mechatronics1 = new Course();
            mechatronics1.setSlug("mechatronics_I");
            mechatronics1.setTitle("Mechatronics I - Fundamentals");
            mechatronics1.setCourseName("Mechatronics Fundamentals");
            mechatronics1.setCourseDescription("Introduction to mechatronics systems combining mechanical, electrical, and software engineering. Learn sensors, actuators, control systems, and system integration.");
            mechatronics1.setSummary("Foundation course in mechatronics covering mechanical systems, electronics, sensors, actuators, and basic control theory.");
            mechatronics1.setCourseDetail("• Mechanical engineering fundamentals\n• Electronics and circuit analysis\n• Sensors and transducers\n• Actuators and motor control\n• Microcontroller programming\n• PLC programming basics\n• Control theory fundamentals\n• System modeling and simulation\n• CAD design for mechatronic systems\n• Hands-on lab projects and prototyping");
            mechatronics1.setCourseDifficulty("Beginner");
            mechatronics1.setCourseUrl("/courses/mechatronics_I");
            mechatronics1.setImgUrl("/static/img/mechatronics1-course.jpg");
            mechatronics1.setHeroImageUrl("/static/img/mechatronics1-hero.jpg");
            mechatronics1.setPublished(true);
            mechatronics1.setTutor(tutor3);
            courseRepository.save(mechatronics1);

            // Mechatronics II Course
            Course mechatronics2 = new Course();
            mechatronics2.setSlug("mechatronics_II");
            mechatronics2.setTitle("Mechatronics II - Advanced Systems");
            mechatronics2.setCourseName("Advanced Mechatronics & Robotics");
            mechatronics2.setCourseDescription("Advanced mechatronics covering robotics, automation, complex control systems, and industrial applications. Build autonomous systems and learn advanced manufacturing concepts.");
            mechatronics2.setSummary("Advanced course in mechatronics and robotics covering autonomous systems, advanced control, robotics programming, and industrial automation.");
            mechatronics2.setCourseDetail("• Advanced control systems and PID tuning\n• Robotics kinematics and dynamics\n• Robot programming (ROS)\n• Computer vision for robotics\n• Industrial automation and SCADA\n• Autonomous navigation systems\n• Machine learning for robotics\n• Advanced manufacturing (3D printing, CNC)\n• Project management for engineering\n• Capstone project: Autonomous robot system");
            mechatronics2.setCourseDifficulty("Advanced");
            mechatronics2.setCourseUrl("/courses/mechatronics_II");
            mechatronics2.setImgUrl("/static/img/mechatronics2-course.jpg");
            mechatronics2.setHeroImageUrl("/static/img/mechatronics2-hero.jpg");
            mechatronics2.setPublished(true);
            mechatronics2.setTutor(tutor3);
            courseRepository.save(mechatronics2);

            // Additional Courses for Diversity

            // Data Science Course
            Course dataScienceCourse = new Course();
            dataScienceCourse.setSlug("data_science");
            dataScienceCourse.setTitle("Data Science & Analytics");
            dataScienceCourse.setCourseName("Data Science & Business Analytics");
            dataScienceCourse.setCourseDescription("Master data science techniques using Python, R, and SQL. Learn statistical analysis, data visualization, machine learning, and business intelligence for data-driven decision making.");
            dataScienceCourse.setSummary("Comprehensive data science course covering statistical analysis, machine learning, data visualization, and business intelligence using modern tools and techniques.");
            dataScienceCourse.setCourseDetail("• Python and R for data analysis\n• SQL and database querying\n• Statistical analysis and hypothesis testing\n• Data cleaning and preprocessing\n• Exploratory data analysis (EDA)\n• Data visualization with Matplotlib, Seaborn, ggplot\n• Machine learning algorithms and evaluation\n• Business intelligence and reporting\n• Big data tools (Spark, Hadoop)\n• Real-world capstone projects");
            dataScienceCourse.setCourseDifficulty("Intermediate");
            dataScienceCourse.setCourseUrl("/courses/data_science");
            dataScienceCourse.setImgUrl("/static/img/data-science-course.jpg");
            dataScienceCourse.setHeroImageUrl("/static/img/data-science-hero.jpg");
            dataScienceCourse.setPublished(true);
            dataScienceCourse.setTutor(tutor6);
            courseRepository.save(dataScienceCourse);

            // Cybersecurity Course
            Course cybersecurityCourse = new Course();
            cybersecurityCourse.setSlug("cybersecurity");
            cybersecurityCourse.setTitle("Cybersecurity Fundamentals");
            cybersecurityCourse.setCourseName("Cybersecurity & Ethical Hacking");
            cybersecurityCourse.setCourseDescription("Learn cybersecurity fundamentals, ethical hacking, penetration testing, and security architecture. Protect systems and networks from cyber threats with hands-on security labs.");
            cybersecurityCourse.setSummary("Comprehensive cybersecurity course covering ethical hacking, penetration testing, security architecture, and incident response with practical lab exercises.");
            cybersecurityCourse.setCourseDetail("• Cybersecurity fundamentals and threat landscape\n• Network security and firewalls\n• Ethical hacking and penetration testing\n• Web application security (OWASP Top 10)\n• Cryptography and encryption\n• Security architecture and design\n• Incident response and forensics\n• Security compliance and frameworks\n• Cloud security best practices\n• Hands-on labs with real security tools");
            cybersecurityCourse.setCourseDifficulty("Intermediate");
            cybersecurityCourse.setCourseUrl("/courses/cybersecurity");
            cybersecurityCourse.setImgUrl("/static/img/cybersecurity-course.jpg");
            cybersecurityCourse.setHeroImageUrl("/static/img/cybersecurity-hero.jpg");
            cybersecurityCourse.setPublished(true);
            cybersecurityCourse.setTutor(tutor5);
            courseRepository.save(cybersecurityCourse);

            System.out.println("Courses seeded successfully! Created 8 comprehensive courses with detailed content.");
        }
    }

    private void seedEnrollments() {
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        if (enrollments.isEmpty()) {
            System.out.println("Seeding enrollments data...");

            // Get all users and courses
            List<User> allUsers = userRepository.findAll();
            List<Course> allCourses = courseRepository.findAll();
            
            // Filter out admin and instructor accounts for enrollments
            List<User> students = allUsers.stream()
                .filter(u -> !u.getUsername().equals("admin") 
                    && !u.getUsername().startsWith("dr_") 
                    && !u.getUsername().startsWith("prof_")
                    && !u.getUsername().equals("james_thompson"))
                .toList();

            // Create realistic enrollment patterns
            Random random = new Random(42); // Fixed seed for reproducible results
            
            // Popular courses (Frontend, Backend, Data Science) get more enrollments
            Course frontendCourse = allCourses.stream().filter(c -> "frontend_programming".equals(c.getSlug())).findFirst().orElse(null);
            Course backendCourse = allCourses.stream().filter(c -> "backend_programming".equals(c.getSlug())).findFirst().orElse(null);
            Course aiCourse = allCourses.stream().filter(c -> "llm_ai".equals(c.getSlug())).findFirst().orElse(null);
            Course iotCourse = allCourses.stream().filter(c -> "iot_edge".equals(c.getSlug())).findFirst().orElse(null);
            Course mechatronics1 = allCourses.stream().filter(c -> "mechatronics_I".equals(c.getSlug())).findFirst().orElse(null);
            Course mechatronics2 = allCourses.stream().filter(c -> "mechatronics_II".equals(c.getSlug())).findFirst().orElse(null);
            Course dataScienceCourse = allCourses.stream().filter(c -> "data_science".equals(c.getSlug())).findFirst().orElse(null);
            Course cybersecurityCourse = allCourses.stream().filter(c -> "cybersecurity".equals(c.getSlug())).findFirst().orElse(null);

            // Simulate enrollments over the past 6 months with varying dates
            for (User student : students) {
                // Each student enrolls in 1-4 courses with different probabilities
                int numCourses = 1 + random.nextInt(4); // 1-4 courses per student
                List<Course> studentCourses = new java.util.ArrayList<>();
                
                // Higher probability for popular courses
                if (random.nextDouble() < 0.7 && frontendCourse != null) studentCourses.add(frontendCourse);
                if (random.nextDouble() < 0.6 && backendCourse != null) studentCourses.add(backendCourse);
                if (random.nextDouble() < 0.5 && dataScienceCourse != null) studentCourses.add(dataScienceCourse);
                if (random.nextDouble() < 0.4 && aiCourse != null) studentCourses.add(aiCourse);
                if (random.nextDouble() < 0.3 && cybersecurityCourse != null) studentCourses.add(cybersecurityCourse);
                if (random.nextDouble() < 0.3 && iotCourse != null) studentCourses.add(iotCourse);
                if (random.nextDouble() < 0.2 && mechatronics1 != null) studentCourses.add(mechatronics1);
                if (random.nextDouble() < 0.1 && mechatronics2 != null) studentCourses.add(mechatronics2);
                
                // Ensure each student has at least one course
                if (studentCourses.isEmpty() && frontendCourse != null) {
                    studentCourses.add(frontendCourse);
                }
                
                // Limit to numCourses and create enrollments
                studentCourses = studentCourses.stream().distinct().limit(numCourses).toList();
                
                for (Course course : studentCourses) {
                    // Create enrollment with historical dates (past 6 months)
                    LocalDate enrollmentDate = LocalDate.now().minusDays(random.nextInt(180));
                    
                    Enrollment enrollment = new Enrollment();
                    enrollment.setUser(student);
                    enrollment.setCourse(course);
                    enrollment.setEnrollmentDate(enrollmentDate);
                    enrollmentRepository.save(enrollment);
                }
            }

            // Create some specific enrollment patterns for testing

            // Ensure some students have sequential course progressions
            User sequentialStudent = userRepository.findByUsername("alice_chen");
            if (sequentialStudent != null && mechatronics1 != null && mechatronics2 != null) {
                // Alice takes Mechatronics I first
                Enrollment mech1Enrollment = new Enrollment();
                mech1Enrollment.setUser(sequentialStudent);
                mech1Enrollment.setCourse(mechatronics1);
                mech1Enrollment.setEnrollmentDate(LocalDate.now().minusDays(120));
                enrollmentRepository.save(mech1Enrollment);
                
                // Then Mechatronics II later
                Enrollment mech2Enrollment = new Enrollment();
                mech2Enrollment.setUser(sequentialStudent);
                mech2Enrollment.setCourse(mechatronics2);
                mech2Enrollment.setEnrollmentDate(LocalDate.now().minusDays(60));
                enrollmentRepository.save(mech2Enrollment);
            }

            // Create a full-stack learning path
            User fullStackStudent = userRepository.findByUsername("david_martinez");
            if (fullStackStudent != null && frontendCourse != null && backendCourse != null) {
                // David takes frontend first
                Enrollment frontendEnrollment = new Enrollment();
                frontendEnrollment.setUser(fullStackStudent);
                frontendEnrollment.setCourse(frontendCourse);
                frontendEnrollment.setEnrollmentDate(LocalDate.now().minusDays(100));
                enrollmentRepository.save(frontendEnrollment);
                
                // Then backend
                Enrollment backendEnrollment = new Enrollment();
                backendEnrollment.setUser(fullStackStudent);
                backendEnrollment.setCourse(backendCourse);
                backendEnrollment.setEnrollmentDate(LocalDate.now().minusDays(50));
                enrollmentRepository.save(backendEnrollment);
            }

            // Create AI specialization path
            User aiSpecialist = userRepository.findByUsername("priya_sharma");
            if (aiSpecialist != null && aiCourse != null && dataScienceCourse != null) {
                // Priya takes data science first
                Enrollment dsEnrollment = new Enrollment();
                dsEnrollment.setUser(aiSpecialist);
                dsEnrollment.setCourse(dataScienceCourse);
                dsEnrollment.setEnrollmentDate(LocalDate.now().minusDays(90));
                enrollmentRepository.save(dsEnrollment);
                
                // Then AI course
                Enrollment aiEnrollment = new Enrollment();
                aiEnrollment.setUser(aiSpecialist);
                aiEnrollment.setCourse(aiCourse);
                aiEnrollment.setEnrollmentDate(LocalDate.now().minusDays(30));
                enrollmentRepository.save(aiEnrollment);
            }

            System.out.println("Enrollments seeded successfully! Created realistic enrollment patterns with historical data spanning 6 months.");
        }
    }
}