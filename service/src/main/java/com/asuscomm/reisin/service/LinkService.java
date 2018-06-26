package com.asuscomm.reisin.service;

import com.asuscomm.reisin.dao.Link;

import java.util.List;

public interface LinkService {


    int save(Link link);

    Link get(int id);

    List<Link> list();

    void update(int id, Link link);

    void delete(int id);
}
