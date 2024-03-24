package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student extends Person {

    @Column(name = "average_grade", nullable = false)
    private Float averageGrade;

    @Column
    private Integer attendance;

    @ManyToMany
    @JoinTable(
            name = "students_courses",
            joinColumns =
            @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "course_id", referencedColumnName = "id")
    )

    private Set<Courses> courses;

    public Student() {
        super();
    }

    public Student(String firstName, String lastName, String phoneNumber, Float averageGrade, Integer attendance) {
        super(firstName, lastName, phoneNumber);
        this.averageGrade = averageGrade;
        this.attendance = attendance;
    }
}
