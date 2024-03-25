import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column
    private String address;


    @Column(unique = true)
    private String email;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column
    private Byte[] picture;

    @Column(name = "has_medical_insurance")
    private Boolean hasMedicalInsurance;

    @OneToMany(mappedBy = "patient")
    private List<Visitation> visitations;
}
