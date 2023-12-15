package dev.gustavodias.miniautorizador.service;

import dev.gustavodias.miniautorizador.dto.CartaoResponse;
import dev.gustavodias.miniautorizador.model.Cartao;
import dev.gustavodias.miniautorizador.repository.CartaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CartaoServiceTest {

    @Mock
    private CartaoRepository cartaoRepository;

    @InjectMocks
    private CartaoService cartaoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() {
        String numeroCartao = "123456";
        String senha = "1234";
        Cartao cartao = new Cartao(numeroCartao, senha);
        when(cartaoRepository.findById(numeroCartao)).thenReturn(Optional.empty());
        when(cartaoRepository.save(any(Cartao.class))).thenReturn(cartao);

        CartaoResponse response = cartaoService.create(numeroCartao, senha);

        assertEquals(numeroCartao, response.getNumeroCartao());
        verify(cartaoRepository, times(1)).findById(numeroCartao);
        verify(cartaoRepository, times(1)).save(any(Cartao.class));
    }

    @Test
    void getSaldo() {
        String numeroCartao = "123456";
        Cartao cartao = new Cartao(numeroCartao, "1234");
        cartao.setSaldo(BigDecimal.valueOf(1000));
        when(cartaoRepository.findById(numeroCartao)).thenReturn(Optional.of(cartao));

        CartaoResponse response = cartaoService.getSaldo(numeroCartao);

        assertEquals(numeroCartao, response.getNumeroCartao());
        assertEquals(BigDecimal.valueOf(1000), response.getSaldo());
        verify(cartaoRepository, times(1)).findById(numeroCartao);
    }
}