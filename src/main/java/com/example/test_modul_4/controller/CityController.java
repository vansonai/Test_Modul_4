package com.example.test_modul_4.controller;

import com.example.test_modul_4.model.City;
import com.example.test_modul_4.model.Country;
import com.example.test_modul_4.service.ICityService;
import com.example.test_modul_4.service.ICountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private ICityService iCityService;
    @Autowired
    private ICountryService iCountryService;
    @ModelAttribute("cities_")
    public Iterable<Country> classes(){
        return iCountryService.findAll();
    }
    @GetMapping("")
    private String showList(Model model){
        Iterable<City> cities = iCityService.findAll();
        model.addAttribute("cities", cities);
        return "list";
    }

    @GetMapping("create")
    private ModelAndView showCreateForm(){
        ModelAndView model = new ModelAndView("/create");
        model.addObject("cities", new City());
        return model;
    }
    @PostMapping("create")
    private ModelAndView saveCity(@ModelAttribute("student") City city){
            ModelAndView modelAndView = new ModelAndView("redirect:/city");
            modelAndView.addObject("cities", new City());
            iCityService.save(city);
            return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView formUpdateCity(@PathVariable Long id){
        Optional<City> city = iCityService.findById(id);
        if (city.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/update");
            modelAndView.addObject("cities", city.get());
            return modelAndView;
        }else {
            return new ModelAndView("/error_404");
        }
    }
    @PostMapping("/update")
    public ModelAndView updateCity(@ModelAttribute("city") City city){
        iCityService.save(city);
        ModelAndView modelAndView = new ModelAndView("redirect:/city");
        modelAndView.addObject("cities", city);
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        iCityService.remove(id);
        return "redirect:/city";
    }

    @PostMapping("search")
    public ModelAndView findName(@RequestParam String name){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("cities", iCityService.findStudentByNameContaining(name));
        return modelAndView;
    }
}
