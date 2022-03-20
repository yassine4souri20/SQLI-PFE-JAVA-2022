package org.sqli.authentification.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sqli.authentification.entitie.User;

@Repository
public interface UserDao extends JpaRepository<User ,Integer> {


    User findByLoginAndPassword(String login, String password);
    User findByLogin(String login);
    User deleteUserByLogin(String login);



}
