package com.pnc.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pnc.creditcard.domain.CreditCard;

@Repository
public interface CardRepository extends JpaRepository<CreditCard, String>{

}
