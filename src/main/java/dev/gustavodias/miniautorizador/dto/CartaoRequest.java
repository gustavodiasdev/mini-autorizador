package dev.gustavodias.miniautorizador.dto;

import lombok.Data;

@Data
public class CartaoRequest {

    private String numeroCartao;
    private String senha;
}
