/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

public class Maisonshotes {
    private int id,typeMaison_id;
    private String capacite,nbrChambres,libelle,localisation,proprietaire,prix;
    

public  Maisonshotes() {
    
}

    public Maisonshotes(String capacite, String nbrChambres, int typeMaison_id, String libelle, String localisation, String proprietaire, String prix) {
        this.capacite = capacite;
        this.nbrChambres = nbrChambres;
        this.typeMaison_id = typeMaison_id;
        this.libelle = libelle;
        this.localisation = localisation;
        this.proprietaire = proprietaire;
        this.prix = prix;
    }



    public Maisonshotes(int id, String capacite, String nbrChambres, int typeMaison_id, String libelle, String localisation, String proprietaire, String prix) {
        this.id = id;
        this.capacite = capacite;
        this.nbrChambres = nbrChambres;
        this.typeMaison_id = typeMaison_id;
        this.libelle = libelle;
        this.localisation = localisation;
        this.proprietaire = proprietaire;
        this.prix = prix;
    }

    public Maisonshotes(int id, String capacite, String nbrChambres, String typeMaison_id, String libelle, String localisation, String proprietaire, String prix) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }

    public String getNbrChambres() {
        return nbrChambres;
    }

    public void setNbrChambres(String nbrChambres) {
        this.nbrChambres = nbrChambres;
    }

    public int getTypeMaison_id() {
        return typeMaison_id;
    }

    public void setTypeMaison_id(int typeMaison_id) {
        this.typeMaison_id = typeMaison_id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Maisonshotes{" + 
                "id=" + id + 
                ", capacite=" + capacite +
                ", nbrChambres=" + nbrChambres + 
                ", typeMaison_id=" + typeMaison_id +
                ", libelle=" + libelle +
                ", localisation=" + localisation +
                ", proprietaire=" + proprietaire + 
                ", prix=" + prix + '}';
    }
    
    
    
    
}
