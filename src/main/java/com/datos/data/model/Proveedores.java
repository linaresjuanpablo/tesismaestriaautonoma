package com.datos.data.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "proveedores")
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class Proveedores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String nit;
    private String tipo_empresa;
    private String esPyme;
    private String ubicación;
    private String fecha_Creacion;
    private String pais;
    private String departamento;
    private String municipio;
    private String codigo_Categoria_principal;
    private String descripcion_categoria_principal;
    private String tipo_doc_representante_legal;
    private String num_doc_representante_legal;
    private String nombre_representante_legal;
    private String codigo;

}
