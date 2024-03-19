package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "passport")
@Getter
@Setter
@NoArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "passportIdGenerator")
    @SequenceGenerator(name = "passportIdGenerator",initialValue = 1000,allocationSize = 10)
    @Column(name = "passport_id")
    private int passportId;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "passport_country")
    private String passportCountry;

    @Column(name = "name_on_passport")
    private String nameOnPassport;

}
