package Entities;

public class Category {
    private int id;
    private String libelle;

    public Category() {
    }
    public Category(String libelle) {
        this.libelle = libelle;
    }

    public Category(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Excursioncategorie{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
