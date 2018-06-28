package com.asuscomm.reisin.rest;

import com.asuscomm.reisin.dao.Group;
import com.asuscomm.reisin.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GroupRestConsumer implements GroupService {

    private String url = "http://reisin.asuscomm.com:1180/linker/group";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public int save(Group group) {
                restTemplate.postForLocation(url, group);
        return 0;
    }

    @Override
    public Group get(int id) {
        ResponseEntity<Group> responseEntity =
                restTemplate.getForEntity(url + "/" + id, Group.class);
        Group group = responseEntity.getBody();
        return group;
    }

    @Override
    public List<Group> list() {
        List<Group> groups = restTemplate.exchange(url +"s", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Group>>() {}).getBody();
        return groups;
    }

    @Override
    public void update(int id, Group group) {
        restTemplate.put(url + "/" + id, group);
    }

    @Override
    public void delete(int id) {
        restTemplate.delete(url + "/" + id);
    }
}
