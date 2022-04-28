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
public class Chartexcursion {
    private Integer excursioncategorie_id;  
    private Integer count;

    public Chartexcursion(Integer excursioncategorie_id, Integer count) {
        this.excursioncategorie_id = excursioncategorie_id;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Chartexcursion{" + "excursioncategorie_id=" + excursioncategorie_id + ", count=" + count + '}';
    }

    public Integer getExcursioncategorie_id() {
        return excursioncategorie_id;
    }

    public void setExcursioncategorie_id(Integer excursioncategorie_id) {
        this.excursioncategorie_id = excursioncategorie_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    
    
}
