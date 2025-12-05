package sn.edu.isepat.tic.dfe.p6.Entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private double prix;
    private int stock;

    // ----------------- Relation Many-to-One avec Categorie -----------------
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    // ----------------- Relation Many-to-Many avec Commande -----------------
    @ManyToMany(mappedBy = "produits")
    private List<Commande> commandes = new ArrayList<>();

    // ----------------- Constructeurs -----------------
    public Produit() {}

    public Produit(String nom, double prix, int stock) {
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
    }

    // ----------------- Getters / Setters -----------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    // ----------------- Méthodes pratiques -----------------

    public void ajouterCommande(Commande commande) {
        if (commande != null && !commandes.contains(commande)) {
            commandes.add(commande);
            commande.getProduits().add(this); // Bidirectionnel
        }
    }

    public void retirerCommande(Commande commande) {
        if (commande != null && commandes.contains(commande)) {
            commandes.remove(commande);
            commande.getProduits().remove(this); // Bidirectionnel
        }
    }
}
