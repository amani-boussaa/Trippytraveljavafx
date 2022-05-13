/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author samar
 */
public class TypeMaison {
     private int id,pub;
     private String libelle ;
     
     
public  TypeMaison() {
    
}
    public TypeMaison(int pub, String libelle) {
        this.pub = pub;
        this.libelle = libelle;
    }

    public TypeMaison(int id, int pub, String libelle) {
        this.id = id;
        this.pub = pub;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPub() {
        return pub;
    }

    public void setPub(int pub) {
        this.pub = pub;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "TypeMaison{" + "id=" + id + ", pub=" + pub + ", libelle=" + libelle + '}';
    }
    
}

