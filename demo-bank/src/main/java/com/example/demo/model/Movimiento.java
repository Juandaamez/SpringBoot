package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La fecha es obligatoria")
    private Date fecha;

    @NotNull(message = "El tipo de movimiento es obligatorio")
    private String tipoMovimiento;

    @NotNull(message = "El valor es obligatorio")
    private double valor;

    @NotNull(message = "El saldo es obligatorio")
    private double saldo;

    @ManyToOne
    @JoinColumn(name = "cuenta_id", nullable = false)
    private Cuenta cuenta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "La fecha es obligatoria") Date getFecha() {
        return fecha;
    }

    public void setFecha(@NotNull(message = "La fecha es obligatoria") Date fecha) {
        this.fecha = fecha;
    }

    public @NotNull(message = "El tipo de movimiento es obligatorio") String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(@NotNull(message = "El tipo de movimiento es obligatorio") String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    @NotNull(message = "El valor es obligatorio")
    public double getValor() {
        return valor;
    }

    public void setValor(@NotNull(message = "El valor es obligatorio") double valor) {
        this.valor = valor;
    }

    @NotNull(message = "El saldo es obligatorio")
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(@NotNull(message = "El saldo es obligatorio") double saldo) {
        this.saldo = saldo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
