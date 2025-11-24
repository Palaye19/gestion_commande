package sn.edu.isepat.tic.dfe.p6.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY) // Il permet d'auto-incrementer
    private Long Id;

    @Column (nullable = false)
    private String nom;

    @Column(nullable = false, unique = true)
    private String email;


}
