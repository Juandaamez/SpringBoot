package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Long id, Cliente updatedCliente) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNombre(updatedCliente.getNombre());
                    cliente.setGenero(updatedCliente.getGenero());
                    cliente.setEdad(updatedCliente.getEdad());
                    cliente.setIdentificacion(updatedCliente.getIdentificacion());
                    cliente.setDireccion(updatedCliente.getDireccion());
                    cliente.setTelefono(updatedCliente.getTelefono());
                    cliente.setClienteId(updatedCliente.getClienteId());
                    cliente.setContraseña(updatedCliente.getContraseña());
                    cliente.setEstado(updatedCliente.getEstado());
                    return clienteRepository.save(cliente);
                })
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
