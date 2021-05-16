package tn.esprit.spring.service;

import tn.esprit.spring.model.Category;
import tn.esprit.spring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements ICategoryService<Category>{
    

	

	@Override
	public List<String> listeCategories() {
		// TODO Auto-generated method stub
		
		return categoryRepository.listeCategories();
	}

	@Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
    	
        return (List<Category>) categoryRepository.findAll();
        		   
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
	public Category findById(int id) {
		
		return categoryRepository.findById(id).get();
	}

	@Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

	@Override
	public List<Category> listeCategories1() {
		
		return (List<Category>) categoryRepository.findAll();
	}


}
