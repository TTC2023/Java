package com.tylercorrell.burgertracker1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tylercorrell.burgertracker1.models.Burger;
import com.tylercorrell.burgertracker1.services.BurgerService;

@Controller
public class BurgerController {
    // other methods removed for brevity
    
	@Autowired
	private BurgerService burgerServ;
	
    @GetMapping("/")
    public String index(@ModelAttribute("burger") Burger burger,Model model) {
    	 List<Burger> burgers = burgerServ.allBurgers();
         model.addAttribute("burgers", burgers);
        return "index.jsp";
    }
    
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result,Model model) {
    	if(result.hasErrors()) {
    		List<Burger> burgers = burgerServ.allBurgers();
            model.addAttribute("burgers", burgers);
    		return "index.jsp";
    	} else {
    		burgerServ.createBurger(burger);
    		return "redirect:/";
    	}
    }
    
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("burger", burgerServ.findBurger(id));
    	return "edit.jsp";
    }
    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
    	if(result.hasErrors()) {
    		model.addAttribute("burger", burger);
    		return "edit.jsp";
    	}
    	burgerServ.updateBurger(burger);
    	return "redirect:/";
    }
    
}