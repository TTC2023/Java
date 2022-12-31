package com.tylercorrell.burgertracker1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tylercorrell.burgertracker1.models.Burger;
import com.tylercorrell.burgertracker1.repositories.BurgerRepository;

@Service
	public class BurgerService {
	@Autowired
	private BurgerRepository burgerRepository;
	    
	    public BurgerService(BurgerRepository burgerRepository) {
	        this.burgerRepository = burgerRepository;
	    }
	    // returns all the books
	    public List<Burger> allBurgers() {
	        return burgerRepository.findAll();
	    }
	    // creates a book
	    public Burger createBurger(Burger b) {
	        return burgerRepository.save(b);
	    }
	    // retrieves a book
	    public Burger updateBurger(Burger b) {
	        return burgerRepository.save(b);
	    }
	    
	    public Burger findBurger(Long id) {
	        Optional<Burger> optionalBurger = burgerRepository.findById(id);
	        if(optionalBurger.isPresent()) {
	            return optionalBurger.get();
	        } else {
	            return null;
	        }
	    }
	}

