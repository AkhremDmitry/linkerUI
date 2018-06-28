package com.asuscomm.reisin.rest;

import com.asuscomm.reisin.dao.Link;
import com.asuscomm.reisin.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LinkRestConsumer implements LinkService {

    private String url = "http://reisin.asuscomm.com:1180/linker/link";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public int save(Link link) {
        int linkId = restTemplate.postForObject(url, link, Integer.class);
        return linkId;
    }

    @Override
    public Link get(int id) {
        ResponseEntity<Link> responseEntity =
                restTemplate.getForEntity(url + "/" + id, Link.class);
        Link link = responseEntity.getBody();
        return link;
    }

    @Override
    public List<Link> list() {
        List<Link> links =
                restTemplate.exchange(url + "s", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Link>>() {
                        }).getBody();
        return links;
    }

    @Override
    public void update(Link link) {
        restTemplate.put(url, link);
    }

    @Override
    public void delete(int id) {
        restTemplate.delete(url + "/" + id);
    }
}
