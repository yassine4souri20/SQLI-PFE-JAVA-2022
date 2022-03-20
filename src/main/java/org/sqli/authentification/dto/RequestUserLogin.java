package org.sqli.authentification.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserLogin {

    private  String login;
    private  String password;

//    public RequestUserLogin(Builder builder) {
//        this.login=builder.login;
//        this.password=builder.password;
//    }
//
//
//    public String getLogin() {
//        return login;
//    }
//
//
//    public String getPassword() {
//        return password;
//    }
//
//
//    static  class Builder{
//
//        private  final String login;
//        private  final String password;
//
//        Builder(String login, String password) {
//            this.login = login;
//            this.password = password;
//        }
//
//        RequestUserLogin.Builder login(String login) {
//
//            return this;
//        }
//
//
//        RequestUserLogin.Builder password(String password) {
//
//            return this;
//        }
//
//        RequestUserLogin build() {
//            return new RequestUserLogin(this);
//        }
//    }
}
