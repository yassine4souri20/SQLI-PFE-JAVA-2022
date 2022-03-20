package org.sqli.authentification.service;
import org.springframework.http.ResponseEntity;
import org.sqli.authentification.dto.RequestUser;


public interface UserService   {

    ResponseEntity<?> findByLoginPassword(String login, String password);

    RequestUser addUserGroup(RequestUser user);

    String deleteUserLogin(String login);
}
