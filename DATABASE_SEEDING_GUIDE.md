# Database Seeding Setup Guide - Enhanced Version

## Overview

This guide explains how to set up comprehensive database seeding for the Skill Sprint LMS application. We provide multiple seeding approaches for different environments and use cases.

## Seeding Approaches

### 1. Spring Boot CommandLineRunner (Recommended for Development)
- **File**: `src/main/java/com/railway/helloworld/config/SeedData.java`
- **When it runs**: Automatically when the Spring Boot application starts
- **Best for**: Development, testing, and small-scale deployments
- **Features**: Conditional seeding (only if tables are empty), proper password encoding

### 2. SQL Scripts (Recommended for Production)
- **Files**: 
  - `database/seed-data-production.sql` - Production-ready data
  - `database/seed-data-development.sql` - Development/testing data
- **When to use**: Production deployments, database migrations, CI/CD pipelines
- **Features**: Direct SQL insertion, batch processing, environment-specific data

## Enhanced Data Model

### Users (20 total)
- **1 Administrator**: System admin with full access
- **6 Instructors**: Diverse expert tutors with detailed backgrounds
- **15 Students**: Representing different demographics and learning paths
  - Computer Science students
  - Engineering students  
  - Working professionals
  - International students

### Tutors (6 specialists)
- **Dr. Sarah Johnson**: Frontend/Full-stack (MIT PhD, Google/Meta background)
- **Prof. Michael Chen**: AI/ML (Stanford Professor, OpenAI/DeepMind experience)
- **Dr. Emily Rodriguez**: IoT/Mechatronics (Caltech PhD, Tesla/SpaceX background)
- **James Thompson**: Backend/Cloud (Netflix/Amazon architect)
- **Dr. Aisha Okonkwo**: Cybersecurity (Carnegie Mellon PhD, Fortune 500 consultant)
- **Dr. Raj Patel**: Data Science (Microsoft Data Science Director)

### Courses (8 comprehensive courses)
1. **Frontend Programming Fundamentals** - HTML, CSS, JavaScript, React
2. **Backend Programming with Spring Boot** - Java, APIs, databases, cloud
3. **LLM & AI Fundamentals** - Machine learning, neural networks, LLMs
4. **IoT & Edge Computing** - Arduino, Raspberry Pi, sensors, protocols
5. **Mechatronics I** - Fundamentals of mechatronic systems
6. **Mechatronics II** - Advanced robotics and automation
7. **Data Science & Analytics** - Python, R, SQL, visualization, ML
8. **Cybersecurity Fundamentals** - Ethical hacking, penetration testing

### Enrollments (Realistic Patterns)
- **Historical data**: Spanning 6 months with varied enrollment dates
- **Learning paths**: Sequential course progressions (e.g., Mechatronics I → II)
- **Popular courses**: Higher enrollment in Frontend, Backend, Data Science
- **Specialized tracks**: Fewer enrollments in advanced courses
- **International diversity**: Students from different time zones and backgrounds

## Setup Instructions

### Method 1: Spring Boot Auto-Seeding (Development)

1. **Database Setup**
   ```bash
   # Ensure MySQL is running
   mysql -u root -p
   CREATE DATABASE lms_db;
   ```

2. **Configure Application**
   ```properties
   # Update src/main/resources/application.properties
   spring.datasource.url=jdbc:mysql://localhost:3306/lms_db
   spring.datasource.username=root
   spring.datasource.password=your_password_here
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Run Application**
   ```bash
   mvnw.cmd spring-boot:run
   ```
   
   The SeedData component will automatically:
   - Check if tables are empty
   - Seed all data with proper relationships
   - Display progress messages in console
   - Encode passwords using BCrypt

### Method 2: SQL Script Execution (Production)

1. **For Production Environment**
   ```bash
   # Update password hashes in the script first!
   mysql -u root -p lms_db < database/seed-data-production.sql
   ```

2. **For Development Environment**
   ```bash
   # Includes test passwords and helper views
   mysql -u root -p lms_db < database/seed-data-development.sql
   ```

## Test Credentials

### Development Environment
- **Admin**: username: `admin`, password: `admin123`
- **Instructor**: username: `dr_sarah_johnson`, password: `instructor123`  
- **Student**: username: `john_doe`, password: `student123`

### All User Accounts
```
Admins:
- admin / admin123

Instructors:
- dr_sarah_johnson / instructor123
- prof_michael_chen / instructor123
- dr_emily_rodriguez / instructor123
- james_thompson / instructor123
- dr_aisha_okonkwo / instructor123
- dr_raj_patel / instructor123

