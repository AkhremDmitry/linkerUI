package com.asuscomm.reisin.service;

import com.asuscomm.reisin.dao.Group;

import java.util.List;

public interface GroupService {
    int save(Group group);

    Group get(int id);

    List<Group> list();

    void update(int id, Group group);

    void delete(int id);
}
