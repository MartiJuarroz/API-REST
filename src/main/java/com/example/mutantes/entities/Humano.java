package com.example.mutantes.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "humano")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Humano implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @ElementCollection
    @Column
    private String adn;

    @Column(name = "esMutante")
    private boolean EsMutante;



}
