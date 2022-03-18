package org.sqli.authentification.service;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.sqli.authentification.dao.UserDao;
import org.sqli.authentification.entitie.User;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Repository
public  interface UserService extends JpaRepository<User, Integer> {

    Optional<User> findByLogin(String login);
    Optional<User> findUserByPassword(String password);
}
