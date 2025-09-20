#!/usr/bin/env python3
"""
Script to fix course pages by:
1. Adding Thymeleaf namespace
2. Removing theme toggle button (now in navbar)
3. Removing inline JavaScript (now in app.js)
4. Adding proper script includes
"""

import os
import re

course_pages = [
    "src/main/resources/templates/courses/backend_programming/index.html",
    "src/main/resources/templates/courses/llm_ai/index.html", 
    "src/main/resources/templates/courses/iot_edge/index.html",
    "src/main/resources/templates/courses/mechatronics_I/index.html",
    "src/main/resources/templates/courses/mechatronics_II/index.html"
]

def fix_course_page(file_path):
    print(f"Fixing {file_path}...")
    
    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            content = f.read()
        
        # Add Thymeleaf namespace
        content = content.replace(
            '<html lang="en">',
            '<html lang="en" xmlns:th="http://www.thymeleaf.org">'
        )
        
        # Remove toggle-theme CSS class definition
        content = re.sub(
            r'\s*\.toggle-theme\s*\{[^}]*\}',
            '',
            content
        )
        
        # Remove theme toggle button
        content = re.sub(
            r'<!-- Theme Toggle Button -->\s*<button id="theme-toggle"[^>]*>.*?</button>\s*',
            '',
            content,
            flags=re.DOTALL
        )
        
        # Remove inline JavaScript
        content = re.sub(
            r'<script>\s*const themeToggleBtn.*?</script>',
            '<!-- Theme Toggle JavaScript -->\n<script th:src="@{/js/app.js}"></script>',
            content,
            flags=re.DOTALL
        )
        
        with open(file_path, 'w', encoding='utf-8') as f:
            f.write(content)
        
        print(f"Successfully fixed {file_path}")
        
    except Exception as e:
        print(f"Error fixing {file_path}: {e}")

if __name__ == "__main__":
    for page in course_pages:
        if os.path.exists(page):
            fix_course_page(page)
        else:
            print(f"File not found: {page}")