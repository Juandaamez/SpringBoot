package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Cliente extends Persona {

    @NotBlank(message = "El ID de cliente es obligatorio")
    @Size(min = 5, max = 20, message = "El ID de cliente debe tener entre 5 y 20 caracteres")
    private String clienteId;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String contraseña;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    public @NotBlank(message = "El ID de cliente es obligatorio") @Size(min = 5, max = 20, message = "El ID de cliente debe tener entre 5 y 20 caracteres") String getClienteId() {
        return clienteId;
    }

    public void setClienteId(@NotBlank(message = "El ID de cliente es obligatorio") @Size(min = 5, max = 20, message = "El ID de cliente debe tener entre 5 y 20 caracteres") String clienteId) {
        this.clienteId = clienteId;
    }

    public @NotBlank(message = "La contraseña es obligatoria") @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres") String getContraseña() {
        return contraseña;
    }

    public void setContraseña(@NotBlank(message = "La contraseña es obligatoria") @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres") String contraseña) {
        this.contraseña = contraseña;
    }

    public @NotBlank(message = "El estado es obligatorio") String getEstado() {
        return estado;
    }

    public void setEstado(@NotBlank(message = "El estado es obligatorio") String estado) {
        this.estado = estado;
    }
}
