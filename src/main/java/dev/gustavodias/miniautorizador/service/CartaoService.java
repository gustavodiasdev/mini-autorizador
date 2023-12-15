package dev.gustavodias.miniautorizador.service;

import dev.gustavodias.miniautorizador.dto.CartaoResponse;
import dev.gustavodias.miniautorizador.exception.CartaoJaExistenteException;
import dev.gustavodias.miniautorizador.exception.CartaoNaoExistenteException;
import dev.gustavodias.miniautorizador.exception.SaldoInsuficienteException;
import dev.gustavodias.miniautorizador.exception.SenhaInvalidaException;
import dev.gustavodias.miniautorizador.model.Cartao;
import dev.gustavodias.miniautorizador.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Transactional
public class CartaoService {
    private final CartaoRepository cartaoRepository;

    @Autowired
    public CartaoService(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    public CartaoResponse create(String numeroCartao, String senha) {
        return (CartaoResponse) cartaoRepository.findById(numeroCartao)
                .map(cartao -> {
                    throw new CartaoJaExistenteException(numeroCartao);
                })
                .orElseGet(() -> {
                    Cartao createdCartao = createAndSaveCartao(numeroCartao, senha);
                    CartaoResponse dto = convertToDTO(createdCartao);
                    dto.setNew(true);
                    return dto;
                });
    }


    public CartaoResponse getSaldo(String numeroCartao) {
        return cartaoRepository.findById(numeroCartao)
                .map(this::convertToDTO)
                .orElseThrow(() -> new CartaoNaoExistenteException(numeroCartao));
    }

    public void transation(String numeroCartao, String senha, BigDecimal valor) {
        Cartao cartaoFound = cartaoRepository.findById(numeroCartao)
                .orElseThrow(() -> new CartaoNaoExistenteException(numeroCartao));

        validarSenha(cartaoFound, senha);
        validarSaldoECalcular(cartaoFound, valor);
    }

    private void validarSenha(Cartao cartao, String senha) {
        if (!cartao.getSenha().equals(senha))
            throw new SenhaInvalidaException();
    }

    private void validarSaldoECalcular(Cartao cartao, BigDecimal valor) {
        if (cartao.getSaldo().compareTo(valor) < 0)
            throw new SaldoInsuficienteException();

        cartao.setSaldo(cartao.getSaldo().subtract(valor));
    }



    private Cartao createAndSaveCartao(String numeroCartao, String senha) {
        Cartao cartao = new Cartao(numeroCartao, senha);
        cartaoRepository.save(cartao);
        return cartao;
    }

    private CartaoResponse convertToDTO(Cartao cartao) {
        return CartaoResponse.builder()
                .numeroCartao(cartao.getNumeroCartao())
                .saldo(cartao.getSaldo())
                .build();
    }




}
