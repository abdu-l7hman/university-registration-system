package cs102;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import static cs102.CS102.getCourseByCode;

public class Student {

    private String name;
    private String studentId;
    private HashSet<String> regCourses;
    private HashSet<String> validatedCourses;
    private String passWord;
    private String[][] schedule;

    public Student(String name, String studentId, String PassWord, HashSet<String> hs) {
        this.name = name;
        this.studentId = studentId;
        this.passWord = PassWord;
        this.regCourses = hs;
    }

    public Student(String name, String studentId, String PassWord, HashSet<String> regCourses, HashSet<String> validatedCourses) {
        this.name = name;
        this.studentId = studentId;
        this.passWord = PassWord;
        this.regCourses = regCourses;
        this.validatedCourses = validatedCourses;
    }

    public Student(String name, String studentId, String PassWord) {
        this.name = name;
        this.studentId = studentId;
        this.passWord = PassWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public HashSet<String> getRegCourses() {
        return regCourses;
    }

    public void setRegCourses(HashSet<String> regCourses) {
        this.regCourses = regCourses;
    }

    public void addRegisteredCourse(String code) {
        if (regCourses == null) {
            regCourses = new HashSet<>();
        }
        regCourses.add(code);
    }

    public void addvalidatedCourses(String code) {
        if (validatedCourses == null) {
            validatedCourses = new HashSet<>();
        }
        validatedCourses.add(code);
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String toStringWithFormat() {
        return "Student Name:" + name + " \nStudent Id:" + studentId
                + "\nThe registered courses are: \n" + (regCourses == null ? "No Course yet!" : regCourses)
                + "\nStuden validated courses: " + (validatedCourses == null ? "No Course yet!" : validatedCourses);
    }

    public String[][] getSchedule() {
        schedule = new String[5][5];
        for (int i = 0; i < schedule.length; i++) {
            for (int j = 0; j < schedule[0].length; j++) {
                schedule[i][j] = "";
            }
        }
        return schedule;
    }

    @Override
    public String toString() {
        return name + "::" + studentId + "::" + passWord + ((regCourses != null) ? "::" + print(regCourses) : "") + ((validatedCourses != null) ? "::" + print(validatedCourses) : "");
    }

    public static String print(HashSet<String> regCourses) {
        String sentence = "";
        for (String regCourse : regCourses) {
            sentence += regCourse + ":";
        }
        return sentence.substring(0, sentence.length() - 1);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.studentId);
        hash = 71 * hash + Objects.hashCode(this.passWord);
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
        final Student other = (Student) obj;
        if (!Objects.equals(this.studentId, other.studentId)) {
            return false;
        }
        if (!Objects.equals(this.passWord, other.passWord)) {
            return false;
        }
        return true;
    }

    public HashSet<String> getValidatedCourses() {
        return validatedCourses;
    }

    public void setValidatedCourses(HashSet<String> validatedCourses) {
        this.validatedCourses = validatedCourses;
    }

    boolean hasCompletedPrerequisites(Course courseFind) {
        String[] arr = courseFind.getPrerequisites();
        HashSet<String> hc = this.getValidatedCourses();
        if (hc == null) {
            return true;
        }
        for (String pre : arr) {
            for (String course : hc) {
                if (!pre.equalsIgnoreCase(course)) {
                    return false;
                }

            }
        }
        return true;
    }

    public void scheduleFormat() {
        this.schedule = new String[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.schedule[i][j] = "";
            }
        }
        if (this.schedule == null) {
            System.out.println("There is no schedule yet");
            return;
        }
        HashSet<String> hc = this.regCourses;
        ScheduleEdit(hc);

        String divider = "------------+---------+---------+---------+---------+---------+";

        System.out.printf("%-12s| %-8s| %-8s| %-8s| %-8s| %-8s%n", "", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday");
        System.out.println(divider);

        for (int i = 0; i < this.schedule.length; i++) {
            String time = getTime(i);
            System.out.printf("%-12s|", time);

            for (int j = 0; j < this.schedule[0].length; j++) {
                System.out.printf(" %-8s|", this.schedule[i][j]);
            }
            System.out.println();
            System.out.println(divider);
        }
    }

    private String getTime(int i) {
        switch (i) {
            case 0:
                return "8:00-9:00";
            case 1:
                return "9:00-10:00";
            case 2:
                return "10:00-11:00";
            case 3:
                return "11:00-12:00";
            case 4:
                return "12:00-1:00";
        }
        return "";
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public void ScheduleEdit(HashSet<String> hc) {
        for (String string : hc) {
            Course co = getCourseByCode(string);

            ArrayList<String> days = co.getDays();
            String time = co.getTime();
            for (String day : days) {
                int dayIndex = -1;
                int timeIndex = -1;

                switch (day.toLowerCase().trim()) {
                    case "sunday":
                        dayIndex = 0;
                        break;
                    case "monday":
                        dayIndex = 1;
                        break;
                    case "tuesday":
                        dayIndex = 2;
                        break;
                    case "wednesday":
                        dayIndex = 3;
                        break;
                    case "thursday":
                        dayIndex = 4;
                        break;
                }

                // Mapping times to rows
                if (time.equalsIgnoreCase("8:00-9:00")) {
                    timeIndex = 0;
                } else if (time.equalsIgnoreCase("9:00-10:00")) {
                    timeIndex = 1;
                } else if (time.equalsIgnoreCase("10:00-11:00")) {
                    timeIndex = 2;
                } else if (time.equalsIgnoreCase("11:00-12:00")) {
                    timeIndex = 3;
                } else if (time.equalsIgnoreCase("12:00-1:00")) {
                    timeIndex = 4;
                }
                schedule[timeIndex][dayIndex] = co.getCode();

                //Update schedule based on the mode (i)
                if (dayIndex != -1 && timeIndex != -1) {
                    if (schedule[timeIndex][dayIndex].equals("")) {
                        schedule[timeIndex][dayIndex] = co.getCode();
                    }
                }
            }
        }
    }
}
