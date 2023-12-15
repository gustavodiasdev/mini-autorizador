package dev.gustavodias.miniautorizador.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransacaoRequest {

    private String numeroCartao;
    private String senha;
    private BigDecimal valor;
}
