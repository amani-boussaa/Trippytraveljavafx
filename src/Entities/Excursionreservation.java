package Entities;

public class Excursionreservation {
    private int id,excursion_id,user_id ;
    private String prix,status,created_at,start,end,pi;

    public Excursionreservation() {
    }

    public Excursionreservation(int excursion_id, int user_id, String prix, String status) {
        this.excursion_id = excursion_id;
        this.user_id = user_id;
        this.prix = prix;
        this.status = status;
    }

  

    public Excursionreservation(int excursion_id, int user_id, String prix, String status, String created_at, String start, String end, String pi) {
        this.excursion_id = excursion_id;
        this.user_id = user_id;
        this.prix = prix;
        this.status = status;
        this.created_at = created_at;
        this.start = start;
        this.end = end;
        this.pi = pi;
    }

    public Excursionreservation(int id, int excursion_id, int user_id, String prix, String status, String created_at, String start, String end, String pi) {
        this.id = id;
        this.excursion_id = excursion_id;
        this.user_id = user_id;
        this.prix = prix;
        this.status = status;
        this.created_at = created_at;
        this.start = start;
        this.end = end;
        this.pi = pi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExcursion_id() {
        return excursion_id;
    }

    public void setExcursion_id(int excursion_id) {
        this.excursion_id = excursion_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getStatus() {
         if(status.equals("succeeded")){
             status = "payé";
        }
        return status;       
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    @Override
    public String toString() {
        return "Excursionreservation{" + "id=" + id + ", excursion_id=" + excursion_id + ", user_id=" + user_id + ", prix=" + prix + ", status=" + status + ", created_at=" + created_at + ", start=" + start + ", end=" + end + ", pi=" + pi + '}';
    }
    
}
