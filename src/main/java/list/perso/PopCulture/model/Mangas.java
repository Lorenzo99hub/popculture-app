package list.perso.PopCulture.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="mangas")
public class Mangas {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false)
    private String nom;
    @Column(length = 50, nullable = false)
    private String auteur;
    private int tomeLu;
    private int tomeTotal;

    public Mangas() {}

    public Mangas(String nom, String auteur, int tomeLus, int tomeTotal) {
        this.nom = nom;
        this.auteur = auteur;
        this.tomeLu = tomeLus;
        this.tomeTotal = tomeTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getTomeLu() {
        return tomeLu;
    }

    public void setTomeLu(int tomeLu) {
        this.tomeLu = tomeLu;
    }

    public int getTomeTotal() {
        return tomeTotal;
    }

    public void setTomeTotal(int tomeTotal) {
        this.tomeTotal = tomeTotal;
    }

   @Override
    public String toString() {
    return "Mangas [id=" + id 
           + ", nom=" + nom 
           + ", auteur=" + auteur 
           + ", tomeLu=" + tomeLu 
           + ", tomeTotal=" + tomeTotal 
           + "]";
}
   
}
