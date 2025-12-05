package sn.edu.isepat.tic.dfe.p6.Entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sn.edu.isepat.tic.dfe.p6.Entities.Utilisateur;


public class TestAutoIncremente {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("gestionProduitsPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Utilisateur u1 = new Utilisateur();
        u1.setNom("Samba");
        u1.setEmail("palaye068@icloud.com");

        Profil p1 = new Profil();
        p1.setBio("Directeur");
        p1.setTelephone("772690946");
        p1.setPhoto("Palaye.jpg");
        u1.setProfil(p1);

        // em.persist(p1);
        em.persist(u1);

        em.getTransaction().commit();
        em.getTransaction().begin();
        Utilisateur u2 = new Utilisateur();
        u2.setNom("Mbacke");
        u2.setEmail("mbacké@icloud.com");
        em.persist(u2);

        em.remove(u1); // Supprime l'entite dans la base de donnee
        em.getTransaction().commit();


        em.getTransaction().begin(); // Commence une nouvelle transaction
        Categorie electronique = new Categorie("Électronique", "Appareils high-tech");
        Produit p4 = new Produit("Laptop HP", 899.99, 15);
        Produit p2 = new Produit("Souris sans fil", 29.99, 50);
        Produit p3 = new Produit("Clavier mécanique", 149.99, 20);

        electronique.ajouterProduit(p4);
        electronique.ajouterProduit(p2);
        electronique.ajouterProduit(p3);

        em.persist(electronique); // Persiste la catégorie et cascade les produits
        em.getTransaction().commit(); // ✅ Commit final
        em.close();
        emf.close();
    }
}