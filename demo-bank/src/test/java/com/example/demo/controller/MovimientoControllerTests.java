package com.example.demo.controller;

import com.example.demo.model.Movimiento;
import com.example.demo.service.MovimientoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class MovimientoControllerTests {

    private MockMvc mockMvc;

    @Mock
    private MovimientoService movimientoService;

    @InjectMocks
    private MovimientoController movimientoController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(movimientoController).build();
    }

    @Test
    void shouldReturnAllMovimientos() throws Exception {
        Movimiento movimiento = new Movimiento();
        movimiento.setId(1L);
        movimiento.setTipoMovimiento("Depósito");
        List<Movimiento> allMovimientos = Arrays.asList(movimiento);

        given(movimientoService.findAll()).willReturn(allMovimientos);

        mockMvc.perform(get("/movimientos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tipo").value("Depósito"));
    }

    @Test
    void shouldCreateMovimiento() throws Exception {
        Movimiento movimiento = new Movimiento();
        movimiento.setTipoMovimiento("Retiro");
        String jsonMovimiento = "{\"tipo\":\"Retiro\"}";

        given(movimientoService.save(any(Movimiento.class))).willReturn(movimiento);

        mockMvc.perform(post("/movimientos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonMovimiento))
                .andExpect(status().isCreated())
                .andExpect(content().json(jsonMovimiento));
    }
}
