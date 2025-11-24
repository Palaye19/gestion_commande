package sn.edu.isepat.tic.dfe.p6;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Profil {
    @Id
    private int id;

    @Column(nullable = false)
    private String bio;

    private String telephone;

}
