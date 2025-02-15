package cs102;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Course implements Comparable<Course> {

    private String code;
    private String name;
    private String description;
    private String instructor;
    private int availableSeats;
    private String time;
    private ArrayList days;
    private String[] prerequisites;
    private int credits;
    //for students
    private HashSet<Student> enrolledStudents;

    ;

    public HashSet<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(HashSet<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public Course(String code, String name, String description,
            String instructor, int availableSeats, String time, ArrayList days,
            String[] prerequisites, int credits) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.instructor = instructor;
        this.availableSeats = availableSeats;
        this.time = time;
        this.days = days;
        this.prerequisites = prerequisites;
        this.credits = credits;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList getDays() {
        return days;
    }

    public void setDays(ArrayList days) {
        this.days = days;
    }

    public String[] getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String[] prerequisites) {
        this.prerequisites = prerequisites;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

@Override
    public String toString() {
        return code + "::" + name + "::" + description
                + "::" + instructor + "::"
                + availableSeats + "::" + time + "::" + print(days)
                + "::" + print(prerequisites) + "::" + credits + ((enrolledStudents != null) ? "::" + print(enrolledStudents) : "");
    }
    
    public static String print(String[] s) {
        String sentence = "";
        for (int i = 0; i < s.length; i++) {
            if (i < s.length - 1) {
                sentence += (s[i] + ":");
            } else {
                sentence += s[i];
            }
        }
        return sentence;
    }

    public static String print(HashSet<Student> enrolledStudents) {
        String sentence = "";
        for (Student enrolledStudent : enrolledStudents) {
            sentence += enrolledStudent.getStudentId() + ":";
        }
        return sentence.substring(0, sentence.length() - 1);
    }

    public static String print(ArrayList s) {
        String sentence = "";
        for (int i = 0; i < s.size(); i++) {
            if (i < s.size() - 1) {
                sentence += (s.get(i) + ":");
            } else {
                sentence += s.get(i);
            }
        }
        return sentence;
    }

    @Override
    public int compareTo(Course t) {
        return this.code.compareToIgnoreCase(t.code);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }

    public boolean isFull() {
        if (this.availableSeats == 0) {
            return true;
        }
        return false;
    }

    public String courseWithFormat() {
        return "----------------------------------\nCourse Code: " + code + "\n"
                + "Course Name: " + name + "\n"
                + "Instructor: Dr." + instructor + "\n"
                + "Course Description:\n" + description + "\n"
                + "Available Seats: " + availableSeats + "\n"
                + "Course Time: " + time + "\n"
                + "Course Days: " + (days == null ? "To be Assigned" : daysToString()) + "\n"
                + "Prerequisite Courses:\n" + prerequisitesToString() + "\n"
                + "Credits Hours: " + credits + "\n";
    }

    private String daysToString() {
        if (days == null) {
            return "To be Assigned";
        }
        StringBuilder sb = new StringBuilder();
        for (Object day : days) {
            sb.append(day).append(", ");
        }
        return sb.toString().substring(0, sb.length() - 2); // remove the trailing comma and space
    }

    private String prerequisitesToString() {
        if (prerequisites == null || prerequisites.length == 0) {
            return "No prerequisite courses";
        }
        StringBuilder sb = new StringBuilder();
        for (String course : prerequisites) {
            sb.append(course).append(", ");
        }
        return sb.toString().substring(0, sb.length() - 2); // remove the trailing comma and space
    }
}
