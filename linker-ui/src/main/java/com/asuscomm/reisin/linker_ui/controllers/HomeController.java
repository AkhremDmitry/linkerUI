package com.asuscomm.reisin.linker_ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * Redirect to cars.
     *
     * @return template name
     */
    @GetMapping(value = "/*")
    public final String defaultPageRedirect() {
        return "redirect:/groups";
    }

}
