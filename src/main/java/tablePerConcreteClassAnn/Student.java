package tablePerConcreteClassAnn;

import jakarta.persistence.*;

@Entity
@Table(name = "STUDENTS")
public class Student extends Person {

    @Column(name = "MAJOR")
    private String major;

    @Column(name = "GPA")
    private Double gpa;

    // Getters and Setters
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
}
