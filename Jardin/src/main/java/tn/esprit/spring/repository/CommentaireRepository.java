package tn.esprit.spring.repository;







import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


import tn.esprit.spring.model.Commentaire;

@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire, Integer>{
	
/*	@Query(value = "select a.actu from Commentaire a where a.id = :id")
	   public List<String> getCommentaireActu(@Param("id") int id);*/
	
	/*SELECT *
	FROM commentaire
	INNER JOIN actualite ON commentaire.actu_id = actualite.id*/

}
