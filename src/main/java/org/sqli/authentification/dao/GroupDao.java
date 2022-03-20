package org.sqli.authentification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sqli.authentification.entitie.Group;

import java.util.Optional;

public interface GroupDao extends JpaRepository<Group,Long> {
    Group findByName(String groupName);
}