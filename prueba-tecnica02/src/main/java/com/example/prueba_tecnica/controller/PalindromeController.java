package com.example.prueba_tecnica.controller;

import com.example.prueba_tecnica.DTO.PalindromeRequest;
import com.example.prueba_tecnica.DTO.PalindromeResponse;
import com.example.prueba_tecnica.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api")
public class PalindromeController {

    @Autowired
    private PalindromeService palindromeService;

    @PostMapping("/palindrome")
    @Operation(summary = "Procesar una cadena para evaluar si es palíndromo")
    public PalindromeResponse processPalindrome(@RequestBody PalindromeRequest request) {
        return palindromeService.processPalindrome(request.getPalindromo());
    }
}


