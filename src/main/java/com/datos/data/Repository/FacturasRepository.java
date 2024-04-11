package com.datos.data.Repository;

import com.datos.data.model.Facturas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturasRepository extends JpaRepository<Facturas, Long> {
}
