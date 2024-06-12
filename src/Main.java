import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("John", "Doe", "doe@wp.pl", "Warsaw, Zlota 12", "333-322-222", new Date(1980, 1, 1));
        Students.addStudent(s);
        StudyProgramme it = new StudyProgramme("IT", "AAA", 7, 5);
        s.enrollStudent(it);
        s.addGrade(5, "PGO");
        s.addGrade(2, "APBD");

        Students.promoteAllStudents();
        Students.displayInfoAboutAllStudents();
    }
}
class Student {
    private static int studentCounter = 0;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private Date birthDate;
    private String indexNumber;
    private StudyProgramme programme;
    private int currentSemester;
    private String status;
    private List<Grade> grades;

    public Student(String firstName, String lastName, String email, String address, String phone, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.birthDate = birthDate;
        this.indexNumber = "s" + (++studentCounter);
        this.status = "kandydat";
        this.currentSemester = 1;
        this.grades = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public StudyProgramme getProgramme() {
        return programme;
    }

    public void setProgramme(StudyProgramme programme) {
        this.programme = programme;
    }

    public int getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public void enrollStudent(StudyProgramme programme) {
        this.programme = programme;
        this.status = "student";
    }

    public void addGrade(int semester, String grade) {
        this.grades.add(new Grade(semester, grade));
    }

    public void promoteToNextSemester() {
        if (this.currentSemester < this.programme.getTotalSemesters()) {
            this.currentSemester++;
        } else {
            this.status = "absolwent";
        }
    }

    public void displayInfo() {
        System.out.println("Student: " + firstName + " " + lastName + ", Index: " + indexNumber + ", Semester: " + currentSemester + ", Status: " + status);
    }
}

class StudyProgramme {
    private String name;
    private String code;
    private int totalSemesters;
    private int maxITNs;

    public StudyProgramme(String name, String code, int totalSemesters, int maxITNs) {
        this.name = name;
        this.code = code;
        this.totalSemesters = totalSemesters;
        this.maxITNs = maxITNs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTotalSemesters() {
        return totalSemesters;
    }

    public void setTotalSemesters(int totalSemesters) {
        this.totalSemesters = totalSemesters;
    }

    public int getMaxITNs() {
        return maxITNs;
    }

    public void setMaxITNs(int maxITNs) {
        this.maxITNs = maxITNs;
    }
}

class Grade {
    private int semester;
    private String grade;

    public Grade(int semester, String grade) {
        this.semester = semester;
        this.grade = grade;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

class Students {
    private static List<Student> studentList = new ArrayList<>();

    public static void addStudent(Student student) {
        studentList.add(student);
    }

    public static void promoteAllStudents() {
        for (Student student : studentList) {
            student.promoteToNextSemester();
        }
    }

    public static void displayInfoAboutAllStudents() {
        for (Student student : studentList) {
            student.displayInfo();
        }
    }
}


