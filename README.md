markdown
Copy

# Course Registration System

## CS 102 Project

### Project Description

This project is a Course Registration System that allows students, advisors, and administrators to interact with the system based on their roles.

- **Students** can register for courses, view schedules, drop courses, update personal information, and request special registrations.
- **Advisors** can approve or deny special registration requests.
- **Administrators** can manage courses, users, and view system statistics.

---

## Contributors

👨‍💻 Abdurhman Mamdouhe  
👨‍💻 Abdulmalik Mhammeden  

---

## Features

### ✅ For Students:
- View available courses.
- Register for courses (ensuring prerequisites and schedule compatibility).
- Drop registered courses.
- View all validated courses and prerequisites.
- View personal schedule.
- Update personal information.
- Submit and receive feedback for special registration requests.

### ✅ For Advisors:
- View registered students and their courses.
- Approve/Deny special course registration requests.

### ✅ For Administrators:
- Manage Courses: Add, remove, and update courses.
- Manage Users: Add or remove students and advisors.
- View System Statistics: Total courses, students, and system usage details.

---

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/CourseRegistrationSystem.git

    Navigate to the project folder:
    bash
    Copy

    cd CourseRegistrationSystem

    Compile and run the Java program:
    bash
    Copy

    javac Main.java
    java Main

Usage Guide

Upon running the program, users will see the main menu:
Copy

_________Start Page__________
"Enter a number" 
1 for Student
2 for Advisor
3 for Administrators
4 for exit
Enter number (1,2,3,4): 

🎓 Student Portal

To enter as a student, type 1.
Example:
Copy

Enter number(1,2,3,4): 1
Enter your ID (0 to exit): 789
Enter your password: Jkl@123

Available Student Options:

    View Available Courses

    Register for Courses

    View Registered Courses

    Drop a Course

    View All Validated Courses

    View Schedule

    Update Personal Information

    Submit Special Registration Requests

    List All Prerequisite Courses

    Exit

📚 Course Management (Administrator)

To enter as an administrator, type 3.
Example:
Copy

Administrator Page  
1 to Manage Courses  
2 to Manage Users  
3 to View System Statistics  
4 to Exit  

Managing Courses:

    Add New Courses

    Remove Existing Courses

    Update Existing Courses

    Exit

Adding a Course Example:
Copy

Enter course code: Eng107  
Enter course name: English research  
Enter course description: Develop ideas  
Enter course instructor: Ahmed  
Enter available seats: 20  
Enter course schedule:  
(Enter Course days one by one, type '0' to stop)  
sunday  
monday  
0  
Enter the course time: 8:00-9:00  
Enter prerequisites (separated by ":") : Eng101  
Enter course credits: 4  

Project Structure
Copy

CourseRegistrationSystem/
│-- src/                   # Source code directory
│   │-- Main.java          # Main application entry point
│   │-- Student.java       # Student class
│   │-- Advisor.java       # Advisor class
│   │-- Admin.java         # Administrator class
│   │-- Course.java        # Course class
│-- data/                  # Stores persistent data
│-- README.md              # Documentation

Data Persistence

    Data is stored in files to ensure consistency across sessions.

    At the start of the session, data is loaded from files.

    Changes made by users are saved when they exit.

Submission Information

    Deadline: May 9, 2024

    Plagiarism Policy: A similarity above 35% results in a zero.

License

This project is for academic use only.
