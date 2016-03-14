package io.bgroup.calc.controller;

import io.bgroup.calc.model.Calc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

@Controller
@EnableWebMvc
public class AjaxController {
    @Autowired
    private Calc calc;

    @RequestMapping(value = "/calculate")
    @ResponseBody
    public String calculate(HttpServletRequest request) {
        String responseBody = "Error";
        if (request != null) {
            responseBody = calc.getResult(request.getParameter("result"));
        }
        return responseBody;
    }
}
