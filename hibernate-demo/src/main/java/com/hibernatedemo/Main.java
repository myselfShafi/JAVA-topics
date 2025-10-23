package com.hibernatedemo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Address s1Addr = new Address();
        ReportCard s1Report = new ReportCard();
        Department dept = new Department();
        Skill s1Skill = new Skill();
        Skill s2Skill = new Skill();
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        Configuration cfg = new Configuration();
        cfg.configure();

        try (
                SessionFactory sf = cfg.buildSessionFactory();
                Session session = sf.openSession();
                ) {
            Transaction tx = session.beginTransaction();
            // Create Ops
            s1Addr.setAddressLine("Patrika Nagar");
            s1Addr.setCity("Hyderabad");
            s1Addr.setState("Telangana");
            s1Addr.setCountry("India");

            s1Report.setGpa(9.8);
            s1Report.setGradeLevel("A");
            s1Report.setRemark("Very Good");
            s1Report.setStudent(s1);

            dept.setName("Engineering");
            dept.setLocation("Vizag");
            dept.setStudent(Arrays.asList(s1, s2));

            s1Skill.setName("Programming");
            s1Skill.setCategory("Tech");
            s1Skill.setStudents(Set.of(s2, s3));

            s2Skill.setName("Communication");
            s2Skill.setCategory("Personal Trait");
            s2Skill.setStudents(Set.of(s1, s2));

            s1.setName("Venkat");
            s1.setAge(23);
            s1.setAddress(s1Addr);
            s1.setGradeReport(s1Report);
            s1.setDept(dept);
            s1.setSkills(Set.of(s2Skill));

            s2.setName("Murali");
            s2.setAge(26);
            s2.setDept(dept);
            s2.setSkills(Set.of(s1Skill, s2Skill));

            s3.setName("Shafi");
            s3.setAge(28);
            s3.setDept(dept);
            s3.setSkills(Set.of(s2Skill));

            session.persist(s1Report);
            session.persist(dept);
            session.persist(s1Skill);
            session.persist(s2Skill);
            session.persist(s1);
            session.persist(s2);
            session.persist(s3);

//            // Update/Upsert Ops
//            Student s2 = new Student();
//            s2.setRollNo(3);
//            s2.setName("Varun");
//            s2.setAge(24);
//            session.merge(s2); // works as upsertion

//            // Delete Ops
//            Student s3 = session.find(Student.class, 3); // fetches the obj
//            session.remove(s3); // pass the fetched obj for deletion

            tx.commit();

            // Read Ops
            System.out.println(session.find(Student.class, 1));
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}