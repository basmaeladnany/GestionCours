package com.gestiondescours.gestiondescours.controllers;

import com.gestiondescours.gestiondescours.models.Cours;
import com.gestiondescours.gestiondescours.services.CoursService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CoursController {

    @Autowired
    CoursService coursService;


    @RequestMapping("/createCours")
    public String createCours(){
        return  "CreateCours";
    }



    @RequestMapping("/saveCours")
    public String saveCours(@Valid Cours cours , BindingResult bindingResult){
        if (bindingResult.hasErrors() ) return "CreateCours";
        coursService.saveCours(cours);
        return "CreateCours";
    }

    @RequestMapping("/coursList")
    public String coursList(ModelMap modelMap){
        List<Cours> coursController = coursService.getAllCours();
        modelMap.addAttribute("coursJsp",coursController);
        return "CoursList";
    }

    @RequestMapping("/deleteCours")
    public String deleteCours(@RequestParam("id") Long id, ModelMap modelMap){
        coursService.deleteCoursById(id);
        List<Cours> coursController = coursService.getAllCours();
        modelMap.addAttribute("coursJsp",coursController);
        return "CoursList";
    }

    @RequestMapping("/showCours")
    public String showCours(@RequestParam("id") Long id, ModelMap modelMap){
        Cours coursController = coursService.getCours(id);
        modelMap.addAttribute("coursJsp", coursController);
        return "EditCours";
    }

    @RequestMapping("/updateCours")
    public String updateCours(@ModelAttribute("cours") Cours cours) {
        coursService.saveCours(cours);
        return "CreateCours";
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/coursList";
    }



}
