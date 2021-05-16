package tn.esprit.spring.controller;


//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.model.Actualite;
import tn.esprit.spring.model.Category;
import tn.esprit.spring.service.ActualiteServiceImp;
import tn.esprit.spring.service.CategoryServiceImp;

//
//
//
//import java.util.ArrayList;
import java.util.List;
//http://localhost:8085/ProjectMVC/servlet/api/category
@RequestMapping("api/category")
@RestController
public class CategoryController {
    @Autowired
    CategoryServiceImp catServiceImp;
    
    @Autowired
    ActualiteServiceImp actservice;
    
    
  //http://localhost:8085/ProjectMVC/servlet/api/category/getCategoryList  
    @GetMapping("/getCategoryList")
     public List<Category> getCategoryList() {
        return catServiceImp.findAll();
     }
    
    
    
  //http://localhost:8085/ProjectMVC/servlet/api/category/addCategory  
    @PostMapping("/addCategory")
    @ResponseBody
    public Category addCategory(@RequestBody Category c) {
    	Category cat=catServiceImp.create(c);
     return  cat;
       }
    
    
//http://localhost:8085/ProjectMVC/servlet/api/category/updateCategory 
   @PutMapping("/updateCategory")
   @ResponseBody
    public Category updteCategory(@RequestBody Category c) {
      return catServiceImp.update(c);  
       }
//
// 
    
//
//
//    @GetMapping("/getBook/{id}")
//    public Book getBookbyId(@PathVariable int id) {
//        return bookServiceImp.getBookByID(id);
//    }
//
//    @GetMapping("/getQuantity/{id}")
//    public int getQuantity(@PathVariable int id) {
//        return bookServiceImp.getQuantity(id);
//    }
//
//             JSF-------------------------
   private Actualite ac;
   private List<Actualite> actuList;


public List<Actualite> getActu() {
	return actuList;
}



public void setActu(List<Actualite> actu) {
	this.actuList = actu;
}



public Actualite getAc() {
	return ac;
}



public void setAc(Actualite ac) {
	this.ac = ac;
}
   
}