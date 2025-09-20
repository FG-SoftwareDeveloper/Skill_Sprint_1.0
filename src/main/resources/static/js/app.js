console.log("Hello, World!");

// Theme toggle functionality
document.addEventListener('DOMContentLoaded', function() {
    const themeToggleBtn = document.getElementById('theme-toggle');
    const moonIcon = document.getElementById('moon-icon');
    const sunIcon = document.getElementById('sun-icon');
    const body = document.body;

    // Check if theme toggle elements exist (they might not be on all pages)
    if (!themeToggleBtn || !moonIcon || !sunIcon) {
        console.log("Theme toggle elements not found on this page");
        return;
    }

    // Load saved theme from localStorage
    const savedTheme = localStorage.getItem('theme');
    if (savedTheme) {
        body.dataset.theme = savedTheme;
        if (savedTheme === 'light') {
            moonIcon.style.display = 'none';
            sunIcon.style.display = 'block';
        }
    }

    // Theme toggle event listener
    themeToggleBtn.addEventListener('click', () => {
        const currentTheme = body.dataset.theme;
        const newTheme = currentTheme === 'dark' ? 'light' : 'dark';
        body.dataset.theme = newTheme;
        localStorage.setItem('theme', newTheme);
        
        if (newTheme === 'light') {
            moonIcon.style.display = 'none';
            sunIcon.style.display = 'block';
        } else {
            moonIcon.style.display = 'block';
            sunIcon.style.display = 'none';
        }
    });
});

// Responsive navbar functionality
document.addEventListener('DOMContentLoaded', function() {
    // Close navbar collapse when clicking on nav links (mobile)
    const navbarCollapse = document.getElementById('navbarNav');
    const navLinks = document.querySelectorAll('.navbar-nav .nav-link');
    
    if (navbarCollapse && navLinks.length > 0) {
        navLinks.forEach(link => {
            link.addEventListener('click', () => {
                // Check if we're on mobile (navbar collapse is visible)
                if (window.innerWidth < 992) {
                    const bsCollapse = new bootstrap.Collapse(navbarCollapse, {
                        toggle: false
                    });
                    bsCollapse.hide();
                }
            });
        });
    }
    
    // Dropdown menu enhancement for mobile
    const dropdownMenus = document.querySelectorAll('.dropdown-menu');
    dropdownMenus.forEach(menu => {
        menu.addEventListener('click', (e) => {
            e.stopPropagation();
        });
    });
});