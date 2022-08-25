package com.sistemaDistribuido.Banco.backend.service;

import com.sistemaDistribuido.Banco.backend.model.Cuenta;
import com.sistemaDistribuido.Banco.backend.model.Transacciones;
import com.sistemaDistribuido.Banco.backend.repository.CuentaRepository;
import com.sistemaDistribuido.Banco.backend.repository.TransacionesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuentaServiceImpl implements CuentaService {

    private CuentaRepository repository;
    private TransacionesRepository transacionesRepository;

    public CuentaServiceImpl() {
    }

    public CuentaServiceImpl(CuentaRepository repository, TransacionesRepository transacionesRepository) {
        this.repository = repository;
        this.transacionesRepository = transacionesRepository;
    }


    public Cuenta extraccion( int cantidad) {
        Optional<Cuenta> cuentaExt = repository.findById(1L);
        cuentaExt.get().setSaldo(cuentaExt.get().getSaldo() - cantidad);
        transacionesRepository.save(new Transacciones(cantidad,Transacciones.Tipo.EXTRACCION));
        return cuentaExt.get();
    }


    @Override
    public Cuenta depositar( int cantidad) {
        Cuenta cuentaDeposito = repository.findById(1L).get();
        cuentaDeposito.setSaldo(cuentaDeposito.getSaldo() + cantidad);
        transacionesRepository.save(new Transacciones(cantidad,Transacciones.Tipo.DEPOSITO));

        return cuentaDeposito;

    }

    @Override
    public Cuenta consultarSaldo() {
        Cuenta cuentaSaldo = repository.findById(1L).get();
        return cuentaSaldo;
    }

    @Override
    public Iterable<Cuenta> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Cuenta interes(int interes, int monto) {
        Cuenta cuentainteres = repository.findById(1L).get();
        interes = interes +(interes/100*monto);
        cuentainteres.setSaldo(cuentainteres.getSaldo()-interes);
        transacionesRepository.save(new Transacciones(interes,Transacciones.Tipo.INTERES));

        return cuentainteres;

        }


    }
