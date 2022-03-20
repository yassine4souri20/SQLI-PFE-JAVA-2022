package org.sqli.authentification.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestUser {
    private  String login;
    private  String password;
    private   String group;



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
//    public String getGroup() {
//        return group;
//    }
//
//
//
//    public RequestUser(Builder builder) {
//
//        this.login = builder.login;
//        this.password = builder.password;
//        this.group=builder.group;
//    }
//
//
//    static  class Builder{
//
//        private final String login;
//        private  final  String password;
//        private final String group;
//
//        Builder(String login, String password, String group) {
//            this.login = login;
//            this.password = password;
//            this.group = group;
//        }
//
//        RequestUser.Builder login(String login) {
//
//            return this;
//        }
//
//        RequestUser.Builder group(String group) {
//
//            return this;
//        }
//
//        RequestUser.Builder password(String password) {
//
//            return this;
//        }
//
//        RequestUser build() {
//            RequestUser requestUser = new RequestUser(this);
//            return requestUser;
//        }
//    }

}
