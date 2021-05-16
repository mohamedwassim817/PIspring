package tn.esprit.spring.service;

import java.util.List;





public interface ICommentaireService<T> {
	
	     List<T> findAll();

	     T findById(int id);

	     T create(T commentaire);
 
	     T update(T commentaire);
	     
	    void delete(int commentId);
	    
	 

}
