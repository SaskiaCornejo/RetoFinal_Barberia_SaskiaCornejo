package com.mitocode.retofinal.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarberoDto {
    private Integer idBarbero;
    @NotNull
    @Size(min = 3, max = 60)
    private String nombres;
    @NotNull
    @Size(min = 3, max = 60)
    private String apellidos;
    @NotNull
    @Min(value = 0)
    @Max(value = 99)
    private Integer experiencia;
    @NotNull
    private boolean estado;
}
