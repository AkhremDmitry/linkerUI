package com.asuscomm.reisin.rest;

import com.asuscomm.reisin.dao.Link;
import com.asuscomm.reisin.service.LinkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rest-context.xml")
public class LinkRestConsumerTest {

    @Autowired
    LinkService linkService;

    @Test
    public void listTest(){
        List<Link> links = linkService.list();
        System.out.println("GroupRestConsumer_list_Test: " + links);
    }

//    @Test
//    public void b_updateTest(){
//        Link link = linkService.get(1);
//        link.setName("ChangedGroupForTest");
//        linkService.update(link);
//        System.out.println("LinkRestConsumer_Update_Test: " + linkService.get(link.getId()));
//    }

}