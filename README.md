# Student Registration System

This project is developed by Abdurhman Mamdouh and Abdulmalik Mhammeden as part of a CS 102 course. It is a simple, command-line-based Student Registration System that allows students, advisors, and administrators to interact with various functionalities such as registering for courses, viewing schedules, and managing course information.

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
  - [Student Features](#student-features)
  - [Advisor Features](#advisor-features)
  - [Administrator Features](#administrator-features)
- [How to Run](#how-to-run)
- [Technologies Used](#technologies-used)
- [Contributors](#contributors)
- [License](#license)

## Project Overview

The Student Registration System enables users (students, advisors, and administrators) to perform specific tasks related to course registration. Each user has a role, and the system provides an interactive interface that allows each user to:

- **Students**: View courses, register and drop courses, view schedules, update personal information, and more.
- **Advisors**: Review and approve special registration requests from students.
- **Administrators**: Add, remove, and update courses in the system.

## Features

### Student Features

Once logged in, a student can access the following options:

- **View Available Courses**: Displays a list of available courses with details such as course code, name, instructor, available seats, schedule, prerequisites, and credit hours.
- **Register for Courses**: Allows students to register for courses by entering the course code. It ensures that the student does not register for a course they have already taken or lack the required prerequisites.
- **View Registered Courses**: Displays the details of courses the student is already registered for.
- **Drop Course**: Allows students to drop a course they are currently registered for.
- **View All Validated Courses**: Displays a list of courses that have been validated and approved.
- **View Schedule**: Shows a visual schedule for the student to see their weekly course timetable.
- **Update Personal Information**: Students can update their name and password.
- **Submit Special Registration Requests**: Allows students to send a request for special registration (e.g., adding a course).
- **List Prerequisite Courses**: Displays the prerequisites for a given course.

### Advisor Features

Advisors can:

- Approve or reject special registration requests from students.

### Administrator Features

Administrators can manage courses through these options:

- **Add New Courses**: Administrators can add new courses to the system.
- **Remove Existing Courses**: Allows administrators to delete courses from the system.
- **Update Existing Courses**: Administrators can modify details of existing courses in the system.
- **Manage Users**: Administrators can manage student and advisor data.
- **View System Statistics**: View basic system statistics (not detailed in the project description).

## How to Run

1. Clone this repository to your local machine:
    ```bash
    git clone https://github.com/username/repository-name.git
    ```

2. Navigate into the project directory:
    ```bash
    cd repository-name
    ```

3. Compile and run the program (assuming you are using Java or another programming language):
    ```bash
    javac Main.java
    java Main
    ```

4. Follow the on-screen instructions to interact with the system based on your user type (Student, Advisor, or Administrator).

## Technologies Used

- **Programming Language**: Java (or other languages if applicable)
- **Text-based Interface**: Command-line interface (CLI)
- **Database**: No database integration in this version (information is stored in memory)

## Contributors

- Abdurhman Mamdouh
- Abdulmalik Mhammeden

## License

This project is licensed under the MIT License - see the LICENSE file for details.

Feel free to customize the file based on your actual project structure and any specific instructions for running or using the project!
