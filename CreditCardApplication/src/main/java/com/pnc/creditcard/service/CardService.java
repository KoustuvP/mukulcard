package com.pnc.creditcard.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnc.creditcard.domain.CreditCard;
import com.pnc.creditcard.domain.User;
import com.pnc.creditcard.repository.CardRepository;
import com.pnc.creditcard.repository.UserRepository;

@Service
public class CardService {

	@Autowired
	CardRepository cardRepository;
	
	@Autowired
	UserRepository userRepository;

	public String saveCard(User user) {
		Optional<User> returnedUser=getUser(user.getUserId());
        
		if(!returnedUser.isPresent()) {
			saveUser(user);
		}
			
		String cardNo=getRandom();
		CreditCard card =new CreditCard(cardNo,user);
		CreditCard savedCard= cardRepository.save(card);
		return savedCard.getCardNo();
	}
	private String getRandom() {
		StringBuilder sb= new StringBuilder();
		sb.append("4250");
		for(int i=0;i<12;i++) {
			sb.append(Math.round(Math.random()*9));
		}
		return String.valueOf(sb);
	}
	
	
	public User saveUser(User user){
		return userRepository.save(user);
	}
	
	public Optional<User> getUser(long id){
			Optional<User> returnedUser=userRepository.findById(id);
			return returnedUser;
	}
}
