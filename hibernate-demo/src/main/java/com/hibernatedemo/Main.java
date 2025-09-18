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

        s1.setRollNo(2);
        s1.setName("Basheer");
        s1.setAge(28);
        session.persist(s1);

        tx.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}