package com.example.demo.controller;

import com.example.demo.dto.ReporteDTO;
import com.example.demo.model.Cuenta;
import com.example.demo.model.Movimiento;
import com.example.demo.service.CuentaService;
import com.example.demo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private DocumentService documentService;

    @GetMapping
    public ResponseEntity<List<Cuenta>> getAllCuentas() {
        List<Cuenta> cuentas = cuentaService.findAll();
        return ResponseEntity.ok(cuentas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getCuentaById(@PathVariable Long id) {
        Optional<Cuenta> cuenta = cuentaService.findById(id);
        return cuenta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cuenta> createCuenta(@RequestBody Cuenta cuenta) {
        Cuenta nuevaCuenta = cuentaService.save(cuenta);
        return ResponseEntity.ok(nuevaCuenta);
    }

    @PostMapping("/{id}/movimientos")
    public ResponseEntity<Movimiento> realizarMovimiento(@PathVariable Long id, @RequestBody Movimiento movimiento) {
        Movimiento nuevoMovimiento = cuentaService.realizarMovimiento(id, movimiento);
        return ResponseEntity.ok(nuevoMovimiento);
    }

    @GetMapping("/reportes")
    public ResponseEntity<String> generarReportePdfBase64(
            @RequestParam Long clienteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) {
        ReporteDTO reporte = cuentaService.generarReporte(clienteId, fechaInicio, fechaFin);
        String pdfBase64 = documentService.generatePdfReport(reporte);
        return ResponseEntity.ok(pdfBase64);
    }
}
