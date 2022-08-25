package com.sistemaDistribuido.Banco.backend.repository;

import com.sistemaDistribuido.Banco.backend.model.Transacciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacionesRepository extends JpaRepository<Transacciones, Long> {
}
