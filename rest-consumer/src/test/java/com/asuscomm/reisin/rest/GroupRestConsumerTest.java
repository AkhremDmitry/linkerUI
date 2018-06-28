package com.asuscomm.reisin.rest;

import com.asuscomm.reisin.dao.Group;
import com.asuscomm.reisin.service.GroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rest-context.xml")
public class GroupRestConsumerTest {

    @Autowired
    GroupService groupService;

    private static final String GROUP_NAME = "ExampleForTests";

    @Test
    public void getTest(){
        Group group = groupService.get(6);
        System.out.println("GroupRestConsumer_get_Test: " + group);
    }

    @Test
    public void listTest(){
        List<Group> groups = groupService.list();
        System.out.println("GroupRestConsumer_list_Test: " + groups);
    }

    @Test
    public void saveTest(){
        Group group = new Group(GROUP_NAME);
        groupService.save(group);
        System.out.println("GroupRestConsumer_save_Test: " + groupService.get(getIdByName(GROUP_NAME)));
    }

    @Test
    public void updateTest(){
        Group group = groupService.get(getIdByName(GROUP_NAME));
        group.setName("ChangedGroupForTest");
        groupService.update(group.getId(), group);
        System.out.println("GroupRestConsumer_Update_Test: " + groupService.get(group.getId()));
    }

    @Test
    public void deleteTest(){
        int groupId;
        if ((groupId = getIdByName(GROUP_NAME)) != 0){
            groupService.delete(groupId);
        }
        if ((groupId = getIdByName("ChangedGroupForTest")) != 0){
            groupService.delete(groupId);
        }

        System.out.println("GroupRestConsumer_Delete_Test: " + groupService.list());
    }

    private int getIdByName(String nameGroup){
        List<Group> groups = groupService.list();
        for (Group curGroup : groups){
            if (curGroup.getName().equalsIgnoreCase(nameGroup)){
                return curGroup.getId();
            }
        }
        return 0;
    }

}
