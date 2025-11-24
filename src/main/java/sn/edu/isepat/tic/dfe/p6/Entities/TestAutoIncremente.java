package sn.edu.isepat.tic.dfe.p6.Entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sn.edu.isepat.tic.dfe.p6.Entities.Utilisateur;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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

        em.close();
        emf.close();
    }
}