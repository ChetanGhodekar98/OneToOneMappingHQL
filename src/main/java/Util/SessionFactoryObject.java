package Util;

import Model.Passport;
import Model.Person;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryObject {
    static SessionFactory sessionFactory;
    static {
        sessionFactory=new Configuration().configure()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory();
    }
}
