package org.sqli.authentification.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.sqli.authentification.dao.GroupDao;
import org.sqli.authentification.dao.UserDao;
import org.sqli.authentification.dto.Errors;
import org.sqli.authentification.dto.RequestUser;
import org.sqli.authentification.dto.ResponsUserLogin;
import org.sqli.authentification.entitie.Group;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.service.UserService;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    GroupDao groupDao;

    private final Integer MAX_FAILED_ATTEMPTS = 3;

    private ResponseEntity<Errors> errorsResponseEntity;


    @Override
    public ResponseEntity<?> findByLoginPassword(String login, String password) {

        User user = userDao.findByLoginAndPassword(login, password);
        errorsResponseEntity = isAccountNonLocked(login);
        if (user != null) {
            if (!checkIsdesabled(user)) {
                return ResponseEntity.ok(ResponsUserLogin.builder()
                        .id(user.getId())
                        .login(user.getLogin())
                        .group(user.getGroup_id().getName())
                        .build());
            } else {
                incrementeAttempts(user);
                errorsResponseEntity = ResponseEntity.badRequest().body(Errors.builder().message("User disabled").build());
            }
        } else if (userDao.findByLogin(login).getLoginAttempts() == MAX_FAILED_ATTEMPTS) {
            incrementeAttempts(userDao.findByLogin(login));
            return errorsResponseEntity;
        } else {
            incrementeAttempts(userDao.findByLogin(login));
            errorsResponseEntity = ResponseEntity.badRequest().body(Errors.builder().message("Authentificatin error").build());
            errorsResponseEntity = ResponseEntity.badRequest().body(Errors.builder().message("Authentificatin error").build());
        }

        return errorsResponseEntity;
    }

    @Override
    public void incrementeAttempts(User user) {
        int temp = user.getLoginAttempts() + 1;
        user.setLoginAttempts(temp);
        userDao.save(user);
    }

    @Override
    public ResponseEntity<Errors> isAccountNonLocked(String login) {
        User user = userDao.findByLogin(login);
        Integer temp = user.getLoginAttempts();

        if (temp == MAX_FAILED_ATTEMPTS) {
            user.setEnabled(false);
            userDao.save(user);
            return ResponseEntity
                    .badRequest().
                    body(Errors
                            .builder()
                            .message("You have reached 3 failed authentication attempts, your account will be disabled")
                            .build());
        }
        return null;


    }

    private boolean checkIsdesabled(User user) {
        return !user.isEnabled();
    }

    public ResponseEntity<?> addUser(RequestUser userRequest) {
        Group group = groupDao.findByName(userRequest.getGroup());
        // System.out.println("------------------------------"+group);
        List<User> users = userDao.findAll();
        Integer id = users.size() + 1;
        System.out.println(id);

        if (group == null) {
            return ResponseEntity.badRequest().body(Errors.builder().message("Group not found").build());
        }
        User user = userDao.findByLogin(userRequest.getLogin());
        if (user == null) {
            user.setId(id);
            user.setLogin(userRequest.getLogin());
            user.setPassword(userRequest.getPassword());
            user.setEnabled(true);
            user.setLoginAttempts(0);
            user.setGroup_id(group);
            userDao.save(user);
            return ResponseEntity.ok("user save success !");
        }

        return ResponseEntity
                .badRequest().
                body(Errors
                        .builder()
                        .message("user not found")
                        .build());

    }


    public ResponseEntity<?> deleteUserByLogin(String login) {

        if (userDao.findByLogin(login) != null) {
            userDao.deleteUserByLogin(login);
            return ResponseEntity
                    .badRequest().
                    body(Errors
                            .builder()
                            .message("Login " + login + " is deleted")
                            .build());
        }

        return ResponseEntity
                .badRequest().
                body(Errors
                        .builder()
                        .message("Login " + login + " not found to delete")
                        .build());

    }
}
