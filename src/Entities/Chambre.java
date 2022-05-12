/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trippytraveljava2.Entities;


public class Chambre {
    private int id;
    private String typechambre;
    private int prix;
    private String description_chambre;

    public Chambre() {
        this.id = id;
        this.typechambre = typechambre;
        this.prix = prix;
        this.description_chambre = description_chambre;
    }

    public Chambre(String typechambre, int prix, String description_chambre) {
        this.typechambre = typechambre;
        this.prix = prix;
        this.description_chambre = description_chambre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String gettypechambre() {
        return typechambre;
    }

    public void settypechambre(String typechambre) {
        this.typechambre = typechambre;
    }

    public int getprix() {
        return prix;
    }

    public void setprix(int prix) {
        this.prix = prix;
    }

    public String getdescription_chambre() {
        return description_chambre;
    }

    public void setdescription_chambre(String description_chambre) {
        this.description_chambre = description_chambre;
    }

    @Override
    public String toString() {
        return "Chambre{" + "typechambre=" + typechambre + ", prix=" + prix + ", description_chambre=" + description_chambre + '}';
    }

}


