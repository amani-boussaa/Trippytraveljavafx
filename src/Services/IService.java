package Services;

import java.sql.SQLException;
import java.util.List;

public interface IService<T> {
    void ajouter(T t) throws SQLException;
    void ajouterr(T t)throws SQLException;
    List<T> afficher() throws SQLException;
    public void modifer(T t);
    public void supprimer(int id);
}
