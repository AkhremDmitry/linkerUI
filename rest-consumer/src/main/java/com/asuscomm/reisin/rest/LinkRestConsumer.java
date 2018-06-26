package com.asuscomm.reisin.rest;

import com.asuscomm.reisin.dao.Link;
import com.asuscomm.reisin.service.LinkService;

import java.util.List;

public class LinkRestConsumer implements LinkService {
    @Override
    public int save(Link link) {
        return 0;
    }

    @Override
    public Link get(int id) {
        return null;
    }

    @Override
    public List<Link> list() {
        return null;
    }

    @Override
    public void update(int id, Link link) {

    }

    @Override
    public void delete(int id) {

    }
}
