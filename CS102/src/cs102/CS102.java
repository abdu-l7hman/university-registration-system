package cs102;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

// Main class CS102
public class CS102 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = -1;
        // Loop for main menu        
        do {
            System.out.print("\n_________Start Page__________"
                    + "\n\"Enter a number\" "
                    + "\n1 for Student"
                    + "\n2 for Advisor"
                    + "\n3 for Administrators"
                    + "\n4 for exit"
                    + "\nEnter number(1,2,3,4): ");
            n = sc.nextInt();
            // Switch case for different user roles
            switch (n) {
                case 1:
                    student();
                    break;
                case 2:
                    advisor();
                    break;
                case 3:
                    administrator();
            }
        } while (n != 4);
    }

    // Method for student functionalities
    public static void student() {
        Scanner sc = new Scanner(System.in);
        // Login student        
        Student s = StudentLogIn();
        // If student is logged in successfully
        if (s != null) {
            int n = -1;
            // Loop for student menu            
            do {
                System.out.println("\n_________Student Page__________"
                        + "\nEnter a number "
                        + "\n1 to view Available Courses"
                        + "\n2 to register for Courses"
                        + "\n3 view Registered Courses"
                        + "\n4 drop Course"
                        + "\n5 view All Validated Courses"
                        + "\n6 view Schedule"
                        + "\n7 update Personal Information"
                        + "\n8 submit and receive feedback for special registration requests"
                        + "\n9 list All Prerequisite Courses for a given Course"
                        + "\n10 to exit");
                n = sc.nextInt();
                // Switch case for different student functionalities                
                switch (n) {
                    case 1:
                        viewAvailableCourses();
                        break;
                    case 2:
                        registerForCourses(s);
                        break;
                    case 3:
                        viewRegisteredCourses(s);
                        break;
                    case 4:
                        dropCourse(s);
                        break;
                    case 5:
                        viewAllValidatedCourses(s);
                        break;
                    case 6:
                        viewSchedule(s);
                        break;
                    case 7:
                        updatePersonalInfo(s);
                        break;
                    case 8:
                        feedbackForSpecialRegistration(s);
                        break;
                    case 9:
                        allPrerequisiteForCourse();
                        break;
                }
            } while (n != 10);
        }
    }

    // Method for advisor functionalities
    public static void advisor() {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        // Loop for advisor menu        
        do {
            System.out.println("\n_________Advisor Page__________"
                    + "\nEnter a number "
                    + "\n1 to add validated courses"
                    + "\n2 to view Registered Students"
                    + "\n3 to view Students' Registered Courses"
                    + "\n4 to approve/Deny Special Course Registration Requests"
                    + "\n5 to exit");
            n = sc.nextInt();
            // Switch case for different advisor functionalities            
            switch (n) {
                case 1:
                    addValidatedCourse();
                    break;
                case 2:
                    viewRegisteredStudents();
                    break;
                case 3:
                    viewCoursesOfStudent();
                    break;
                case 4:
                    approveDenySpecialCourseRegistrationRequests();
                    break;
            }
        } while (n != 5);
    }

    // Method for administrator functionalities
    public static void administrator() {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        // Loop for administrator menu        
        do {
            System.out.print("\n__________Administrator Page__________\n"
                    + "\"Enter a number\"\n1 to manage Courses"
                    + "\n2 to manage Users"
                    + "\n3 to view System Statistics"
                    + "\n4 to exit"
                    + "\nEnter number(1,2,3,4): ");
            n = sc.nextInt();
            // Switch case for different administrator functionalities            
            switch (n) {
                case 1:
                    manageCourse();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 3:
                    viewSystemStat();
                    break;
            }
        } while (n != 4);
    }

    // Method to manage courses
    public static void manageCourse() {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        // Loop for manage course menu        
        do {
            System.out.print("\n__________Manage Course Page____________\n"
                    + "1 to add new courses"
                    + "\n2 to remove existing courses"
                    + "\n3 to update existing courses"
                    + "\n4 to exit"
                    + "\n Enter number(1,2,3,4): ");
            n = sc.nextInt();
            // Switch case for different manage course functionalities            
            switch (n) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    removeCourse();
                    break;
                case 3:
                    updateCourse();
                    break;
            }
        } while (n != 4);
    }

    // Method to add a new course
    public static void addCourse() {
        System.out.print("\n__________Add Course Page____________\n");
        Scanner input = new Scanner(System.in);
        System.out.print("1: Enter course code: ");
        String courseCode = input.next();
        //to consume the newline explicitly
        input.nextLine();
        System.out.print("2: Enter course name: ");
        String courseName = input.nextLine();
        System.out.print("3: Enter course description: ");
        String courseDiscription = input.nextLine();
        System.out.print("4: Enter course instructor: ");
        String courseInstructor = input.nextLine();
        System.out.print("5: Enter course availableSeats: ");
        int CourseAvailableSeats = input.nextInt();
        System.out.print("6: Enter course schedule: \n");
        //creat arrayList
        ArrayList courseDays = new ArrayList();
        //creat variable to exit loop
        boolean bool = true;
        //loop to get days of course
        do {
            System.out.println("Enter Course days(0 to exit): ");
            String s = input.next();
            if (s.equalsIgnoreCase("0")) {
                bool = false;
            } else {
                courseDays.add(s);
            }
        } while (bool);
        System.out.println("Enter the course time(12:00-01:00): ");
        String courseTime = input.next();
        System.out.print("7: Enter course prerequisites separated by \":\" :");
        String[] coursePrerequisites = input.next().split(":");
        System.out.print("8: Enter course credits: ");
        int courseCredits = input.nextInt();
        Course c = new Course(courseCode, courseName, courseDiscription,
                courseInstructor, CourseAvailableSeats, courseTime, courseDays,
                coursePrerequisites, courseCredits);
        // Retrieve existing courses        
        HashSet<Course> arrCourse = CourseFileToHashSet();
        boolean check = true;
        // Check if course already exists        
        for (Course course : arrCourse) {
            if ((course.getCode().equalsIgnoreCase(courseCode))) {
                check = false;
                System.out.println("This course is already added");
            }
        }
        // If course is new, add it to file
        if (check) {
            try (FileWriter fw = new FileWriter("course.txt", true)) {

                fw.write(c.toString() + "\n");

            } catch (IOException ex) {
                Logger.getLogger(CS102.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("Course added successfully!");
    }

    // Method to remove a course
    public static void removeCourse() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the code of the course you want to delet: ");
        String code = input.next();

        HashSet<Course> arrCourse = CourseFileToHashSet();
        // Remove course from HashSet
        removerByCode(arrCourse, code);
        // Write updated HashSet to file
        CourseHashSetToFile(arrCourse);
        System.out.println("Course removed successfully!");

    }

    // Method to remove course from HashSet by code
    public static HashSet<Course> removerByCode(HashSet arrCourse, String code) {
        Iterator<Course> it = arrCourse.iterator();

        while (it.hasNext()) {
            if (it.next().getCode().equalsIgnoreCase(code)) {
                it.remove();
            }
        }
        return arrCourse;
    }

    // Method to read courses from file and convert to HashSet
    public static HashSet<Course> CourseFileToHashSet() {
        HashSet<Course> arrCourse = new HashSet<>();

        try (Scanner sc2 = new Scanner(new File("course.txt"))) {
            while (sc2.hasNextLine()) {
                String line = sc2.nextLine();
                String[] s = line.split("::");
                Course c = new Course(s[0], s[1], s[2], s[3],
                        Integer.parseInt(s[4]), s[5], strToArr(s[6]),
                        s[7].split(":"), Integer.parseInt(s[8]));
                arrCourse.add(c);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CS102.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrCourse;
    }

    // Method to write HashSet of courses to file
    public static void CourseHashSetToFile(HashSet<Course> arrCourse) {
        try (FileWriter fw = new FileWriter("course.txt")) {

            for (Course course : arrCourse) {
                fw.write("\n"+course.toString() + "\n");
            }

        } catch (IOException ex) {
            Logger.getLogger(CS102.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to convert string to ArrayList
    public static ArrayList strToArr(String s) {
        String[] arr = s.split(":");
        ArrayList arrL = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            arrL.add(arr[i]);
        }
        return arrL;
    }

    // Method to update a course
    public static void updateCourse() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter code of course to update");
        String code = input.next();
        // Retrieve existing courses        
        HashSet<Course> arrCourse = CourseFileToHashSet();
        // Remove the course to be updated        
        arrCourse = removerByCode(arrCourse, code);
        // Write the updated HashSet to file        
        CourseHashSetToFile(arrCourse);
        // Call the addCourse method to add the updated course        
        addCourse();
    }

    // Method to manage users (students and advisors)
    private static void manageUsers() {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        do {
            // Display menu options for managing users
            System.out.print("\n___________ Manage Users Page ___________\n"
                    + "1 to manage students"
                    + "\n2 to manage advisors"
                    + "\n3 to exit"
                    + "\n Enter number(1,2,3): ");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    manageStudents();
                    break;
                case 2:
                    manageAdvisors();
                    break;
            }
        } while (n != 3);
    }

    // Method to manage students
    private static void manageStudents() {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        do {
            // Display menu options for managing students
            System.out.print("\n___________ Manage Stusent Page ___________\n"
                    + "1 to add students"
                    + "\n2 to remove students"
                    + "\n3 to exit"
                    + "\n Enter number(1,2,3): ");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    addStudents();
                    break;
                case 2:
                    removeStudents();
                    break;
            }
        } while (n != 3);
    }

    private static void addStudents() {
        System.out.println("\n___________ Add Stusent Page ___________\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();
        System.out.print("Enter Student ID:");
        String studentID = sc.next();
        System.out.print("Enter the password: ");
        String studentPassWord = sc.next();
        // Create Student object
        Student s = new Student(studentName, studentID, studentPassWord);
        // Retrieve existing students
        HashSet<Student> arrStudents = StudentFileToHashSet();
        // Add the new student to HashSet        
        arrStudents.add(s);
        // Write the updated HashSet to file        
        StudentHashSetToFile(arrStudents);
        System.out.println("Student added successfully!");
    }

    // Method to read students from file and convert to HashSet
    public static HashSet<Student> StudentFileToHashSet() {
        HashSet<Student> arrCourse = new HashSet<>();

        try (Scanner sc2 = new Scanner(new File("student.txt"))) {
            while (sc2.hasNextLine()) {
                // Read student data from file                
                String line = sc2.nextLine();
                String[] s = line.split("::");
                // Create Student object based on the data                
                if (s.length == 5) {
                    Student c = new Student(s[0], s[1], s[2], toHashSet(s[3]), toHashSet(s[4]));
                    arrCourse.add(c);
                } else if (s.length == 4) {
                    Student c = new Student(s[0], s[1], s[2], toHashSet(s[3]));
                    arrCourse.add(c);
                } else if (s.length == 3) {
                    Student c = new Student(s[0], s[1], s[2]);
                    arrCourse.add(c);
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CS102.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrCourse;
    }

    // Method to write HashSet of students to file
    public static void StudentHashSetToFile(HashSet<Student> arrCourse) {
        try (FileWriter fw = new FileWriter("student.txt")) {

            for (Student student : arrCourse) {
                fw.write(student.toString() + "\n");
            }

        } catch (IOException ex) {
            Logger.getLogger(CS102.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to remove a student
    private static void removeStudents() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        // Retrieve existing students        
        String ID = sc.next();
        HashSet<Student> students = StudentFileToHashSet();

        // Iterate over HashSet to remove the student with the given ID
        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            if (it.next().getStudentId().equalsIgnoreCase(ID)) {
                it.remove();
            }
        }

        // Write the updated HashSet to file        
        StudentHashSetToFile(students);
        System.out.println("Student removed successfully!");
    }

    private static void manageAdvisors() {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        do {
            // Display menu options for managing advisors            
            System.out.print("\n___________ Advisor Page ___________\n"
                    + "1 to add advisor"
                    + "\n2 to remove advisor"
                    + "\n3 to exit"
                    + "\n Enter number(1,2,3): ");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    addAdvisor();
                    break;
                case 2:
                    removeAdvisor();
                    break;
            }
        } while (n != 3);
    }

    private static void addAdvisor() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Advisor Name: ");
        String advisorName = sc.nextLine();
        System.out.print("Enter Advisor ID:");
        String advisorID = sc.next();
        System.out.print("Enter the password: ");
        String advisorPassWord = sc.next();

        // Create Advisor object        
        Advisor s = new Advisor(advisorName, advisorID, advisorPassWord);

        HashSet<Advisor> advisors = AdvisorFileToHashSet();
        advisors.add(s);
        AdvisorHashSetToFile(advisors);
        System.out.println("Advisor added successfully!");
    }

    private static HashSet<Advisor> AdvisorFileToHashSet() {
        HashSet<Advisor> advisors = new HashSet<>();

        try (Scanner sc2 = new Scanner(new File("advisor.txt"))) {
            while (sc2.hasNextLine()) {
                // Read advisor data from file
                String line = sc2.nextLine();
                String[] s = line.split("::");
                // Create Advisor object based on the data                
                Advisor a = new Advisor(s[0], s[1], s[2]);
                advisors.add(a);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CS102.class.getName()).log(Level.SEVERE, null, ex);
        }
        return advisors;
    }

    private static void AdvisorHashSetToFile(HashSet<Advisor> advisors) {
        try (FileWriter fw = new FileWriter("advisor.txt")) {

            for (Advisor advisor : advisors) {
                fw.write(advisor.toString() + "\n");
            }

        } catch (IOException ex) {
            Logger.getLogger(CS102.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void removeAdvisor() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Advisor ID: ");
        String ID = sc.next();
        HashSet<Advisor> advisors = AdvisorFileToHashSet();

        // Iterate over HashSet to remove the advisor with the given ID        
        Iterator<Advisor> it = advisors.iterator();

        while (it.hasNext()) {
            if (it.next().getAdvisorId().equalsIgnoreCase(ID)) {
                it.remove();
            }
        }
        // Write the updated HashSet to file
        AdvisorHashSetToFile(advisors);
        System.out.println("Advisor removed successfully!");
    }

    private static void viewSystemStat() {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        do {
            System.out.print("\n___________ System statistics Page ___________\n"
                    + "1 to print general information"
                    + "\n2 to print courses"
                    + "\n3 to print students"
                    + "\n4 to print advisors"
                    + "\n5 to exit"
                    + "\n Enter number(1,2,3,4,5): ");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    printGeneralInfo();
                    break;
                case 2:
                    printCourses();
                    break;
                case 3:
                    printStudents();
                    break;
                case 4:
                    printAdvisors();
                    break;
            }
        } while (n != 5);
    }

    private static void printGeneralInfo() {
        // Retrieve counts of courses, students, and advisors        
        HashSet<Course> hc = CourseFileToHashSet();
        HashSet<Student> hs = StudentFileToHashSet();
        HashSet<Advisor> ha = AdvisorFileToHashSet();
        // Print counts        
        System.out.println("There is " + hc.size() + " course in the system");
        System.out.println("There is " + hs.size() + " student in the system");
        System.out.println("There is " + ha.size() + " advisor in the system");
    }

    private static void printCourses() {
        HashSet<Course> hc = CourseFileToHashSet();
        for (Course course : hc) {
            System.out.println(course.courseWithFormat());
        }
    }

    private static void printStudents() {
        HashSet<Student> hc = StudentFileToHashSet();
        for (Student student : hc) {
            System.out.println(student.toStringWithFormat()+"\n---------------------------\n");
        }
    }

    private static void printAdvisors() {
        HashSet<Advisor> hc = AdvisorFileToHashSet();
        for (Advisor advisor : hc) {
            System.out.println(advisor.toStringWithformate());
        }
    }

    private static void viewAvailableCourses() {
        HashSet<Course> hc = CourseFileToHashSet();
        for (Course course : hc) {
            System.out.println(course.courseWithFormat());
        }
    }

    private static void registerForCourses(Student s) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter course code: ");
        String code = sc.next();

        //check if the course is full
        HashSet<Course> hc = CourseFileToHashSet();
        for (Course course : hc) {
            if (course.getCode().equals(code)) {
                if (course.getAvailableSeats() <= 0) {
                    System.out.println("The course is full");
                    // Store student ID and course code for later processing                    
                    IDandCODEtoFile(s, course);
                    return;
                }
            }
        }
        CourseHashSetToFile(hc);

        //check if it exsist in the file
        boolean exist = false;
        for (Course course : hc) {
            if (course.getCode().equals(code)) {
                exist = true;
            }
        }
        if (!exist) {
            System.out.println("not found in list of courses");
            return;
        }

        // Check if the course is already registered by the student
        HashSet<Student> hs = StudentFileToHashSet();
        for (Student student : hs) {
            if (student.getStudentId().equals(s.getStudentId())) {
                if (student.getRegCourses().contains(code)) {
                    System.out.println("already exist in your registered courses");
                    return;
                }
            }
        }

        //check schedule conflict
        HashSet<String> hs2 = s.getRegCourses();
        Course currentCourse = getCourseByCode(code);
        ArrayList<String> days = currentCourse.getDays();
        String time = currentCourse.getTime();
        for (String string : hs2) {
            Course c = getCourseByCode(string);
            ArrayList<String> days2 = c.getDays();
            String time1 = c.getTime();
            for (String day : days2) {
                for (String day1 : days) {
                    if (day.equalsIgnoreCase(day1) && time.equalsIgnoreCase(time1)) {
                        System.out.println("There is conflic in schedule");
                        return;
                    }
                }
            }
        }

        // Check validated courses for prerequisites
        HashSet<String> val = s.getValidatedCourses();
        String[] pre = getCourseByCode(code).getPrerequisites();
        for (int i = 0; i < pre.length; i++) {
            if (!val.contains(pre[i])) {
                System.out.println("you did not complete all prerequisites");
                return;
            }
        }
        //add register course after all cheking
        for (Student student : hs) {
            if (student.getStudentId().equals(s.getStudentId())) {
                student.addRegisteredCourse(code);
                getCourseByCode(code).setAvailableSeats(getCourseByCode(code).getAvailableSeats() - 1);
            }
        }

        StudentHashSetToFile(hs);
        System.out.println("Registration successful for course!!!!!!! ");

    }

    private static void viewRegisteredCourses(Student s) {
        HashSet<String> hs = s.getRegCourses();
        for (String h : hs) {
            Course c = getCourseByCode(h);
            System.out.println(c.courseWithFormat());
        }
    }

    private static void dropCourse(Student s) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the course code: ");
        String code = sc.next();
        HashSet<Student> hs = StudentFileToHashSet();
        boolean removed = false;
        for (Student h : hs) {
            if (h.getStudentId().equals(s.getStudentId())) {
                HashSet<String> hsh = h.getRegCourses();
                Iterator<String> iterator = hsh.iterator();
                while (iterator.hasNext()) {
                    String course = iterator.next();
                    if (course.equalsIgnoreCase(code)) {
                        iterator.remove();
                        removed = true;
                        break; // Exit loop once the course is found and removed
                    }
                }
            }
        }

        StudentHashSetToFile(hs);
        if (removed) {
            System.out.println("Course droped successfully!!!!!!!!!!!!");
        } else {
            System.out.println("Course not found!!!!!!!");
        }
    }

    private static void viewAllValidatedCourses(Student s) {
        System.out.println(s.getValidatedCourses());
    }

    private static void viewSchedule(Student s) {
        s.scheduleFormat();
    }

    public static void updatePersonalInfo(Student s) {

        Scanner sc = new Scanner(System.in);
        System.out.println("_____________ Update Personal Information ___________");
        System.out.print("Enter your Name: ");
        String studentName = sc.nextLine();
        System.out.print("Enter the new password: ");
        String studentPassWord = sc.next();
        HashSet<Student> hs = StudentFileToHashSet();
        for (Student h : hs) {
            if (h.getStudentId().equals(s.getStudentId())) {
                h.setName(studentName);
                h.setPassWord(studentPassWord);
            }
        }
        StudentHashSetToFile(hs);
        System.out.println("Password And name Updated Successfully");

        System.out.println("The System will shut down Plase login again!");

        System.exit(0);
    }

    private static void feedbackForSpecialRegistration(Student s) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the cousre code you want to register for");
        String code = sc.next();
        //check code
        HashSet<Course> hc = CourseFileToHashSet();
        Course c = null;
        for (Course course : hc) {
            if (course.getCode().equals(code)) {
                c = course;
            }
        }
        if (c == null) {
            System.out.println("course not found!!!!!");
            return;
        }
        IDandCODEtoFile(s, c);
        System.out.println("wait for the advisor");
    }

    public static void allPrerequisiteForCourse() {
        Scanner sc = new Scanner(System.in);

        HashSet<Course> a = CourseFileToHashSet();
        System.out.println("Enter Course Code");
        String testCode = sc.nextLine();
        boolean k = false;
        for (Course course : a) {
            if (testCode.equalsIgnoreCase(course.getCode())) {
                k = true;
                if (course.getPrerequisites() == null) {
                    System.out.println("\nPrerequisites Corses: \nNo Prerequisites Course");
                }
                System.out.println("The prerequisites Courses are:\n"
                        + Arrays.toString(course.getPrerequisites()).substring(1, Arrays.toString(course.getPrerequisites()).length() - 1));
            }

        }
        System.out.println(k ? "" : "There is no " + testCode + " Corse");
    }

    public static Student StudentLogIn() {
        Scanner sc = new Scanner(System.in);
        HashSet<Student> hashStd = StudentFileToHashSet();
        while (true) {
            System.out.print("Enter your ID(0 to exit): ");
            String ID = sc.next();
            if (Integer.parseInt(ID) == 0) {
                break;
            }
            System.out.print("Enter your password: ");
            String password = sc.next();
            Student searchStd = new Student("", ID, password);
            if (!hashStd.contains(searchStd)) {
                continue;
            }

            for (Student student : hashStd) {
                if (student.getStudentId().equals(ID) && student.getPassWord().equals(password)) {
                    return student;
                }
            }
        }
        return null;
    }

    private static void IDandCODEtoFile(Student s, Course courseFind) {
        try (FileWriter fw = new FileWriter("student wait list.txt")) {

            fw.write(s.getStudentId() + "::" + courseFind.getCode());

        } catch (IOException ex) {
            Logger.getLogger(CS102.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static HashSet<String> toHashSet(String string) {
        HashSet<String> hc = new HashSet<>();
        String[] arr = string.split(":");
        for (int i = 0; i < arr.length; i++) {
            hc.add(arr[i]);
        }
        return hc;
    }

    public static Course getCourseByCode(String codes) {
        HashSet<Course> sc = CourseFileToHashSet();
        Course courseFind = null;
        for (Course course : sc) {
            if (course.getCode().equals(codes)) {
                courseFind = course;
            }
        }
        return courseFind;
    }

    public static void viewRegisteredStudents() {
        System.out.println("____________ Registered Students Page _____"
                + "_______");

        HashSet<Student> h = StudentFileToHashSet();
        for (Student student : h) {
            System.out.println(student.toStringWithFormat());
            System.out.println("_______________________________________");
        }
    }

    private static void approveDenySpecialCourseRegistrationRequests() {
        Scanner input = new Scanner(System.in);
        try {
            Scanner sc = new Scanner(new File("student wait list.txt"));
            String ID = null;
            String code = null;
            while (sc.hasNext()) {
                String[] arr = sc.next().split("::");
                ID = arr[0];
                code = arr[1];
            }
            System.out.println("\n------------------------\nThe student \n------------------------\n"
                    + findStudent(ID).toStringWithFormat()
                    + "\n------------------------\nwanted to register for course \n----------------------\n "
                    + getCourseByCode(code).courseWithFormat());
            System.out.println("Enter \n1 to approve\n2 to deny ");
            int i = input.nextInt();
            if (i == 1) {
                HashSet<Student> hs = StudentFileToHashSet();
                for (Student h : hs) {
                    if (h.getStudentId().equals(ID)) {
                        h.addRegisteredCourse(code);
                    }
                }
                StudentHashSetToFile(hs);
                System.out.println("Approved successfully!!!!!!!");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CS102.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void addValidatedCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        String ID = sc.next();
        System.out.print("Enter course code: ");
        String code = sc.next();

        //check ID
        HashSet<Student> hs = StudentFileToHashSet();
        Student s = null;
        for (Student student : hs) {
            if (student.getStudentId().equals(ID)) {
                s = student;
            }
        }
        if (s == null) {
            System.out.println("student not found!!!!!");
            return;
        }

        //check code
        HashSet<Course> hc = CourseFileToHashSet();
        Course c = null;
        for (Course course : hc) {
            if (course.getCode().equals(code)) {
                c = course;
            }
        }
        if (c == null) {
            System.out.println("course not found!!!!!");
            return;
        }

        for (Student student : hs) {
            if (student.getStudentId().equals(s.getStudentId())) {
                student.addvalidatedCourses(code);
                System.out.println("validation successful for course!!!!!!! ");
            }
        }

        StudentHashSetToFile(hs);

    }

    private static void viewCoursesOfStudent() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Studen Id");
        String studentId = sc.nextLine();
        Student a = findStudent(studentId);
        if (a == null) {
            System.out.println("There is no student with this Id: " + studentId);
        } else {
            System.out.println(a.getRegCourses());
        }
    }

    public static Student findStudent(String a) {
        HashSet<Student> b = StudentFileToHashSet();
        Student c = null;
        for (Student student : b) {
            if (student.getStudentId().equalsIgnoreCase(a)) {
                c = student;
            }
        }
        if (c == null) {
            System.out.println("student not found");
        }
        return c;
    }

    public static void putStudent(Student a) {
        if (a == null) {
            return;
        }
        HashSet<Student> b = StudentFileToHashSet();
        b.add(a);
        StudentHashSetToFile(b);
    }
    //Thank you very much
    //this line is just to reach 1000 lines in coding
    //ha ha ha ha ha ha ha ha ha
}
