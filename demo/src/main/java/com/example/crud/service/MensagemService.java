package com.example.crud.service;

import com.example.crud.model.Mensagem;
import com.example.crud.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository mensagemRepository;

    public List<Mensagem> listarMensagens(Long remetenteId, Long destinatarioId) {
        return mensagemRepository.findByRemetenteIdAndDestinatarioId(remetenteId, destinatarioId);
    }

    public List<Mensagem> listarMensagensNaoLidas(Long destinatarioId) {
        return mensagemRepository.findByDestinatarioIdAndStatus(destinatarioId, Mensagem.Status.SENT);
    }

    public Mensagem salvar(Mensagem mensagem) {
        return mensagemRepository.save(mensagem);
    }

    public void deletar(Long id) {
        mensagemRepository.deleteById(id);
    }
}
