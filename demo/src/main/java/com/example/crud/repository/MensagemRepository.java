package com.example.crud.repository;

import com.example.crud.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
    List<Mensagem> findByRemetenteIdAndDestinatarioId(Long remetenteId, Long destinatarioId);
    List<Mensagem> findByDestinatarioIdAndStatus(Long destinatarioId, Mensagem.Status status);
}
