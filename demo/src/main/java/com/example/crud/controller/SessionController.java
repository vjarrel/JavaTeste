package com.example.crud.controller;

import com.example.crud.model.Session;
import com.example.crud.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping
    public List<Session> listarTodos() {
        return sessionService.listarTodos();
    }

    @GetMapping("/status/{status}")
    public List<Session> listarPorStatus(@PathVariable Session.Status status) {
        return sessionService.listarPorStatus(status);
    }

    @PostMapping
    public Session salvar(@RequestBody Session session) {
        return sessionService.salvar(session);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        sessionService.deletar(id);
    }
}
