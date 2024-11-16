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
public class ClienteDto {
    private Integer idCliente;
    @NotNull
    @Size(min = 3, max = 60)
    private String nombres;
    @NotNull
    @Size(min = 3, max = 60)
    private String apellidos;
    @NotNull
    @Size(min = 8, max = 8)
    private String dni;
    @NotNull
    @Min(value = 5)
    @Max(value = 99)
    private Integer edad;
}
