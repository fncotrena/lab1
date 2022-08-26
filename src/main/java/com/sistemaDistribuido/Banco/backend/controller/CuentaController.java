package com.sistemaDistribuido.Banco.backend.controller;

import com.sistemaDistribuido.Banco.backend.dto.InteresDto;
import com.sistemaDistribuido.Banco.backend.model.Cuenta;
import com.sistemaDistribuido.Banco.backend.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
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

        @PostMapping("/depositar")
        public Cuenta depositar( @RequestBody Cuenta cantidad) {
            return this.cuentaService.depositar(cantidad);
        }

    @PostMapping("/extraer")
    public Cuenta extraccion( @RequestBody Cuenta cantidad) {
        return this.cuentaService.extraccion(cantidad);
    }
    @PostMapping("/interes")
    public Cuenta interes( @RequestBody InteresDto interes) {
        return this.cuentaService.interes((int) interes.interes);
    }


}
