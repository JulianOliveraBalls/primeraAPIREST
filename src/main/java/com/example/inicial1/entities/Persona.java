package com.example.inicial1.entities;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Audited
@Getter
@Setter
@ToString
@Builder
@Table(name = "persona")
public class Persona extends Base{
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dni")
    private Integer dni;


    @OneToOne(cascade = CascadeType.ALL)
    //CascadeType.All me pide hacer la persistencia, la actualizacion e elminacion a través de persona
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //orphanRemoval es que si elimino una persona se eliminan todos los libros tambien
    @JoinTable(
            name="persona_libro",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    //Sirve para ManyToMany y para relaciones OneToMany
    @Builder.Default
    private List<Libro> libros = new ArrayList<>();
}

