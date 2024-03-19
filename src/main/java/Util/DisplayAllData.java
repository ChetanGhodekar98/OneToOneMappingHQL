package Util;

import Model.Passport;
import Model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DisplayAllData {
    public static void main(String[] args) {
        SessionFactory sessionFactory =SessionFactoryObject.sessionFactory;
        Session session =sessionFactory.openSession();
        String selectQuery="from Person p join Passport pass on p.passportRef=pass.passportId";
        Query  query=session.createQuery(selectQuery);
        List<Object[]> data=query.getResultList();
        System.out.println("PID\tNAME\tAGE\tADDRESS\tNAMEONPASSPORT\tPASSPORTCOUNTRY");
       for(Object[] o:data){
           Person personData=(Person) o[0];
           Passport passportData=(Passport) o[1];
           System.out.println(personData.getPersonId()+"\t"+personData.getPersonName()+"\t"+"\t"+personData.getPersonAge()
                   +"\t"+personData.getPersonAddress()+"\t"+passportData.getNameOnPassport()+"\t"+
                   passportData.getPassportCountry()
           );
       }

    }
}
