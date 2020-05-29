package com.credit.ma.agricol.domain;


import com.credit.ma.agricol.entity.Compte;
import com.credit.ma.agricol.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Comptedomain {
    @Autowired
    private CompteRepository compteRepository;

    public List<Compte> findAll() {
        return (List<Compte>) compteRepository.findAll();
    }

    public List<Compte> findByName(String name) {
        return compteRepository.findByName(name);
    }

    public Compte save(Compte compte) {
        return compteRepository.save(compte);
    }

    public Optional<Compte> findById(Long id) {
        return compteRepository.findById(id);
    }

    public void delete(Compte compte) {
        compteRepository.delete(compte);
    }

}
