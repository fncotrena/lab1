package com.sistemaDistribuido.Banco.backend.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transacciones {
    private @Id
    @GeneratedValue Long id;
    private double monto;
    private Tipo tipo;

    public Transacciones() {
    }

    public Transacciones(double monto, Tipo tipo) {
        this.monto = monto;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public enum Tipo
    {
        DEPOSITO,
        EXTRACCION,
        INTERES

    }

}