Students:
- john_doe / student123
- jane_smith / student123
- mike_wilson / student123
- alice_chen / student123
- david_martinez / student123
- sarah_brown / student123
- robert_garcia / student123
- lisa_patel / student123
- kevin_lee / student123
- maria_gonzalez / student123
- ahmed_hassan / student123
- priya_sharma / student123
- yuki_tanaka / student123
- elena_petrov / student123
- carlos_silva / student123
```

## Data Verification

### Using SQL Queries
```sql
-- Check data counts
SELECT 'Users' as table_name, COUNT(*) as count FROM users
UNION ALL
SELECT 'Tutors', COUNT(*) FROM tutor
UNION ALL  
SELECT 'Courses', COUNT(*) FROM courses
UNION ALL
SELECT 'Enrollments', COUNT(*) FROM enrollment;

-- View recent enrollments
SELECT u.username, c.course_name, e.date
FROM enrollment e
JOIN users u ON e.userId = u.id
JOIN courses c ON e.courseId = c.id
ORDER BY e.date DESC
LIMIT 10;

-- Course popularity
SELECT c.course_name, COUNT(e.courseId) as enrollments
FROM courses c
LEFT JOIN enrollment e ON c.id = e.courseId
GROUP BY c.id, c.course_name
ORDER BY enrollments DESC;
```

### Using Application Logs
Look for these success messages in the console:
```
Seeding users data...
Users seeded successfully! Created 20 users (1 admin, 6 instructors, 15 students)
Seeding tutors data...
Tutors seeded successfully! Created 6 diverse tutors with detailed profiles.
Seeding courses data...
Courses seeded successfully! Created 8 comprehensive courses with detailed content.
Seeding enrollments data...
Enrollments seeded successfully! Created realistic enrollment patterns with historical data spanning 6 months.
```

## Advanced Features

### Realistic Learning Paths
- **Full-stack Track**: Frontend → Backend
- **AI Specialization**: Data Science → AI/ML
- **Mechatronics Progression**: Mechatronics I → Mechatronics II
- **Security Track**: Basic courses → Cybersecurity

### Enrollment Analytics
- Historical enrollment patterns over 6 months
- Peak enrollment periods simulation
- Drop-off and completion rate patterns
- International student enrollment timing

### Data Quality Features
- **Referential Integrity**: All foreign keys properly maintained
- **Realistic Demographics**: Diverse international student body
- **Professional Backgrounds**: Varied instructor expertise
- **Temporal Consistency**: Logical enrollment date progressions

## Environment Configurations

### Development Profile
```properties
spring.profiles.active=dev
# Enables detailed logging and development-specific features
```

### Production Profile
```properties
spring.profiles.active=prod
# Disables auto-seeding, uses production configurations
```

## Troubleshooting

### Common Issues

1. **Duplicate Data Errors**
   ```sql
   -- Reset database completely
   DROP DATABASE lms_db;
   CREATE DATABASE lms_db;
   ```

2. **Password Encoding Issues**
   - Ensure `SecurityConfig` has `PasswordEncoder` bean configured
   - Check BCrypt version compatibility

3. **Foreign Key Constraints**
   - Verify tutor IDs exist before creating courses
   - Ensure user and course IDs exist before creating enrollments

4. **Memory Issues with Large Datasets**
   ```properties
   # Increase JVM memory
   -Xmx2048m -Xms1024m
   ```

### Reset Commands
```sql
-- Clear all data
DELETE FROM enrollment;
DELETE FROM courses;  
DELETE FROM tutor;
DELETE FROM users;

-- Reset auto-increment
ALTER TABLE users AUTO_INCREMENT = 1;
ALTER TABLE tutor AUTO_INCREMENT = 1;
ALTER TABLE courses AUTO_INCREMENT = 1;
ALTER TABLE enrollment AUTO_INCREMENT = 1;
```

## Performance Considerations

### Large Dataset Optimization
- Use batch processing for SQL scripts
- Implement pagination for enrollment generation
- Consider database indexing for frequently queried fields

### Memory Management
- The SeedData component loads all data in memory
- For very large datasets, consider streaming approaches
- Monitor application startup time with large seed data

## Integration with CI/CD

### Pipeline Integration
```yaml
# Example GitHub Actions step
- name: Seed Database
  run: |
    mysql -h ${{ secrets.DB_HOST }} -u ${{ secrets.DB_USER }} -p${{ secrets.DB_PASSWORD }} ${{ secrets.DB_NAME }} < database/seed-data-production.sql
```

### Docker Integration
```dockerfile
# Copy seed scripts
COPY database/*.sql /docker-entrypoint-initdb.d/
```

## Security Notes

### Production Deployment
1. **Never use default passwords in production**
2. **Generate strong BCrypt hashes for all accounts**
3. **Use environment variables for sensitive data**
4. **Implement proper user role management**
5. **Enable audit logging for data access**

### Password Security
```java
// Generate production password hashes
BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
String hash = encoder.encode("your-secure-password");
```

This enhanced seeding setup provides a robust foundation for developing and testing your LMS application with realistic, diverse data that simulates real-world usage patterns.