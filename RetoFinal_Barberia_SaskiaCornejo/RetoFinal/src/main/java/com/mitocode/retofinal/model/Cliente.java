package com.mitocode.retofinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @Column( nullable = false, length = 60)
    private String nombres;

    @Column( nullable = false, length = 60)
    private String apellidos;

    @Column( nullable = false)
    private String dni;

    @Column( nullable = false)
    private Integer edad;
}
