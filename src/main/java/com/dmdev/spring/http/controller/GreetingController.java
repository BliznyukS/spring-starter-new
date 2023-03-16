package com.dmdev.spring.http.controller;

import com.dmdev.spring.database.entity.Role;
import com.dmdev.spring.database.repository.CompanyRepository;
import com.dmdev.spring.dto.UserReadDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api/v1")
@SessionAttributes({"user"})
public class GreetingController {

    @ModelAttribute("roles")
    public List<Role> roles(){
        return Arrays.asList(Role.values());
    }


    @GetMapping("/hello")
    public String hello(Model model, HttpServletRequest request,
                        @ModelAttribute("userReadDto") UserReadDto userReadDto) {

        model.addAttribute("user", new UserReadDto(1L, "Ivan"));
        return "greeting/hello";
    }

//    @GetMapping("/hello")
//    public ModelAndView hello(ModelAndView modelAndView, HttpServletRequest request) {
//
//        modelAndView.setViewName("greeting/hello");
//
//        modelAndView.addObject("user", new UserReadDto(1L, "Ivan"));
//        return modelAndView;
//    }


    @GetMapping("/bye")
    public String bye(@SessionAttribute("user") UserReadDto user, Model model) {

        return "greeting/bye";
    }

//    @GetMapping("/bye")
//    public ModelAndView bye(@SessionAttribute("user") UserReadDto user) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("greeting/bye");
//
//        return modelAndView;
//    }

    @GetMapping("/hello/{id}")
    public ModelAndView hello2(ModelAndView modelAndView, HttpServletRequest request,
                              @RequestParam Integer age,
                              @RequestHeader String accept,
                              @CookieValue("JSESSIONID") String jsessionid,
                              @PathVariable("id") Integer id) {
        String ageParamValue = request.getParameter("age");
        String acceptParamValue = request.getHeader("accept");
        Cookie[] cookies = request.getCookies();

        modelAndView.setViewName("greeting/hello");

        return modelAndView;
    }


}
