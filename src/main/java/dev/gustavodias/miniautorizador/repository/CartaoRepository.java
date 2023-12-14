package dev.gustavodias.miniautorizador.repository;

import dev.gustavodias.miniautorizador.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, String> {
}
