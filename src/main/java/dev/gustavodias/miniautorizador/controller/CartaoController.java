package dev.gustavodias.miniautorizador.controller;

import dev.gustavodias.miniautorizador.dto.CartaoRequest;
import dev.gustavodias.miniautorizador.dto.CartaoResponse;
import dev.gustavodias.miniautorizador.service.CartaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    private final CartaoService cartaoService;

    public CartaoController(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    @PostMapping
    public ResponseEntity<CartaoResponse> createCartao(@RequestBody CartaoRequest cartaoRequest) {
        CartaoResponse cartaoDTO = cartaoService.create(cartaoRequest.getNumeroCartao(), cartaoRequest.getSenha());
        return new ResponseEntity<>(cartaoDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{numeroCartao}")
    public ResponseEntity<CartaoResponse> getCartao(@PathVariable String numeroCartao) {
        CartaoResponse cartaoDTO = cartaoService.getSaldo(numeroCartao);
        return new ResponseEntity<>(cartaoDTO, HttpStatus.OK);
    }
}
