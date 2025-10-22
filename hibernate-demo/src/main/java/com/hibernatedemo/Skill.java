package com.hibernatedemo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @ManyToMany(mappedBy = "skills")
    private Set<Student> students = new HashSet<>();
    private String name;
    private String category;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
