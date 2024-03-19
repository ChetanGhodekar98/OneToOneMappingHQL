package Util;

import Model.Passport;
import Model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchData {
    public static void main(String[] args) {
        Session session =new Configuration().configure().
                addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory()
                .openSession();

        Person person=session.load(Person.class,1);
        System.out.println("PERSON NAME ->"+person.getPersonName());
        System.out.println("PERSON AGE ->"+person.getPersonAge());
        System.out.println("PASSPORT NUMBER ->"+person.getPassportRef().getPassportNumber());
        System.out.println("COUNTRY ->"+person.getPassportRef().getPassportCountry());

        session.close();
    }
}
