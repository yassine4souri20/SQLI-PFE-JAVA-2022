package org.sqli.authentification.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.sqli.authentification.entitie.User;


public interface UserDao extends JpaRepository<User ,Integer> {


    User findByLoginAndPassword(String login, String password);
    User findByLogin(String login);
    void removeByLogin(String login);



}
