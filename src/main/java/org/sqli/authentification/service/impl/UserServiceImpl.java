package org.sqli.authentification.service.impl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.sqli.authentification.dao.UserDao;
import org.sqli.authentification.dto.Errors;
import org.sqli.authentification.dto.RequestUser;
import org.sqli.authentification.dto.ResponsUserLogin;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.service.UserService;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final  UserDao userDao;



    @Override
    public ResponseEntity<?> findByLoginPassword(String login, String password) {
       User user = userDao.findByLoginAndPassword(login, password);

       if(user!=null ){

           return ResponseEntity.ok(ResponsUserLogin.builder()
                   .id(user.getId())
                   .login(user.getLogin())
                   .password(user.getPassword())
                   .build());
       }


        return ResponseEntity.badRequest().body(Errors.builder().message("Authentificatin error!").build());
    }

    @Override
    public RequestUser addUserGroup(RequestUser user) {
        return null;
    }

    @Override
    public String deleteUserLogin(String login) {
        return null;
    }
}
