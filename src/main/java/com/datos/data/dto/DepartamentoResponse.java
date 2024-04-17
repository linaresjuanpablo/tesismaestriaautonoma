package com.datos.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class DepartamentoResponse {
    private List<DepartamentoResponseDto> departamentoResponseDto;
}
