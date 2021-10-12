package com.example.baithithuchanh.controller;

import com.example.baithithuchanh.model.City;
import com.example.baithithuchanh.service.IServiceCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Optional;

@Controller
@RequestMapping("/city")
public class ControllerCity {
    @Autowired
    private IServiceCity serviceCity;

    @GetMapping("")
    public ModelAndView showListCity(){
        Iterable<City> listCity = serviceCity.showAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("listCity", listCity);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView mav = new ModelAndView("/create");
        mav.addObject("newCity",new City());
        return mav;
    }
    @PostMapping("create")
    public String create(@ModelAttribute("city") City city, RedirectAttributes redirect){
        serviceCity.save(city);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new City());
        redirect.addFlashAttribute("massage","Create new customer successfully!");
        return "redirect:/city";
    }

    @GetMapping("{id}/edit")
    public ModelAndView showFormCity(@PathVariable("id") Optional<City> city){
        ModelAndView mav = new ModelAndView("/edit");
        mav.addObject("editCity",city.get());
        return mav;
    }
    @PostMapping("{id}/edit")
    public String UpdateCity(@ModelAttribute City city, RedirectAttributes redirect){
        serviceCity.save(city);
        redirect.addFlashAttribute("message","Update customer successfully!");
        return "redirect:/city";
    }
    @GetMapping("{id}/delete")
    public String deleteCity(@ModelAttribute("id") City city,RedirectAttributes redirect){
        serviceCity.delete(city.getId());
        redirect.addFlashAttribute("message","Delete customer successfully!");
        return "redirect:/city";
    }
    @GetMapping("{id}/detail")
    public ModelAndView showDetailCity(@PathVariable("id") Optional<City> city){
        ModelAndView mav = new ModelAndView("/detail");
        mav.addObject("detailCity",city.get());
        return mav;
    }
}
