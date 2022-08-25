package com.sistemaDistribuido.Banco.backend.service;

import com.sistemaDistribuido.Banco.backend.model.Transacciones;
import com.sistemaDistribuido.Banco.backend.repository.TransacionesRepository;

import java.util.List;

public class TransaccionesServiceImpl implements TransaccionesService {
    private TransacionesRepository repository;

    public TransaccionesServiceImpl() {
    }

    public TransaccionesServiceImpl(TransacionesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Transacciones> findAll() {
        return repository.findAll();
    }
}
