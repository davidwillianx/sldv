package br.com.sldv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dashboard")
public class DashController {

    @RequestMapping(method = RequestMethod.GET)
    public String dash(){
        return "dashboard";
    }

}
