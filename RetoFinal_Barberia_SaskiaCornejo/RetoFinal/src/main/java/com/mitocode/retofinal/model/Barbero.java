package com.mitocode.retofinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Barbero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBarbero;

    @Column( nullable = false, length = 60)
    private String nombres;

    @Column( nullable = false, length = 60)
    private String apellidos;

    @Column( nullable = false)
    private Integer experiencia;

    @Column( nullable = false)
    private boolean estado;
}
