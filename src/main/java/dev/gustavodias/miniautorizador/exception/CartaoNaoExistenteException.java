package dev.gustavodias.miniautorizador.exception;

public class CartaoNaoExistenteException extends RuntimeException {
    public CartaoNaoExistenteException(String numeroCartao) {
        super("Cartão não existe: " + numeroCartao);
    }
}
