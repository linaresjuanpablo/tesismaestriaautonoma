package com.datos.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NitResponseDTO {
    private String nombre;
    private String municipio;
    private String departamento;
    private String tipo_empresa;
    private String nombre_representante_legal;

    public NitResponseDTO(String nombre, String municipio, String departamento, String tipo_empresa, String nombre_representante_legal) {
        this.nombre = nombre;
        this.municipio = municipio;
        this.departamento = departamento;
        this.tipo_empresa = tipo_empresa;
        this.nombre_representante_legal = nombre_representante_legal;
    }




}
