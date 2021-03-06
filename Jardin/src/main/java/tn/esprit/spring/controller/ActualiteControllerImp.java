package tn.esprit.spring.controller;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ViewScoped;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.model.Actualite;
import tn.esprit.spring.model.Category;
import tn.esprit.spring.repository.ActualiteRepository;
import tn.esprit.spring.repository.CategoryRepository;
import tn.esprit.spring.service.ActualiteServiceImp;
import tn.esprit.spring.service.CategoryServiceImp;
import tn.esprit.spring.service.CommentaireServiceImp;

@Scope(value = "session")
@Controller(value = "ActualiteControllerImp")
@ELBeanName(value = "ActualiteControllerImp") 
@Join(path = "/", to = "/ajoutActualite.jsf")

public class ActualiteControllerImp {
	
	 @Autowired
	  ActualiteServiceImp ac;
	 @Autowired
	  CategoryServiceImp cat;
	  @Autowired
	  CommentaireServiceImp comm;
	  @Autowired
	  CategoryRepository catrep;
	  @Autowired
	  ActualiteRepository actrep;
	  
	
	
	private String  title;
	
	private String  image;
	
	private String  pubHouse;
	
	private String  summary;
	
	private Date  releaseDate;
	
	private int quantity;
	
	public ActualiteServiceImp getAc() {
		return ac;
	}

	public void setAc(ActualiteServiceImp ac) {
		this.ac = ac;
	}

	public CategoryServiceImp getCat() {
		return cat;
	}

	public void setCat(CategoryServiceImp cat) {
		this.cat = cat;
	}

	public CommentaireServiceImp getComm() {
		return comm;
	}

	public void setComm(CommentaireServiceImp comm) {
		this.comm = comm;
	}

	public CategoryRepository getCatrep() {
		return catrep;
	}

	public void setCatrep(CategoryRepository catrep) {
		this.catrep = catrep;
	}

	public ActualiteRepository getActrep() {
		return actrep;
	}

	public void setActrep(ActualiteRepository actrep) {
		this.actrep = actrep;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPubHouse() {
		return pubHouse;
	}

	public void setPubHouse(String pubHouse) {
		this.pubHouse = pubHouse;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getSe() {
		return se;
	}

	public void setSe(String se) {
		this.se = se;
	}

	

	

	private String authors;
	
	 private String se;
	 
	 
	 private Category categorie;
	    
	 public List<Category> categories;
	    
	 public List<Category> categories1;
	
	//fonction qui retourne le nom de toutes les categories dans une liste
		 public List<String> getcategories(){
			 
			 
			 
			return cat.listeCategories();
		}
		 
		 
		//fonction qui retourne le nom de toutes les categories dans une liste
		 public List<Category> getcategories1(){
			 
			 
			 
			return cat.listeCategories1();
		}

	 
	 
	 public void addactualite() {
			Category x= catrep.getcategorie(Integer.parseInt(se));
			System.out.println("helllofgdgdfgfd");
			Actualite actu =new Actualite();
			//title, pubHouse, summary,quantity,releaseDate, image, authors,x
			//Actualite acc=ac.setActualiteId(int.toInt(selectedelement)); on ajoute acc comme nouvelle categorie
			actu.setTitle(title);
			actu.setPubHouse(pubHouse);
			actu.setSummary(summary);
			actu.setQuantity(quantity);
			actu.setReleaseDate(releaseDate);
			actu.setImage(image);
			actu.setAuthors(authors);
			actu.setCategory(x);
			actu.setStatus("etablissement");
	System.out.println(actu);
			
			ac.addOrUpdateActualite(actu);
	    }

	
	 
	
	 
}
