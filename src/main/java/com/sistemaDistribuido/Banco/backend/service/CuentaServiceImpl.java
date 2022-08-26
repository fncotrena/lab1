package com.sistemaDistribuido.Banco.backend.service;

import com.sistemaDistribuido.Banco.backend.model.Cuenta;
import com.sistemaDistribuido.Banco.backend.model.Transacciones;
import com.sistemaDistribuido.Banco.backend.repository.CuentaRepository;
import com.sistemaDistribuido.Banco.backend.repository.TransacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CuentaServiceImpl implements CuentaService {
    @Autowired
    private CuentaRepository repository;
    @Autowired
    private TransacionesRepository transacionesRepository;




    public Cuenta extraccion(Cuenta cantidad) {
        Optional<Cuenta> cuentaExt = repository.findById(1L);
        cuentaExt.get().setSaldo(cuentaExt.get().getSaldo() - cantidad.getSaldo());
        transacionesRepository.save(new Transacciones(cantidad.getSaldo(),"EXTRACCION", LocalDateTime.now()));
        return cuentaExt.get();
    }


    @Override
    public Cuenta depositar(Cuenta cantidad) {
        Cuenta cuentaDeposito = repository.findById(1L).get();
        cuentaDeposito.setSaldo(cuentaDeposito.getSaldo() + cantidad.getSaldo());
        transacionesRepository.save(new Transacciones(cantidad.getSaldo(), "DEPOSITO",LocalDateTime.now()));

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
    public Cuenta interes(int interes) {
        Cuenta cuentainteres = repository.findById(1L).get();
        interes = interes +(interes/100*cuentainteres.getSaldo());
        cuentainteres.setSaldo(cuentainteres.getSaldo()-interes);
        // transacionesRepository.save(new Transacciones(interes,Transacciones.Tipo.INTERES));
        transacionesRepository.save(new Transacciones(interes,"INTERES",LocalDateTime.now()));

        return cuentainteres;

    }


}



