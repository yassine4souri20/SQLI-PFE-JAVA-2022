package org.sqli.authentification.service.impl;

import org.springframework.stereotype.Service;
import org.sqli.authentification.dao.GroupDao;
import org.sqli.authentification.entitie.Group;
import org.sqli.authentification.service.GroupService;

@Service
public class GroupServiceImpl  implements GroupService {


    GroupDao groupDao;
    @Override
    public Group findByName(String groupName) {


        return null;
    }

}
