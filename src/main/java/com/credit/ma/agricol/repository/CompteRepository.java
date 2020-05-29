package com.credit.ma.agricol.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.credit.ma.agricol.entity.Compte;

@Repository
public interface CompteRepository extends CrudRepository<Compte, Long> {
    
    List<Compte> findByName(String name);
    
}
