package com.hibernatedemo;

import jakarta.persistence.*;

@Entity                                     // tells Hibernate: “this class should be saved in a db table”
@Table(name = "student_collection")         // this will rename the db table_name to specified name
public class Student {

    @Id                                     // primary key
    private int rollNo;

    @Column(name = "student_name")          // this will rename the db table column_name to specified name
    private String name;
    private int age;

    @Transient                              // ignores the below field; doesn’t store it in the database
    private String address;

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String setAddress() {
        return address;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void getAddress(String address) {
        this.address = address;
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
