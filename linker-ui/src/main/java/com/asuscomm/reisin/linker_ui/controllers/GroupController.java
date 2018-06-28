package com.asuscomm.reisin.linker_ui.controllers;

import com.asuscomm.reisin.dao.Group;
import com.asuscomm.reisin.service.GroupService;
import com.asuscomm.reisin.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class GroupController {

    @Autowired
    GroupService groupService;

    @Autowired
    LinkService linkService;

    @GetMapping(value = "/groups")
    public final String getGroups(final Model model) {
        Collection<Group> groups = groupService.list();
        model.addAttribute("groups", groups);
        return "groups";
    }
}
