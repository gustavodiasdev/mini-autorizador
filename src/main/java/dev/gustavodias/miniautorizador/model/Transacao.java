package dev.gustavodias.miniautorizador.model;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {

    @ManyToOne
    private Cartao cartao;

    private BigDecimal valor;

}