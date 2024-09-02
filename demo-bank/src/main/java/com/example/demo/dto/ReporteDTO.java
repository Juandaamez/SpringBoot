package com.example.demo.dto;
import com.example.demo.model.Movimiento;

import java.util.List;

public class ReporteDTO {
    private List<Movimiento> movimientos;
    private double totalCreditos;
    private double totalDebitos;

    public ReporteDTO(List<Movimiento> movimientos, double totalCreditos, double totalDebitos) {
        this.movimientos = movimientos;
        this.totalCreditos = totalCreditos;
        this.totalDebitos = totalDebitos;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public double getTotalCreditos() {
        return totalCreditos;
    }

    public double getTotalDebitos() {
        return totalDebitos;
    }
}

