package com.example.backend_spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ResponseEntity<ErrorDetalles> manejarProductoNoEncontradoException(ProductoNoEncontradoException ex) {
        ErrorDetalles error = new ErrorDetalles(LocalDateTime.now(), ex.getMessage(), "Recurso no encontrado");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Puedes agregar más manejadores de excepciones aquí

    // Clase interna para detalles del error
    public static class ErrorDetalles {
        private LocalDateTime timestamp;
        private String mensaje;
        private String detalles;

        public ErrorDetalles(LocalDateTime timestamp, String mensaje, String detalles) {
            this.timestamp = timestamp;
            this.mensaje = mensaje;
            this.detalles = detalles;
        }

        // Getters y Setters
        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getDetalles() {
            return detalles;
        }

        public void setDetalles(String detalles) {
            this.detalles = detalles;
        }
    }
}
