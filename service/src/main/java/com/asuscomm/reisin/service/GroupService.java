package com.asuscomm.reisin.service;

import com.asuscomm.reisin.dao.Group;
import com.asuscomm.reisin.dto.GroupDto;

import java.util.List;

public interface GroupService {
    int save(Group group);

    Group get(int id);

    List<Group> list();

    List<GroupDto> listDto();

    void update(Group group);

    void delete(int id);
}
