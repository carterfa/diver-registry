package com.SCUBA.diver.controllers;

import java.util.ArrayList;
import java.util.List;

import com.SCUBA.diver.models.Diver;
import com.SCUBA.diver.repositories.DiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/divers")
public class DiverController {
    @Autowired
    private DiverRepository diverRepository;

    @GetMapping
    public List<Diver> list(){
        return diverRepository.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Diver diver){
        diverRepository.save(diver);
    }

    @GetMapping("/{id}")
    public Diver get(@PathVariable("id") long id){
        return diverRepository.getOne(id);
    }
}
