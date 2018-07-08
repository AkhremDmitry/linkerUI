package com.asuscomm.reisin.linker_ui.controllers;

import com.asuscomm.reisin.dao.Group;
import com.asuscomm.reisin.dao.Link;
import com.asuscomm.reisin.dto.GroupDto;
import com.asuscomm.reisin.service.GroupService;
import com.asuscomm.reisin.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
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

    @GetMapping(value = "/group")
    public final String getAddGroup(final Model model) {
        boolean isEdit = false;
        model.addAttribute("isEdit", isEdit);
        model.addAttribute("group", new Group());
        return "group";
    }

    @PostMapping(value = "/group")
    public final String addGroup(@Valid final Group group,
                                 final BindingResult result,
                                 final Model model) {
        if (result.hasErrors()) {
            model.addAttribute("isEdit", true);
            model.addAttribute("group", group);
            return "group";
        } else {
        groupService.save(group);
        return "redirect:/groups";
        }
    }

    @GetMapping(value = "/editGroup/{id}")
    public final String getEditGroup(@PathVariable final int id,
                                     final Model model) {
        boolean isEdit = true;
        Group group = groupService.get(id);
        model.addAttribute("isEdit", isEdit);
        model.addAttribute("group", group);
        return "group";
    }

    @PostMapping(value = "/editGroup/{id}")
    public final String editGroup(@Valid final Group group,
                                 final BindingResult result,
                                 final Model model) {
        if (result.hasErrors()) {
            model.addAttribute("isEdit", true);
            model.addAttribute("group", group);
            return "group";
        } else {
            groupService.save(group);
            return "redirect:/groups";
        }
    }

    @GetMapping(value = "/group/{id}/delete")
    public final String deleteGroup(@PathVariable final int id) {
        groupService.delete(id);
        return "redirect:/groups";
    }
}
