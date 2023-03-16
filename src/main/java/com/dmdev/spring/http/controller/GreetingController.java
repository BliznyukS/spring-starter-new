package com.dmdev.spring.http.controller;

import com.dmdev.spring.database.repository.CompanyRepository;
import com.dmdev.spring.dto.UserReadDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api/v1")
@SessionAttributes({"user"})
public class GreetingController {


    @GetMapping("/hello")
    public ModelAndView hello(ModelAndView modelAndView, HttpServletRequest request) {

        modelAndView.setViewName("greeting/hello");

        modelAndView.addObject("user", new UserReadDto(1L, "Ivan"));
        return modelAndView;
    }


    @GetMapping("/bye")
    public ModelAndView bye(@SessionAttribute("user") UserReadDto user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("greeting/bye");

        return modelAndView;
    }


//    @GetMapping("/hello/{id}")
//    public ModelAndView hello2(ModelAndView modelAndView, HttpServletRequest request,
//                              @RequestParam Integer age,
//                              @RequestHeader String accept,
//                              @CookieValue("JSESSIONID") String jsessionid,
//                              @PathVariable("id") Integer id) {
//        String ageParamValue = request.getParameter("age");
//        String acceptParamValue = request.getHeader("accept");
//        Cookie[] cookies = request.getCookies();
//
//        modelAndView.setViewName("greeting/hello");
//
//        return modelAndView;
//    }


}
