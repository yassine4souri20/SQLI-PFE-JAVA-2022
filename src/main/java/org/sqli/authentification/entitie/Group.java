package org.sqli.authentification.entitie;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "user_group")
public class Group {

    @Id
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany
    private List<User> users;
}

