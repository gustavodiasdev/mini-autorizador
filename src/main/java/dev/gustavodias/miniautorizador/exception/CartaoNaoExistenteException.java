package dev.gustavodias.miniautorizador.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CartaoNaoExistenteException extends RuntimeException {
    public CartaoNaoExistenteException(String numeroCartao) {
        super("Cartão não existe: " + numeroCartao);
    }
}
