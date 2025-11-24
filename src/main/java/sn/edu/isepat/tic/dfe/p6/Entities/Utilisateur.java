package sn.edu.isepat.tic.dfe.p6.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY) // Il permet d'auto-incrementer
    private Integer Id;

    @Column (nullable = false)
    private String nom;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
