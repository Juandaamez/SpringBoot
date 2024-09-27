package com.example.prueba_tecnica.DTO;

public class PalindromeResponse {
    private int lengthCadena;
    private int isPalindromo;
    private int lengthCaracteresEspeciales;

    // Constructor
    public PalindromeResponse(int lengthCadena, int isPalindromo, int lengthCaracteresEspeciales) {
        this.lengthCadena = lengthCadena;
        this.isPalindromo = isPalindromo;
        this.lengthCaracteresEspeciales = lengthCaracteresEspeciales;
    }

    // Getters y Setters
    public int getLengthCadena() {
        return lengthCadena;
    }

    public void setLengthCadena(int lengthCadena) {
        this.lengthCadena = lengthCadena;
    }

    public int getIsPalindromo() {
        return isPalindromo;
    }

    public void setIsPalindromo(int isPalindromo) {
        this.isPalindromo = isPalindromo;
    }

    public int getLengthCaracteresEspeciales() {
        return lengthCaracteresEspeciales;
    }

    public void setLengthCaracteresEspeciales(int lengthCaracteresEspeciales) {
        this.lengthCaracteresEspeciales = lengthCaracteresEspeciales;
    }
}
