package com.sistemaDistribuido.Banco.backend.service;

import com.sistemaDistribuido.Banco.backend.model.Transacciones;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransaccionesService {

    public List<Transacciones> findAll();
}
