/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author cheri
 */
public class Attraction {
    
   private int id;
    private String libelle,localisation,horraire;
      private int prix;


    public Attraction(int id, String libelle, String localisation, String horraire, int prix) {
        this.id = id;
        this.libelle = libelle;
        this.localisation = localisation;
        this.horraire = horraire;
        this.prix = prix;
    }

   

    public Attraction(String libelle, String localisation,String horraire,int prix) {
       
        this.libelle=libelle;
        this.localisation=localisation;
        this.horraire=horraire;
        this.prix=prix;
            
    
        
    }
    
    

    public Attraction() {
       
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getLocalisation() {
        return localisation;
    }

    public String getHorraire() {
        return horraire;
    }

    public int getPrix() {
        return prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setHorraire(String horraire) {
        this.horraire = horraire;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }


    @Override
    public String toString() {
        return "Attraction{" + id + "libelle=" + libelle + ", localisation=" + localisation + ", horraire=" + horraire + ", prix=" + prix +'}';
    }
    
}
