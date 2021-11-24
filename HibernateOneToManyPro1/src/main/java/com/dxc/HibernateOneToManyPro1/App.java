package com.dxc.HibernateOneToManyPro1;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dxc.HibernateOneToManyPro1.persist.Address;
import com.dxc.HibernateOneToManyPro1.persist.Employee;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hibernate mapping One to Many " );
        System.out.println("....................................");
        Configuration conf=new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory=conf.buildSessionFactory();
        Session session=factory.openSession();
        Transaction t= session.beginTransaction();
        Employee emp=new Employee();
        emp.setEmpcode(1001);
        emp.setEmpname("Deepak");
        emp.setDesignation("Manager");
        Address a1=new Address();
        a1.setHno(1231);
        a1.setColony("Vijaynagar");
        a1.setCity("Bengaluru");
        Address a2=new Address();
        a2.setHno(987);
        a2.setColony("Raghavendra");
        a2.setCity("Raichur");
        List<Address> list=new ArrayList<Address>();
        list.add(a1);
        list.add(a2);
        emp.setAddress(list);
        session.save(emp);
        t.commit();
        System.out.println("Done...!");
        
    }
}
