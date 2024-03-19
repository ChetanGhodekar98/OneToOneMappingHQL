package Util;

import Model.Passport;
import Model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddData {
    public static void main(String[] args) {
        Session session =new Configuration().configure().
                addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory()
                .openSession();
        Transaction tx= session.beginTransaction();

        Passport passport=new Passport();
        passport.setPassportNumber("12345FGH09876R");
        passport.setNameOnPassport("ROHAN SHELAR");
        passport.setPassportCountry("INDIA");

        Person person=new Person();
        person.setPersonName("ROHAN");
        person.setPersonAddress("BANGLORE");
        person.setPersonAge(27);
        person.setPassportRef(passport);

        session.persist(person);
        tx.commit();
        session.close();
        System.out.println("DATA SAVE");
    }
}
