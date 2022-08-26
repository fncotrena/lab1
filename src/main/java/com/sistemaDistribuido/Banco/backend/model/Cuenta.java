package com.sistemaDistribuido.Banco.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Cuenta {
    private @Id
    @GeneratedValue
    Long id;
    private int saldo;

    public Long getId() {
        return id;
    }

    public void setId(Long numeroCuenta) {
        this.id = numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
