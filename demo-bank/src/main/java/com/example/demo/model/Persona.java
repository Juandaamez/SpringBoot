package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "El género es obligatorio")
    @Pattern(regexp = "Masculino|Femenino", message = "El género debe ser Masculino o Femenino")
    private String genero;

    @NotBlank(message = "La edad es obligatoria")
    private int edad;

    @NotBlank(message = "La identificación es obligatoria")
    @Size(min = 5, max = 20, message = "La identificación debe tener entre 5 y 20 caracteres")
    private String identificacion;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(max = 100, message = "La dirección no puede exceder los 100 caracteres")
    private String direccion;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "\\d{10}", message = "El teléfono debe tener 10 dígitos")
    private String telefono;

    public Persona() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre es obligatorio") @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre es obligatorio") @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "El género es obligatorio") @Pattern(regexp = "Masculino|Femenino", message = "El género debe ser Masculino o Femenino") String getGenero() {
        return genero;
    }

    public void setGenero(@NotBlank(message = "El género es obligatorio") @Pattern(regexp = "Masculino|Femenino", message = "El género debe ser Masculino o Femenino") String genero) {
        this.genero = genero;
    }

    @NotBlank(message = "La edad es obligatoria")
    public int getEdad() {
        return edad;
    }

    public void setEdad(@NotBlank(message = "La edad es obligatoria") int edad) {
        this.edad = edad;
    }

    public @NotBlank(message = "La identificación es obligatoria") @Size(min = 5, max = 20, message = "La identificación debe tener entre 5 y 20 caracteres") String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(@NotBlank(message = "La identificación es obligatoria") @Size(min = 5, max = 20, message = "La identificación debe tener entre 5 y 20 caracteres") String identificacion) {
        this.identificacion = identificacion;
    }

    public @NotBlank(message = "La dirección es obligatoria") @Size(max = 100, message = "La dirección no puede exceder los 100 caracteres") String getDireccion() {
        return direccion;
    }

    public void setDireccion(@NotBlank(message = "La dirección es obligatoria") @Size(max = 100, message = "La dirección no puede exceder los 100 caracteres") String direccion) {
        this.direccion = direccion;
    }

    public @NotBlank(message = "El teléfono es obligatorio") @Pattern(regexp = "\\d{10}", message = "El teléfono debe tener 10 dígitos") String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotBlank(message = "El teléfono es obligatorio") @Pattern(regexp = "\\d{10}", message = "El teléfono debe tener 10 dígitos") String telefono) {
        this.telefono = telefono;
    }
}
