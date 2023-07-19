package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/palabras")
public class PalabraController {

    private final PalabraRepository palabraRepository;

    @Autowired
    public PalabraController(PalabraRepository palabraRepository) {
        this.palabraRepository = palabraRepository;
    }

    @GetMapping
    public List<Palabra> obtenerPalabras() {
        return palabraRepository.findAll();
    }
}
