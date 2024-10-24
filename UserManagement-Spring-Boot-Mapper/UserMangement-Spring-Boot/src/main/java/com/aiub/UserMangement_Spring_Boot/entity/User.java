package com.aiub.UserMangement_Spring_Boot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name",nullable = false,length = 45)
    private String firstName;
    @Column(name = "last_name",nullable = false,length = 45)
    private String lastName;
    @Column(name = "email",nullable = false,length = 45)
    private String email;

}
