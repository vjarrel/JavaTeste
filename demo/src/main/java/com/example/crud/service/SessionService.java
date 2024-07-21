package com.example.crud.service;

import com.example.crud.model.Session;
import com.example.crud.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public List<Session> listarTodos() {
        return sessionRepository.findAll();
    }

    public List<Session> listarPorStatus(Session.Status status) {
        return sessionRepository.findByStatus(status);
    }

    public Session salvar(Session session) {
        return sessionRepository.save(session);
    }

    public void deletar(Long id) {
        sessionRepository.deleteById(id);
    }
}
