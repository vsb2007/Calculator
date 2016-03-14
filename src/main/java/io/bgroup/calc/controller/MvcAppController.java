package io.bgroup.calc.controller;

import io.bgroup.calc.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

@Controller
@EnableWebMvc
public class MvcAppController {

    @RequestMapping(value = {"/index", "/"})
    public ModelAndView AppList(UsernamePasswordAuthenticationToken principal, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }
}