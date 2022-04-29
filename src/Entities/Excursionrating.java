/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author amani
 */
public class Excursionrating {
    private Integer id;
    private Integer excursion_id;
    private Integer user_id;   
    private Double rating;

    public Excursionrating(Integer id, Integer excursion_id, Integer user_id, Double rating) {
        this.id = id;
        this.excursion_id = excursion_id;
        this.user_id = user_id;
        this.rating = rating;
    }

    public Excursionrating(Integer excursion_id, Integer user_id, Double rating) {
        this.excursion_id = excursion_id;
        this.user_id = user_id;
        this.rating = rating;
    }

    public Excursionrating() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExcursion_id() {
        return excursion_id;
    }

    public void setExcursion_id(Integer excursion_id) {
        this.excursion_id = excursion_id;
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
        return "Excursionrating{" + "id=" + id + ", excursion_id=" + excursion_id + ", user_id=" + user_id + ", rating=" + rating + '}';
    }

   

   



    
}
