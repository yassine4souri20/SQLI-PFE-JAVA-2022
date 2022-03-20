package org.sqli.authentification.service;

import org.sqli.authentification.entitie.Group;

public interface GroupService {

    Group findByName(String groupName);
}
