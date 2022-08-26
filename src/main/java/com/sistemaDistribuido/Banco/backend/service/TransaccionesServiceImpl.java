package com.sistemaDistribuido.Banco.backend.service;

import com.sistemaDistribuido.Banco.backend.model.Transacciones;
import com.sistemaDistribuido.Banco.backend.repository.TransacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransaccionesServiceImpl implements TransaccionesService {
    @Autowired
    private TransacionesRepository repository;

    @Override
    public List<Transacciones> findAll() {
        return repository.findAll();
    }
}
