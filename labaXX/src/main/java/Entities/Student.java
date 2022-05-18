package Entities;

public class Student extends Human {
    private String faculty;
    private String university;
    private String specialization;

    public Student() {
    }

    public Student(String name, String secondName, String fathersName, int age, String faculty) {
        super(name, secondName, fathersName, age);
        this.faculty = faculty;
    }

    public Student(String name, String secondName, String fathersName, int age, String faculty, String university, String specialization) {
        super(name, secondName, fathersName, age);
        this.faculty = faculty;
        this.university = university;
        this.specialization = specialization;
    }

    public Student(Student student) {
        super(student);
        this.faculty = student.getFaculty();
    }

    public Student clone() {

        return new Student(this.getName(), this.getSecondName(), this.getFathersName(), this.getAge(), this.getFaculty());
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

}
