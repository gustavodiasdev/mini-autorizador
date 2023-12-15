package dev.gustavodias.miniautorizador.controller;

import dev.gustavodias.miniautorizador.dto.TransacaoRequest;
import dev.gustavodias.miniautorizador.dto.TransacaoResponse;
import dev.gustavodias.miniautorizador.service.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;


    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<TransacaoResponse> createTransacao(@RequestBody TransacaoRequest transacaoRequest) {
        transacaoService.create(transacaoRequest.getNumeroCartao(), transacaoRequest.getSenha(), transacaoRequest.getValor());
        return ResponseEntity.ok().build();
    }


}
