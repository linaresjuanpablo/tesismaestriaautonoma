package com.datos.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DepartamentoResponseDto {
    private String nombre;
    private String codigo;
    private String municipio;

    public DepartamentoResponseDto(String nombre, String codigo, String municipio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.municipio = municipio;
    }







}
