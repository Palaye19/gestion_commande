package sn.edu.isepat.tic.dfe.p6;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Utilisateur {
    @Id
    private Long Id;
    @Column (nullable = false)
    private String nom;
    @Column (nullable = false)
    private String email;

}
