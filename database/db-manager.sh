#!/bin/bash
# Database Management Script for Skill Sprint LMS
# This script provides utilities for managing database seeding

# Configuration
DB_NAME="lms_db"
DB_USER="root"
DB_PASS=""  # Set your MySQL password here
DB_HOST="localhost"
DB_PORT="3306"

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Function to print colored output
print_status() {
    echo -e "${GREEN}[INFO]${NC} $1"
}

print_warning() {
    echo -e "${YELLOW}[WARN]${NC} $1"
}

print_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

print_header() {
    echo -e "${BLUE}================================${NC}"
    echo -e "${BLUE} $1${NC}"
    echo -e "${BLUE}================================${NC}"
}

# Function to check MySQL connection
check_mysql_connection() {
    mysql -h "$DB_HOST" -P "$DB_PORT" -u "$DB_USER" -p"$DB_PASS" -e "SELECT 1;" > /dev/null 2>&1
    if [ $? -eq 0 ]; then
        print_status "MySQL connection successful"
        return 0
    else
        print_error "Cannot connect to MySQL. Please check your credentials."
        return 1
    fi
}

# Function to create database
create_database() {
    print_header "Creating Database"
    mysql -h "$DB_HOST" -P "$DB_PORT" -u "$DB_USER" -p"$DB_PASS" -e "CREATE DATABASE IF NOT EXISTS $DB_NAME;"
    if [ $? -eq 0 ]; then
        print_status "Database '$DB_NAME' created successfully"
    else
        print_error "Failed to create database"
        return 1
    fi
}

# Function to drop database
drop_database() {
    print_header "Dropping Database"
    print_warning "This will delete ALL data in the database!"
    read -p "Are you sure? (y/N): " confirmation
    if [[ $confirmation =~ ^[Yy]$ ]]; then
        mysql -h "$DB_HOST" -P "$DB_PORT" -u "$DB_USER" -p"$DB_PASS" -e "DROP DATABASE IF EXISTS $DB_NAME;"
        if [ $? -eq 0 ]; then
            print_status "Database '$DB_NAME' dropped successfully"
        else
            print_error "Failed to drop database"
            return 1
        fi
    else
        print_status "Operation cancelled"
    fi
}

# Function to seed development data
seed_development() {
    print_header "Seeding Development Data"
    if [ -f "database/seed-data-development.sql" ]; then
        mysql -h "$DB_HOST" -P "$DB_PORT" -u "$DB_USER" -p"$DB_PASS" "$DB_NAME" < database/seed-data-development.sql
        if [ $? -eq 0 ]; then
            print_status "Development data seeded successfully"
            print_status "Test credentials:"
            echo "  Admin: admin / admin123"
            echo "  Instructor: dr_sarah_johnson / instructor123"
            echo "  Student: john_doe / student123"
        else
            print_error "Failed to seed development data"
            return 1
        fi
    else
        print_error "Development seed file not found: database/seed-data-development.sql"
        return 1
    fi
}

# Function to seed production data
seed_production() {
    print_header "Seeding Production Data"
    print_warning "This is for PRODUCTION use. Ensure you have updated password hashes!"
    read -p "Continue? (y/N): " confirmation
    if [[ $confirmation =~ ^[Yy]$ ]]; then
        if [ -f "database/seed-data-production.sql" ]; then
            mysql -h "$DB_HOST" -P "$DB_PORT" -u "$DB_USER" -p"$DB_PASS" "$DB_NAME" < database/seed-data-production.sql
            if [ $? -eq 0 ]; then
                print_status "Production data seeded successfully"
            else
                print_error "Failed to seed production data"
                return 1
            fi
        else
            print_error "Production seed file not found: database/seed-data-production.sql"
            return 1
        fi
    else
        print_status "Operation cancelled"
    fi
}

# Function to clear all data
clear_data() {
    print_header "Clearing All Data"
    print_warning "This will delete ALL data but keep the table structure!"
    read -p "Are you sure? (y/N): " confirmation
    if [[ $confirmation =~ ^[Yy]$ ]]; then
        mysql -h "$DB_HOST" -P "$DB_PORT" -u "$DB_USER" -p"$DB_PASS" "$DB_NAME" -e "
        SET FOREIGN_KEY_CHECKS = 0;
        DELETE FROM enrollment;
        DELETE FROM courses;
        DELETE FROM tutor;
        DELETE FROM users;
        ALTER TABLE users AUTO_INCREMENT = 1;
        ALTER TABLE tutor AUTO_INCREMENT = 1;
        ALTER TABLE courses AUTO_INCREMENT = 1;
        ALTER TABLE enrollment AUTO_INCREMENT = 1;
        SET FOREIGN_KEY_CHECKS = 1;
        "
        if [ $? -eq 0 ]; then
            print_status "All data cleared successfully"
        else
            print_error "Failed to clear data"
            return 1
        fi
    else
        print_status "Operation cancelled"
    fi
}

