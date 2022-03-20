package org.sqli.authentification.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponsUserLogin {
    private  int id;
    private  String login;
    private  String password;



//
//    public int getId() {
//        return id;
//    }
//
//
//    public String getLogin() {
//        return login;
//    }
//
//
//
//    public String getPassword() {
//        return password;
//    }
//
//
//
//    public ResponsUserLogin(Builder builder) {
//
//        this.id = builder.id;
//        this.login = builder.login;
//        this.password = builder.password;
//    }
//
//
//    public  static  class Builder{
//
//        private  int id;
//        private String login;
//        private String password;
//
//        public Builder(int id, String login, String password) {
//            this.id = id;
//            this.login = login;
//            this.password = password;
//        }
//
//
//         Builder id(int id) {
//            this.id=id;
//            return this;
//        }
//
//        Builder login(String login) {
//            this.login=login;
//            return this;
//        }
//
//
//        Builder password(String password) {
//            this.password=password;
//            return this;
//        }
//
//        ResponsUserLogin build() {
//            return new ResponsUserLogin(this);
//        }
//    }
}
