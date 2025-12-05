package sn.edu.isepat.tic.dfe.p6.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "categorie")
public class categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String descripation;

    @OneToOne(cascade = CascadeType.ALL)
    private categorie produit;

}
