package Entities;

/**
 *
 * @author amani
 */
public class Maisonrating {
    private Integer id;
    private Integer maison_id;
    private Integer user_id;   
    private Double rating;

    public Maisonrating(Integer id, Integer maison_id, Integer user_id, Double rating) {
        this.id = id;
        this.maison_id = maison_id;
        this.user_id = user_id;
        this.rating = rating;
    }

    public Maisonrating(Integer maison_id, Integer user_id, Double rating) {
        this.maison_id = maison_id;
        this.user_id = user_id;
        this.rating = rating;
    }

    public Maisonrating() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaison_id() {
        return maison_id;
    }

    public void setMaison_id(Integer maison_id) {
        this.maison_id = maison_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Maisonrating{" + "id=" + id + ", maison_id=" + maison_id + ", user_id=" + user_id + ", rating=" + rating + '}';
    }

   

   



    
}