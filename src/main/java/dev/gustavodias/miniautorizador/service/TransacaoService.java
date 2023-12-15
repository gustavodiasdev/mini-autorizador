package dev.gustavodias.miniautorizador.service;

import dev.gustavodias.miniautorizador.dto.CartaoResponse;
import dev.gustavodias.miniautorizador.exception.SaldoInsuficienteException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransacaoService {

    private final CartaoService cartaoService;

    public TransacaoService(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    public void create(String numeroCartao, String senha, BigDecimal valor) {
        cartaoService.transation(numeroCartao, senha, valor);
    }



}
