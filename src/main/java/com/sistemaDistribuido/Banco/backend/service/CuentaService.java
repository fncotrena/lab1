package com.sistemaDistribuido.Banco.backend.service;


import com.sistemaDistribuido.Banco.backend.model.Cuenta;
import org.springframework.stereotype.Service;


@Service
public interface CuentaService {
    public Cuenta  extraccion (Cuenta cantidad);
    public Cuenta  depositar(Cuenta cantidad);
    public Cuenta  consultarSaldo();
    public Iterable<Cuenta> findAll();


    public Cuenta interes(int interes);
}
