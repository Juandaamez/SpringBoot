package com.example.demo.service;

import com.example.demo.dto.ReporteDTO;
import com.example.demo.model.Cuenta;
import com.example.demo.model.Movimiento;
import com.example.demo.repository.CuentaRepository;
import com.example.demo.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {

    private static final double LIMITE_DIARIO_RETIRO = 1000.00;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    public Optional<Cuenta> findById(Long id) {
        return cuentaRepository.findById(id);
    }

    public Cuenta save(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Transactional
    public Movimiento realizarMovimiento(Long cuentaId, Movimiento movimiento) {
        Optional<Cuenta> cuentaOpt = cuentaRepository.findById(cuentaId);
        if (cuentaOpt.isEmpty()) {
            throw new RuntimeException("Cuenta no encontrada");
        }

        Cuenta cuenta = cuentaOpt.get();
        double nuevoSaldo = cuenta.getSaldoInicial() + movimiento.getValor();

        if (movimiento.getValor() < 0 && nuevoSaldo < 0) {
            throw new RuntimeException("Saldo no disponible");
        }

        if (movimiento.getValor() < 0 && Math.abs(movimiento.getValor()) > LIMITE_DIARIO_RETIRO) {
            throw new RuntimeException("Cupo diario excedido");
        }

        cuenta.setSaldoInicial(nuevoSaldo);
        movimiento.setSaldo(nuevoSaldo);
        movimiento.setCuenta(cuenta);

        cuentaRepository.save(cuenta);
        return movimientoRepository.save(movimiento);
    }

    public ReporteDTO generarReporte(Long clienteId, Date fechaInicio, Date fechaFin) {
        List<Movimiento> movimientos = movimientoRepository.findByCuentaClienteIdAndFechaBetween(clienteId, fechaInicio, fechaFin);
        double totalCreditos = movimientos.stream()
                .filter(m -> m.getValor() > 0)
                .mapToDouble(Movimiento::getValor)
                .sum();
        double totalDebitos = movimientos.stream()
                .filter(m -> m.getValor() < 0)
                .mapToDouble(Movimiento::getValor)
                .sum();

        return new ReporteDTO(movimientos, totalCreditos, Math.abs(totalDebitos));
    }
}
