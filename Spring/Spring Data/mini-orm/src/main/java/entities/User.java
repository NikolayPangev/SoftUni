package entities;


import annotations.Column;
import annotations.Entity;
import annotations.Id;
import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "confirmPassword")
    private String confirmPassword;

    @Column(name = "age")
    private int age;

}