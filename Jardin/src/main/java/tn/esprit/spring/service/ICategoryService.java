package tn.esprit.spring.service;

//import tn.esprit.spring.model.Category;

import java.util.List;

import tn.esprit.spring.model.Category;

public interface ICategoryService<T> {
	
    List<T> findAll();
    
   

   T findById(int id);

    T create(T category);

    T update(T category);
    
    public List<String> listeCategories();
    
    public List<Category> listeCategories1();


}
