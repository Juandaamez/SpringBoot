package com.example.demo.repository;

import com.example.demo.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByCuentaClienteIdAndFechaBetween(Long clienteId, Date fechaInicio, Date fechaFin);
}
