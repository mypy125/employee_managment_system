package org.example.database;

import org.example.domain.backlog.Backlog;
import org.example.domain.employee.Employee;
import org.example.domain.sprint.Sprint;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateRunner {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Backlog.class)
                .addAnnotatedClass(Deprecated.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Sprint.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            //-----start transaction
            session.beginTransaction();

            //---creating objects
            Employee employee = new Employee();
            session.save(employee);
            System.out.println("Employee save successfully");

            Employee retrievedEmployee = session.get(Employee.class, employee.getId());


            //------end transaction
            session.getTransaction().commit();

        }finally {
            sessionFactory.close();
        }
    }
}
