package com.example.prueba_tecnica.service;

import com.example.prueba_tecnica.DTO.PalindromeResponse;
import org.springframework.stereotype.Service;

@Service
public class PalindromeService {

    public PalindromeResponse processPalindrome(String input) {
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean isPalindrome = cleanedInput.equals(new StringBuilder(cleanedInput).reverse().toString());

        int lengthCadena = input.length();
        int lengthCaracteresEspeciales = input.length() - cleanedInput.length();
        int isPalindromo = isPalindrome ? 1 : 0;

        return new PalindromeResponse(lengthCadena, isPalindromo, lengthCaracteresEspeciales);
    }
}

