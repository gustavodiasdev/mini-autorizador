package dev.gustavodias.miniautorizador.exception;

public class CartaoJaExistenteException extends RuntimeException {
    public CartaoJaExistenteException(String numeroCartao) {
        super("Cartão já existe: " + numeroCartao);
    }
}
