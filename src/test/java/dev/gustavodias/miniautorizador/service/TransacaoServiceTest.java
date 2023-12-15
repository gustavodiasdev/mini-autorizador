package dev.gustavodias.miniautorizador.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

class TransacaoServiceTest {

    @Mock
    private CartaoService cartaoService;

    @InjectMocks
    private TransacaoService transacaoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() {
        String numeroCartao = "123456";
        String senha = "1234";
        BigDecimal valor = BigDecimal.valueOf(100);

        transacaoService.create(numeroCartao, senha, valor);

        verify(cartaoService, times(1)).transation(numeroCartao, senha, valor);
    }
}