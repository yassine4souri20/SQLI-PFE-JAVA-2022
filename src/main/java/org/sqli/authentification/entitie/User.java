package org.sqli.authentification.entitie;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;


    @Column(name = "enabled" ,nullable = false, columnDefinition = "integer default 1")
    private boolean  enabled;

    @Column(name = "loginattempts",nullable = false, columnDefinition = "integer default 0")
    private int loginAttempts;


    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group_id;


}
