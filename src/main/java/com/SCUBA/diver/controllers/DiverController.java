package com.SCUBA.diver.controllers;

import java.util.List;
import java.util.Optional;

import com.SCUBA.diver.models.Diver;
import com.SCUBA.diver.repositories.DiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/api/v1/divers")
public class DiverController {
    @Autowired
    private DiverRepository diverRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<Diver> list(){
        return diverRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Diver create(@RequestBody Diver diver){

        String encrytedPassword = this.passwordEncoder.encode(diver.getPassword());
        diver.setPassword(encrytedPassword);

        diverRepository.save(diver);

        return diverRepository.getOne(diver.getId());
    }

    @GetMapping("/{id}")
    public Diver get(@PathVariable("id") long id){
        return diverRepository.getOne(id);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public boolean login(@RequestBody Diver diver){

        Optional<Diver> dbSearch = diverRepository.findById(diver.getId());

        if (dbSearch.isPresent()){
            Diver dbDiver = dbSearch.get();
            boolean result = passwordEncoder.matches(diver.getPassword(), dbDiver.getPassword());

            return result;

        }else{
            return false;
        }


    }

}
