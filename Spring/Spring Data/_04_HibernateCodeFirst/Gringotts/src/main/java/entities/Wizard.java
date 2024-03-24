package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wizards")
public class Wizard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 60, nullable = false)
    private String lastName;

    @Column(length = 1000, columnDefinition = "TEXT")
    private String note;

    @Column(nullable = false)
    private Integer age;

    @OneToOne
    @JoinColumn
    private MagicWand magicWand;

    @OneToMany
    @JoinTable(name = "wizard_deposits")
    private List<Deposit> deposits;
}
