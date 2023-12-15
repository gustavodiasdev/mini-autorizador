package dev.gustavodias.miniautorizador.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CartaoResponse {

    private String numeroCartao;
    private BigDecimal saldo;

    @JsonIgnore
    private boolean isNew;
}
