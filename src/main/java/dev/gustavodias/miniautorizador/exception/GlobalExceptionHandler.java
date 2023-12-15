package dev.gustavodias.miniautorizador.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CartaoNaoExistenteException.class)
    public ResponseEntity<String> handleCartaoNaoExistenteException(CartaoNaoExistenteException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SenhaInvalidaException.class)
    public ResponseEntity<String> handleSenhaInvalidaException(SenhaInvalidaException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(SaldoInsuficienteException.class)
    public ResponseEntity<String> handleSaldoInsuficienteException(SaldoInsuficienteException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.PAYMENT_REQUIRED);
    }

    @ExceptionHandler(CartaoJaExistenteException.class)
    public ResponseEntity<String> handleCartaoJaExistenteException(CartaoJaExistenteException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}