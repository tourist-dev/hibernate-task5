package org.orakris;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;

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
        Transaction transaction = session.beginTransaction();

        // store data into database
        Train train1 = new Train();
        train1.setName("tabc");

        Train train2 = new Train();
        train2.setName("tdef");

        Train train3 = new Train();
        train3.setName("tghi");

        Train train4 = new Train();
        train4.setName("tjkl");

        Passenger passenger1 = new Passenger();
        passenger1.setName("pabc");
        passenger1.setAge(30);
        ArrayList<Train> l1 = new ArrayList<>();
        l1.add(train1);
        l1.add(train2);
        passenger1.setTrainList(l1);

        Passenger passenger2 = new Passenger();
        passenger2.setName("pdef");
        passenger2.setAge(46);
        ArrayList<Train> l2 = new ArrayList<>();
        l2.add(train1);
        l2.add(train4);
        passenger2.setTrainList(l2);

        Passenger passenger3 = new Passenger();
        passenger3.setName("pghi");
        passenger3.setAge(25);
        ArrayList<Train> l3 = new ArrayList<>();
        l3.add(train1);
        l3.add(train3);
        passenger3.setTrainList(l3);

        session.persist(passenger1);
        session.persist(passenger2);
        session.persist(passenger3);

        transaction.commit();
        session.close();
        System.out.println("success");
    }
}
