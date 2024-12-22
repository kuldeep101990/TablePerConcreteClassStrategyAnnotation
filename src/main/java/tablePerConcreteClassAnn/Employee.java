package tablePerConcreteClassAnn;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPLOYEES")
public class Employee extends Person {

    @Column(name = "SALARY")
    private Double salary;

    @Column(name = "TITLE")
    private String title;

    // Getters and Setters
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
