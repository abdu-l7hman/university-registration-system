# Course Registration System

## CS 102 Project

### Project Description

This project is a Course Registration System that allows students, advisors, and administrators to interact with the system based on their roles.

- **Students** can register for courses, view schedules, drop courses, update personal information, and request special registrations.
- **Advisors** can approve or deny special registration requests.
- **Administrators** can manage courses, users, and view system statistics.

---

### Contributors

👨‍💻 Abdurhman Mamdouhe  
👨‍💻 Abdulmalik Mhammeden

---

### Features

#### ✅ For Students:

- View available courses.
- Register for courses (ensuring prerequisites and schedule compatibility).
- Drop registered courses.
- View all validated courses and prerequisites.
- View personal schedule.
- Update personal information.
- Submit and receive feedback for special registration requests.

#### ✅ For Advisors:

- View registered students and their courses.
- Approve/Deny special course registration requests.

#### ✅ For Administrators:

- **Manage Courses:** Add, remove, and update courses.
- **Manage Users:** Add or remove students and advisors.
- **View System Statistics:** Total courses, students, and system usage details.

---

### How to Run

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/CourseRegistrationSystem.git
    ```

2. Navigate to the project folder:

    ```bash
    cd CourseRegistrationSystem
    ```

3. Compile and run the Java program:

    ```bash
    javac Main.java
    java Main
    ```

---

### Usage Guide

Upon running the program, users will see the main menu:

Start Page_ "Enter a number" 1 for Student 2 for Advisor 3 for Administrators 4 for exit Enter number (1,2,3,4):
Code

#### 🎓 Student Portal

To enter as a student, type 1.  
Example:

Enter number(1,2,3,4): 1 Enter your ID (0 to exit): 789 Enter your password: Jkl@123
Code

Available Student Options:

1. View Available Courses  
2. Register for Courses  
3. View Registered Courses  
4. Drop a Course  
5. View All Validated Courses  
6. View Schedule  
7. Update Personal Information  
8. Submit Special Registration Requests  
9. List All Prerequisite Courses  
10. Exit  

#### 📚 Course Management (Administrator)

To enter as an administrator, type 3.  
Example:

Administrator Page

    Manage Courses
    Manage Users
    View System Statistics
    Exit

Code

Managing Courses:

1. Add New Courses  
2. Remove Existing Courses  
3. Update Existing Courses  
4. Exit  

Adding a Course Example:

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
Code

### Data Persistence

- Data is stored in files to ensure consistency across sessions.
- At the start of the session, data is loaded from files.
- Changes made by users are saved when they exit.

### License

This project is for academic use only.
