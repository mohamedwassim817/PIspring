package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
	 @Query(value = "select (c.name) from Category c")
	   public List<String> listeCategories();
	 
	 @Query("SELECT u FROM Category u WHERE u.id= :id")
		public Category getcategorie(@Param("id") int l);
}
