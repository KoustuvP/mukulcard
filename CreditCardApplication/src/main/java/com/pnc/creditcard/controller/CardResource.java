package com.pnc.creditcard.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pnc.creditcard.domain.User;
import com.pnc.creditcard.service.CardService;

@RestController
public class CardResource {

	@Autowired
	CardService cardService;
	
	
	
	@PostMapping(value="/credit-cards")
	public String saveCard(@Valid @RequestBody User user) {
		//System.out.println(user);
		return cardService.saveCard(user);	
	}
	
	@GetMapping(value="/credit-cards/{id}")
	public Optional<User> getCards(@PathVariable long id){
		//System.out.println(id);
		return cardService.getUser(id);
	}
}
