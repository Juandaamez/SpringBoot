package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El número de cuenta es obligatorio")
    @Size(min = 10, max = 20, message = "El número de cuenta debe tener entre 10 y 20 caracteres")
    private String numeroCuenta;

    @NotBlank(message = "El tipo de cuenta es obligatorio")
    private String tipoCuenta;

    @NotNull(message = "El saldo inicial es obligatorio")
    private double saldoInicial;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "El número de cuenta es obligatorio") @Size(min = 10, max = 20, message = "El número de cuenta debe tener entre 10 y 20 caracteres") String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(@NotBlank(message = "El número de cuenta es obligatorio") @Size(min = 10, max = 20, message = "El número de cuenta debe tener entre 10 y 20 caracteres") String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public @NotBlank(message = "El tipo de cuenta es obligatorio") String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(@NotBlank(message = "El tipo de cuenta es obligatorio") String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    @NotNull(message = "El saldo inicial es obligatorio")
    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(@NotNull(message = "El saldo inicial es obligatorio") double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public @NotBlank(message = "El estado es obligatorio") String getEstado() {
        return estado;
    }

    public void setEstado(@NotBlank(message = "El estado es obligatorio") String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
