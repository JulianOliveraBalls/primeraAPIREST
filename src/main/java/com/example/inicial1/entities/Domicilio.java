package com.example.inicial1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Audited
public class Domicilio extends Base{
    @JoinColumn(name = "calle")
    private String calle;
    @JoinColumn(name = "numero")
    private int numero;



    @ManyToOne(optional = true)
    //Si o si el domicilio debe de tener una localidad
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;
}
