package org.sqli.authentification.service;
import org.springframework.http.ResponseEntity;
import org.sqli.authentification.dto.Errors;
import org.sqli.authentification.dto.RequestUser;
import org.sqli.authentification.entitie.User;


public interface UserService {

    ResponseEntity<?> findByLoginPassword(String login, String password);

    void incrementeAttempts(User user);

    ResponseEntity<Errors> isAccountNonLocked(String login);


    Object addUser(RequestUser user);

    Object deleteUserByLogin(String login);
}
