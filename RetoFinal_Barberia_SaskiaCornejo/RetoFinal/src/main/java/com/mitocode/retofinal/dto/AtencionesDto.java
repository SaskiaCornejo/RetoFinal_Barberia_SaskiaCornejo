package com.mitocode.retofinal.dto;

import com.mitocode.retofinal.model.Barbero;
import com.mitocode.retofinal.model.Cliente;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtencionesDto {
    private Integer idAtencion;
    @NotNull
    private LocalDateTime fechaAtencion;
    @NotNull
    private Cliente cliente;
    @NotNull
    private Barbero barbero;
    @NotNull
    @Size(min = 3, max = 50)
    private String tipoCorte;
    @NotNull
    private boolean estado;
}
