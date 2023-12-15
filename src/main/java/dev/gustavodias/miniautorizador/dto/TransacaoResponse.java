package dev.gustavodias.miniautorizador.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoResponse {

    private String numeroCartao;
    private BigDecimal valor;
}
