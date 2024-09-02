package com.example.demo.controller;

import com.example.demo.model.Cuenta;
import com.example.demo.service.CuentaService;
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
public class CuentaControllerTests {

    private MockMvc mockMvc;

    @Mock
    private CuentaService cuentaService;

    @InjectMocks
    private CuentaController cuentaController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(cuentaController).build();
    }

    @Test
    void shouldReturnAllCuentas() throws Exception {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(1L);
        cuenta.setNumeroCuenta("123456");
        List<Cuenta> allCuentas = Arrays.asList(cuenta);

        given(cuentaService.findAll()).willReturn(allCuentas);

        mockMvc.perform(get("/cuentas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].numeroCuenta").value("123456"));
    }

    @Test
    void shouldCreateCuenta() throws Exception {
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("789012");
        String jsonCuenta = "{\"numeroCuenta\":\"789012\"}";

        given(cuentaService.save(any(Cuenta.class))).willReturn(cuenta);

        mockMvc.perform(post("/cuentas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonCuenta))
                .andExpect(status().isCreated())
                .andExpect(content().json(jsonCuenta));
    }
}
