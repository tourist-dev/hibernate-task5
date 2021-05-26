package org.orakris;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();

//        // store data into database
//        Train train1 = new Train();
//        train1.setName("tabc");
//
//        Train train2 = new Train();
//        train2.setName("tdef");
//
//        Train train3 = new Train();
//        train3.setName("tghi");
//
//        Train train4 = new Train();
//        train4.setName("tjkl");
//
//        Passenger passenger1 = new Passenger();
//        passenger1.setName("pabc");
//        passenger1.setAge(30);
//        ArrayList<Train> l1 = new ArrayList<>();
//        l1.add(train1);
//        l1.add(train2);
//        passenger1.setTrainList(l1);
//
//        Passenger passenger2 = new Passenger();
//        passenger2.setName("pdef");
//        passenger2.setAge(46);
//        ArrayList<Train> l2 = new ArrayList<>();
//        l2.add(train1);
//        l2.add(train4);
//        passenger2.setTrainList(l2);
//
//        Passenger passenger3 = new Passenger();
//        passenger3.setName("pghi");
//        passenger3.setAge(25);
//        ArrayList<Train> l3 = new ArrayList<>();
//        l3.add(train1);
//        l3.add(train3);
//        passenger3.setTrainList(l3);
//
//        session.persist(passenger1);
//        session.persist(passenger2);
//        session.persist(passenger3);
//
//        transaction.commit();

        // Criterial object in hibernate
        Criteria criteria1 = session.createCriteria(Passenger.class);

        // Restrictions api - Query 1
        criteria1.add(Restrictions.between("age", 25, 45));

        List list = criteria1.list();
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Passenger passenger = (Passenger) itr.next();
            System.out.println(passenger.getId() + " " + passenger.getName() + " " + passenger.getAge());
        }
        session.close();
        System.out.println("success");
    }
}
