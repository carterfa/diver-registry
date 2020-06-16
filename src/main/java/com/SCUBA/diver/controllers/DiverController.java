package com.SCUBA.diver.controllers;

import java.util.ArrayList;
import java.util.List;

import com.SCUBA.diver.models.Diver;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/divers")
public class DiverController {
    @GetMapping
    public List<Diver> list(){
        List<Diver> divers = new ArrayList<>();
        return divers;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Diver diver){}

    @GetMapping("/{id}")
    public Diver get(@PathVariable("id") long id){
        return new Diver();
    }
}
