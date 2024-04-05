package org.example.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name="user_table")
public class User {

    @Column(name = "User_id")
    @Id
    @GeneratedValue
    private int userId;
    @Column(name="User_name",nullable = false)
    private String userName;
    @Column(name="Email",nullable = false,unique = true)
    private String email;
    @Column(name="Password",nullable = false)
    private String password;
    public enum Role {
        ADMIN,
        SITEMANAGER,
        EMPLOYEE
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "Role",nullable = false)
    private Role role;
    public enum Gender{
        MALE,
        FEMALE
    }
    @Column(name="Gender",nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name="LastLogin",nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLoginTime;

}
