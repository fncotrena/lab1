package com.sistemaDistribuido.Banco.backend.controller;

import com.sistemaDistribuido.Banco.backend.model.Transacciones;
import com.sistemaDistribuido.Banco.backend.service.TransaccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/transacciones", produces = "application/json")
public class TransaccionController {
    @Autowired
    TransaccionesService transaccionesService;



    @GetMapping("/balance")
    public double balance() {
           double balance = 0;
        List<Transacciones> transacciones = transaccionesService.findAll();
         for (Transacciones transaccion : transacciones) {
             if (transaccion.getTipo().equals("DEPOSITO"))
                 balance += transaccion.getMonto();
             else if (transaccion.getTipo().equals("EXTRACCION"))
                 balance -= transaccion.getMonto();
             else if (transaccion.getTipo().equals("INTERES"))
                 balance = balance +(balance/100*transaccion.getMonto());
         }

        return balance;
    }

}
