package com.hibernatedemo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity                                     // tells Hibernate: “this class should be saved in a db table”
@Table(name = "student_collection")         // this will rename the db table_name to specified name
@NamedQuery(name = "minors", query = "from Student where age < :minAge")
public class Student {

    @Id                                     // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;

    @Column(name = "student_name")          // this will rename the db table column_name to specified name
    private String name;
    private int age;

    @Transient                              // ignores the below field; doesn’t store it in the database
    private String gender;

    @Embedded
    private Address address;

    @OneToOne(mappedBy = "student")
    private ReportCard GradeReport;

    @ManyToOne
    private Department dept;

    @ManyToMany
    private Set<Skill> skills = new HashSet<>();

    public ReportCard getGradeReport() { return GradeReport; }

    public void setGradeReport(ReportCard gradeReport) { GradeReport = gradeReport; }

    public Department getDept() { return dept; }

    public void setDept(Department dept) { this.dept = dept; }

    public Set<Skill> getSkills() { return skills; }

    public void setSkills(Set<Skill> skills) { this.skills = skills; }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getRollNo() { return rollNo; }

    public String getName() { return name; }

    public int getAge() { return age; }

    public String getGender() {
        return gender;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Student { " +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                " }";
    }
}
