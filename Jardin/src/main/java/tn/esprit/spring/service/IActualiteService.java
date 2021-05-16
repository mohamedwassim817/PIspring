
package tn.esprit.spring.service;
import tn.esprit.spring.model.Actualite;

import java.util.ArrayList;



//import org.springframework.data.repository.query.Param;

public interface IActualiteService {
    Actualite addActualite(Actualite a);

    void deleteActualite(Actualite a);
    
    public void deleteactualiteById( int id);

    Actualite updateActualite(Actualite a);

    ArrayList<Actualite> getActualiteList();

    Actualite getActualite(Actualite a);

    Actualite getActualiteByID(int id);
    
    public Long sumlikes();
    
    public Long sumLikesParPost(int id);
    
    public int addOrUpdateActualite(Actualite a);
    
    public Long postes();
    
    public Long avglikes();
    
    public void addLike(int id_post,int quantity);

   // int getQuantity(int id);

   // void setQuantity(int id, int newQ);

}