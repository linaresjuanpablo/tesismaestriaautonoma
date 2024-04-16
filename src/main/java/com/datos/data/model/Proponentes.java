package com.datos.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "proponentes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Proponentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String id_procedimiento;
    private String fecha_publicacion;
    private String nombre_procedimiento;
    private String nit_entidad;
    private String codigo_entidad;
    private String entidad_compradora;
    private String proveedor;
    private String nit_proveedor;
    private String codigo_proveedor;

}
