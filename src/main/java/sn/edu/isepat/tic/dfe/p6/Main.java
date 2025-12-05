package sn.edu.isepat.tic.dfe.p6;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sn.edu.isepat.tic.dfe.p6.Entities.Profil;
import sn.edu.isepat.tic.dfe.p6.Entities.Utilisateur;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("gestionProduitsPU");
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
    }
}