# Function to show database status
show_status() {
    print_header "Database Status"
    mysql -h "$DB_HOST" -P "$DB_PORT" -u "$DB_USER" -p"$DB_PASS" "$DB_NAME" -e "
    SELECT 'Users' as table_name, COUNT(*) as record_count FROM users
    UNION ALL
    SELECT 'Tutors', COUNT(*) FROM tutor
    UNION ALL
    SELECT 'Courses', COUNT(*) FROM courses
    UNION ALL
    SELECT 'Enrollments', COUNT(*) FROM enrollment;
    "
}

# Function to backup database
backup_database() {
    print_header "Creating Database Backup"
    timestamp=$(date +"%Y%m%d_%H%M%S")
    backup_file="backup_${DB_NAME}_${timestamp}.sql"
    
    mysqldump -h "$DB_HOST" -P "$DB_PORT" -u "$DB_USER" -p"$DB_PASS" "$DB_NAME" > "$backup_file"
    if [ $? -eq 0 ]; then
        print_status "Database backed up to: $backup_file"
    else
        print_error "Failed to create backup"
        return 1
    fi
}

# Function to restore database
restore_database() {
    print_header "Restoring Database"
    echo "Available backup files:"
    ls -la backup_*.sql 2>/dev/null
    echo ""
    read -p "Enter backup filename: " backup_file
    
    if [ -f "$backup_file" ]; then
        print_warning "This will replace ALL current data!"
        read -p "Continue? (y/N): " confirmation
        if [[ $confirmation =~ ^[Yy]$ ]]; then
            mysql -h "$DB_HOST" -P "$DB_PORT" -u "$DB_USER" -p"$DB_PASS" "$DB_NAME" < "$backup_file"
            if [ $? -eq 0 ]; then
                print_status "Database restored successfully from: $backup_file"
            else
                print_error "Failed to restore database"
                return 1
            fi
        else
            print_status "Operation cancelled"
        fi
    else
        print_error "Backup file not found: $backup_file"
        return 1
    fi
}

# Function to run Spring Boot seeding
run_spring_seeding() {
    print_header "Running Spring Boot Auto-Seeding"
    print_status "Starting Spring Boot application with auto-seeding..."
    print_status "Make sure your application.properties is configured correctly."
    
    if command -v mvnw.cmd &> /dev/null; then
        ./mvnw.cmd spring-boot:run
    elif command -v mvn &> /dev/null; then
        mvn spring-boot:run
    else
        print_error "Maven not found. Please run the application manually."
        return 1
    fi
}

# Main menu
show_menu() {
    clear
    print_header "Skill Sprint LMS - Database Management"
    echo "Please select an option:"
    echo ""
    echo "1. Create Database"
    echo "2. Drop Database"
    echo "3. Seed Development Data"
    echo "4. Seed Production Data"
    echo "5. Clear All Data"
    echo "6. Show Database Status"
    echo "7. Backup Database"
    echo "8. Restore Database"
    echo "9. Run Spring Boot Auto-Seeding"
    echo "10. Exit"
    echo ""
}

# Main script execution
main() {
    # Check if MySQL password is set
    if [ -z "$DB_PASS" ]; then
        read -s -p "Enter MySQL password for user '$DB_USER': " DB_PASS
        echo ""
    fi
    
    # Check MySQL connection
    if ! check_mysql_connection; then
        exit 1
    fi
    
    while true; do
        show_menu
        read -p "Enter your choice (1-10): " choice
        echo ""
        
        case $choice in
            1) create_database ;;
            2) drop_database ;;
            3) seed_development ;;
            4) seed_production ;;
            5) clear_data ;;
            6) show_status ;;
            7) backup_database ;;
            8) restore_database ;;
            9) run_spring_seeding ;;
            10) 
                print_status "Goodbye!"
                exit 0
                ;;
            *)
                print_error "Invalid option. Please try again."
                ;;
        esac
        
        echo ""
        read -p "Press Enter to continue..."
    done
}

# Run the main function
main "$@"