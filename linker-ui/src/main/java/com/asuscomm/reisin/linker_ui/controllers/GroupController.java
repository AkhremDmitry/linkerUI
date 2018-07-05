package com.asuscomm.reisin.linker_ui.controllers;

import com.asuscomm.reisin.dao.Group;
import com.asuscomm.reisin.dao.Link;
import com.asuscomm.reisin.dto.GroupDto;
import com.asuscomm.reisin.service.GroupService;
import com.asuscomm.reisin.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class GroupController {

    @Autowired
    GroupService groupService;

    @Autowired
    LinkService linkService;

    @GetMapping(value = "/groups")
    public final String getGroups(final Model model) {
        Collection<GroupDto> groups = groupService.listDto();
        Collection<Link> links = linkService.list();
        for (GroupDto curGroup : groups){
            for (Link curLink : links){
                if (curGroup.getId() == curLink.getGroupId()){
                    curGroup.getLinks().add(curLink);
                }
            }
        }

        model.addAttribute("groups", groups);
        return "groups";
    }
}
