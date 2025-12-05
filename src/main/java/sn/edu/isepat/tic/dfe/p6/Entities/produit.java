package sn.edu.isepat.tic.dfe.p6.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "produit")
public class produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nom;
    private double prix;
    private int stock;

    @ManyToOne
    private produit produit;

}
