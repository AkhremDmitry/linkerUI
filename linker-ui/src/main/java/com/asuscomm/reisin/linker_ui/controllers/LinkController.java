package com.asuscomm.reisin.linker_ui.controllers;

import com.asuscomm.reisin.dao.Group;
import com.asuscomm.reisin.dao.Link;
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

@Controller
public class LinkController {

    @Autowired
    GroupService groupService;

    @Autowired
    LinkService linkService;

    @GetMapping(value = "/editLink/{id}")
    public final String getUpdateCrew(@PathVariable final int id,
                                      final Model model) {

        boolean isEdit = true;
        Collection<Group> groups = groupService.list();
        Link link = linkService.get(id);
        model.addAttribute("isEdit", isEdit);
        model.addAttribute("groups", groups);
        model.addAttribute("link", link);
        return "link";
    }

    @PostMapping(value = "/editLink/{id}")
    public final String updateLink(final Link link) {
//        if (result.hasErrors()) {
//            Collection<Group> groups = groupService.list();
//            model.addAttribute("isEdit", true);
//            model.addAttribute("groups", groups);
//            model.addAttribute("link", link);
//            return "link";
//        } else {
            linkService.update(link);
            return "redirect:/groups";
//        }
    }
}
