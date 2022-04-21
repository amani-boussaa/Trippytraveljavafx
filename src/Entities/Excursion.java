package Entities;

public class Excursion {
    private int id,excursioncategorie_id;
    private String libelle,description,programme,ville,prix,duration,localisation;

    public Excursion() {
    }

    public Excursion(int excursioncategorie_id, String libelle, String description, String programme, String ville, String prix, String duration, String localisation) {
        this.excursioncategorie_id = excursioncategorie_id;
        this.libelle = libelle;
        this.description = description;
        this.programme = programme;
        this.ville = ville;
        this.prix = prix;
        this.duration = duration;
        this.localisation = localisation;
    }

    public Excursion(int id, int excursioncategorie_id, String libelle, String description, String programme, String ville, String prix, String duration, String localisation) {
        this.id = id;
        this.excursioncategorie_id = excursioncategorie_id;
        this.libelle = libelle;
        this.description = description;
        this.programme = programme;
        this.ville = ville;
        this.prix = prix;
        this.duration = duration;
        this.localisation = localisation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExcursioncategorie_id() {
        return excursioncategorie_id;
    }

    public void setExcursioncategorie_id(int excursioncategorie_id) {
        this.excursioncategorie_id = excursioncategorie_id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @Override
    public String toString() {
        return "Excursion{" +
                "id=" + id +
                ", excursioncategorie_id=" + excursioncategorie_id +
                ", libelle='" + libelle + '\'' +
                ", description='" + description + '\'' +
                ", programme='" + programme + '\'' +
                ", ville='" + ville + '\'' +
                ", prix='" + prix + '\'' +
                ", duration='" + duration + '\'' +
                ", localisation='" + localisation + '\'' +
                '}';
    }
}
