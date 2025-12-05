package sn.edu.isepat.tic.dfe.p6;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("gestionProduitsPU");
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
    }
}