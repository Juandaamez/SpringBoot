package com.example.demo.service;

import com.example.demo.model.Movimiento;
import com.example.demo.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    public List<Movimiento> findAll() {
        return movimientoRepository.findAll();
    }

    public Optional<Movimiento> findById(Long id) {
        return movimientoRepository.findById(id);
    }

    public Movimiento save(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    public Movimiento update(Long id, Movimiento updatedMovimiento) {
        return movimientoRepository.findById(id)
                .map(movimiento -> {
                    movimiento.setFecha(updatedMovimiento.getFecha());
                    movimiento.setTipoMovimiento(updatedMovimiento.getTipoMovimiento());
                    movimiento.setValor(updatedMovimiento.getValor());
                    movimiento.setSaldo(updatedMovimiento.getSaldo());
                    return movimientoRepository.save(movimiento);
                })
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
    }

    public void deleteById(Long id) {
        movimientoRepository.deleteById(id);
    }
}
