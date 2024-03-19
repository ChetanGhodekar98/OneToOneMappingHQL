package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int personId;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "person_address")
    private String personAddress;

    @Column(name = "person_age")
    private int personAge;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.DETACH})
    //@OneToOne(cascade= CasCadeType.ALL)
    @JoinColumn(name = "passport_ref")
    private Passport passportRef;


}
