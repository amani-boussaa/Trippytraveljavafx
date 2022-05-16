package Entities;




 
          
public class Article {

    private int id,views, excursioncategorie_id;
    private String libelle, description;
    
    public java.sql.Date created_at=new java.sql.Date(System.currentTimeMillis());
    private String imgSrc;
    private String color;

    public Article() {
    }

    public int getViews() {
        return views;
    }

    public Article(int id, String libelle, int excursioncategorie_id) {
        this.id = id;
        this.excursioncategorie_id = excursioncategorie_id;
        this.libelle = libelle;
        
        
        
    }

    public Article(int id, int excursioncategorie_id, String libelle, String description) {
        this.id = id;
        this.excursioncategorie_id = excursioncategorie_id;
        this.libelle = libelle;
        this.description = description;
        
     
        

    }

    public Article(int idcat, String lib, String desc) {
        this.excursioncategorie_id = idcat;
        this.libelle = lib;
        this.description = desc;
    }

    public Article(int id,int views, int excursioncategorie_id, String libelle, String description) {
        this.id = id;
        this.views = views;
        this.excursioncategorie_id = excursioncategorie_id;
        this.libelle = libelle;
        this.description = description;
        
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

    

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Excursion{" + "id=" + id + ", excursioncategorie_id=" + excursioncategorie_id + ", libelle=" + libelle + ", description=" + description  + ", imgSrc=" + imgSrc + ", color=" + color + '}';
    }

    
}
