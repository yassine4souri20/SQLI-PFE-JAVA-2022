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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;


    @Column(name = "ENABLE" ,nullable = false, columnDefinition = "integer default 1")
    private boolean  enabled;

    @Column(name = "LOGINATTEMPTS",nullable = false, columnDefinition = "integer default 0")
    private int loginAttemts;



    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group groupId;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", loginAttemts=" + loginAttemts +
                ", groupId=" + groupId +
                '}';
    }
}
