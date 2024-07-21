package com.example.crud.controller;

import com.example.crud.model.Mensagem;
import com.example.crud.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensagens")
public class MensagemController {

    @Autowired
    private MensagemService mensagemService;

    @GetMapping("/{remetenteId}/{destinatarioId}")
    public List<Mensagem> listarMensagens(
            @PathVariable Long remetenteId, @PathVariable Long destinatarioId) {
        return mensagemService.listarMensagens(remetenteId, destinatarioId);
    }

    @GetMapping("/nao-lidas/{destinatarioId}")
    public List<Mensagem> listarMensagensNaoLidas(@PathVariable Long destinatarioId) {
        return mensagemService.listarMensagensNaoLidas(destinatarioId);
    }

    @PostMapping
    public Mensagem salvar(@RequestBody Mensagem mensagem) {
        return mensagemService.salvar(mensagem);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        mensagemService.deletar(id);
    }
}
