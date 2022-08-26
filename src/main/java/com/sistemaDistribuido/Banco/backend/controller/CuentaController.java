package com.sistemaDistribuido.Banco.backend.controller;

import com.sistemaDistribuido.Banco.backend.model.Cuenta;
import com.sistemaDistribuido.Banco.backend.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cuentas", produces = "application/json")
public class CuentaController{

    @Autowired
    private CuentaService cuentaService;


    @GetMapping("")
    public Iterable<Cuenta> all() {
        return this.cuentaService.findAll();
    }

        @GetMapping("/saldo")
        public Cuenta saldo() {
        return this.cuentaService.consultarSaldo();
        }

        @PutMapping("/depositar")
        public Cuenta depositar( @RequestParam int monto) {
            return this.cuentaService.depositar(monto);
        }

    @PutMapping("/extraer")
    public Cuenta extraccion( @RequestParam int monto) {
        return this.cuentaService.extraccion(monto);
    }
    @PutMapping("/interes")
    public Cuenta interes( @RequestParam int monto,int interes) {
        return this.cuentaService.interes(monto,interes);
    }


}
