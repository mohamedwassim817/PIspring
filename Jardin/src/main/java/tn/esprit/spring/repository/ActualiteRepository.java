package tn.esprit.spring.repository;




import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.model.Actualite;


@Repository
public interface ActualiteRepository extends CrudRepository<Actualite, Integer> {
	//nombre de posts
	   @Query(value = "select COUNT(*) from Actualite a")
	   public Long postes();

	//somme des likes sur tous les posts(stat)
   @Query(value = "select SUM(a.quantity) from Actualite a")
   public Long sumlikes();
   
 //moyenne des likes sur tous les posts(stat)
   @Query(value = "select AVG(a.quantity) from Actualite a")
   public Long avglikes();
   
 //nombre de likes par post selon id 
   @Query(value = "select a.quantity from Actualite a where a.id = :id")
   public Long sumLikesParPost(@Param("id") int id);
   
   
   // ajouter un like selon id post 
   @Modifying
   @Transactional
   @Query(value = "update Actualite a set a.quantity = :quantity where a.id = :id")
   public int addLike(@Param("id") int id_post, @Param("quantity") int quanity);

   //supprimer actualite selon id 
   
  /* @Modifying
	@Transactional
	@Query("DELETE FROM Enfant e WHERE e.parents= :parents")
	public void DeletedParentEnfant(@Param("parents") Optional<Parent> x);
	@Query("Delete from Enfant p where p.id=:pkt")*/
	
 //public void RemoveAndSetNull(@Param("pkt") Enfant x);
	
   @Modifying
	@Transactional
	@Query("DELETE FROM Actualite a WHERE a.id= :id")
	public void deleteactualiteById(@Param("id") int id);
   /*  @Modifying
    @Query(value = "update Book b set b.quantity = :newQ where b.id = :id")
    void setQuantity(@Param("id") int id, @Param("newQ") int newQ);*/

    //@Query("SELECT v from Book v where v.pkt=:pkt")
	//List<Book> selectAllBookid(@Param("pkt") Optional<Packet> optional);
}  