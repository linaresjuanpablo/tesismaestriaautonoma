package com.datos.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="proveedores")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

public class proveedorConsulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departamento;
    private String municipio;
    private String nombre;
    private String codigo;
    private String descripcion_categoria_principal;
}
