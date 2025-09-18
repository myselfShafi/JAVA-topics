package com.hibernatedemo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();

        Configuration cfg = new Configuration();
        cfg.configure();

        try (
                SessionFactory sf = cfg.buildSessionFactory();
                Session session = sf.openSession();
                ) {
            Transaction tx = session.beginTransaction();
//            // Create Ops
//            s1.setRollNo(2);
//            s1.setName("Basheer");
//            s1.setAge(28);
//            session.persist(s1);

//            // Update/Upsert Ops
//            Student s2 = new Student();
//            s2.setRollNo(3);
//            s2.setName("Varun");
//            s2.setAge(24);
//            session.merge(s2); // works as upsertion

            // Delete Ops
            Student s3 = session.find(Student.class, 3); // fetches the obj
            session.remove(s3); // pass the fetched obj for deletion

            tx.commit();

            // Read Ops
            System.out.println(session.find(Student.class, 1));


        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}