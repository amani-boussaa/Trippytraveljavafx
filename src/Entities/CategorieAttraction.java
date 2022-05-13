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
public class CategorieAttraction {
    
   private int id;
    private String libelle;
      private boolean contrainteAge;


    public CategorieAttraction(int id, String libelle, boolean contrainteAge) {
        this.id = id;
        this.libelle = libelle;
        this.contrainteAge = contrainteAge;
    }

   

    public CategorieAttraction(String libelle, boolean contrainteAge) {
       
        this.libelle=libelle;
        this.contrainteAge=contrainteAge;
              
    }
    
    

    public CategorieAttraction() {
       
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public boolean getcontrainteAge() {
        return contrainteAge;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setcontrainteAge(boolean contrainteAge) {
        this.contrainteAge = contrainteAge;
    }


    @Override
    public String toString() {
        return "CategorieAttraction{" + id + "libelle=" + libelle + ", contrainteAge=" + contrainteAge + '}';
    }
    
}
