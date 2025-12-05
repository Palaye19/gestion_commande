package sn.edu.isepat.tic.dfe.p6.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateCommande;
    private String statut; // EN_ATTENTE, VALIDEE, EXPEDIEE, LIVREE
    private double montantTotal;

    // ----------------- Relation Many-to-Many avec Produit -----------------
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "commande_produit",
            joinColumns = @JoinColumn(name = "commande_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private List<Produit> produits = new ArrayList<>();

    // ----------------- Constructeurs -----------------
    public Commande() {
        this.dateCommande = LocalDate.now();
        this.statut = "EN_ATTENTE";
        this.montantTotal = 0.0;
    }

    public Commande(LocalDate dateCommande, String statut) {
        this.dateCommande = dateCommande;
        this.statut = statut;
        this.montantTotal = 0.0;
    }

    // ----------------- Méthodes pratiques -----------------

    // Ajouter un produit à la commande et mettre à jour montantTotal
    public void ajouterProduit(Produit produit) {
        if (produit != null && !produits.contains(produit)) {
            produits.add(produit);
            produit.getCommandes().add(this); // Maintenir la bidirectionnalité
            montantTotal += produit.getPrix();
        }
    }

    // Retirer un produit de la commande et mettre à jour montantTotal
    public void retirerProduit(Produit produit) {
        if (produit != null && produits.contains(produit)) {
            produits.remove(produit);
            produit.getCommandes().remove(this); // Maintenir la bidirectionnalité
            montantTotal -= produit.getPrix();
        }
    }

    // ----------------- Getters / Setters -----------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}
