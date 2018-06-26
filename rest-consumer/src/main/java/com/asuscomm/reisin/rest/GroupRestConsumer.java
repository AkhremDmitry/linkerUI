package com.asuscomm.reisin.rest;

import com.asuscomm.reisin.dao.Group;
import com.asuscomm.reisin.service.GroupService;

import java.util.List;

public class GroupRestConsumer implements GroupService {
    @Override
    public int save(Group group) {
        return 0;
    }

    @Override
    public Group get(int id) {
        return null;
    }

    @Override
    public List<Group> list() {
        return null;
    }

    @Override
    public void update(int id, Group group) {

    }

    @Override
    public void delete(int id) {

    }
}
