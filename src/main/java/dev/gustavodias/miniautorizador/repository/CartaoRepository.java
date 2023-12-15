package dev.gustavodias.miniautorizador.repository;

import dev.gustavodias.miniautorizador.model.Cartao;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface CartaoRepository extends JpaRepository<Cartao, String> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Cartao> findById(String id);
}
