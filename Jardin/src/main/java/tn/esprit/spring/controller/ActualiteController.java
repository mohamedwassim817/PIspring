package tn.esprit.spring.controller;

import java.util.Date;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
//import java.util.List;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.apache.logging.log4j.LogManager;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import tn.esprit.spring.model.Actualite;
import tn.esprit.spring.model.Category;
import tn.esprit.spring.model.Commentaire;
import tn.esprit.spring.repository.ActualiteRepository;
import tn.esprit.spring.repository.CategoryRepository;
import tn.esprit.spring.service.ActualiteServiceImp;
import tn.esprit.spring.service.CategoryServiceImp;
import tn.esprit.spring.service.CommentaireServiceImp;

//@Named
//@RequestScoped
//@RequestMapping("api/Actualite")
//@RestController
//@Scope(value = "session")
@Controller(value = "ActualiteController") // Name of the bean in Spring IoC
@ELBeanName(value = "ActualiteController")// Name of the bean used by JSF
//@Join(path = "/", to = "/vue.jsf")
public class ActualiteController {
	
//	private static final Logger L = LogManager.getLogger(ContratControlerImp.class);
	
	    private int id;

	    private String title;

	    private double price;

	    private String pubHouse;

	    private String summary;

	    private Date releaseDate;
	    
	    public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Date getReleaseDate() {
			return releaseDate;
		}

		public void setReleaseDate(Date releaseDate) {
			this.releaseDate = releaseDate;
		}

		public String getAuthors() {
			return authors;
		}

		public void setAuthors(String authors) {
			this.authors = authors;
		}

		private String image;
	    
	    private String authors;
	
	
		private int quantity;

	    private String status;
	    
	    private Category categorie;
	    
	    public List<Category> categories;
	    
	    public List<Category> categories1;
	    
	    private String se;

	    private Part file;
	    
	    private Commentaire comment; 
	    
	    private List<Commentaire> comments;
	    
	    private List<Actualite> actualites;
	    
	    private String nbrlikes ;
	    
	    private String moy;
	    
	    private String posts;
	    
	   
	    
	    public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
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

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		private String folder1 = "./imgeUpload\\";
		//    D:\\PIspring\\Jardin\\src\\main\\webapp\\resources\\imageUpload\\
		private String folder="D:\\PIspring\\Jardin\\src\\main\\webapp\\resources\\imageUpload\\";
		private String cin;
		
		
	   
		
		public ActualiteServiceImp getAc() {
			return ac;
		}

		public void setAc(ActualiteServiceImp ac) {
			this.ac = ac;
		}

		
		public String getSe() {
			return se;
		}

		public void setSe(String se) {
			this.se = se;
		}
		
		
		public Commentaire getComment() {
			return comment;
		}

		public void setComment(Commentaire comment) {
			this.comment = comment;
		}

		
		//get somme de nbr de likes 
		
		public String getnbrlikes(){
			
			return  ac.sumlikes().toString();
		}
		
		
       //get moyenne de nbr de likes 
		
		public String getmoy(){
			
			return  ac.avglikes().toString();
		} 
		
       //get nombre de posts 
		
		public String getposts(){
			
			return  ac.postes().toString();
		} 
	
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
	  //http://localhost:8085/ProjectMVC/servlet/api/Actualite/getActualiteList  
	    @GetMapping("/getActualiteList")
	     public ArrayList<Actualite> getactualiteList() {
	        return ac.getActualiteList();
	     }

	  //http://localhost:8085/ProjectMVC/servlet/api/Actualite/addActualite  
	    @PostMapping("/addActualite")
	    @ResponseBody
	     public Actualite addactualite(@RequestBody Actualite a) {
	    	Actualite actu =ac.addActualite(a);
	        return actu;
	     }

	  //http://localhost:8085/ProjectMVC/servlet/api/Actualite/updateActualite 
	    @PutMapping("/updateActualite")
	    @ResponseBody
	     public Actualite updateactualite(@RequestBody Actualite a) {
	       return ac.updateActualite(a);  
	        }
	    
	    
	    //nbr de likes sur l'ensemble des actualit??s
	  //http://localhost:8085/ProjectMVC/servlet/api/Actualite/nbrLike 
	    @GetMapping("/nbrLike")
	    @ResponseBody
	     public Long nbrLike() {
	       return ac.sumlikes();  
	        }
	    
	    //nbr de likes sur l'actulait?? selon id 
		  //http://localhost:8085/ProjectMVC/servlet/api/Actualite/nbrLikePost/ 
		    @GetMapping("/nbrLikePost/{id}")
		    @ResponseBody
		     public Long nbrLikeParPost(@PathVariable int id) {
		       return ac.sumLikesParPost(id);  
		        }
		    
		    
		    //************JSF*******************************
		    
		   
		    
		   
		    
		   


			

			
			
			
			
			
			// get all commentaires
			
			 public List<Commentaire> getcomments(){
				 
				 
				 
					return comm.findAll();
				}
			
			
			//fonction qui retourne le nom de toutes les categories dans une liste
			 public List<String> getcategories(){
				 
				 
				 
				return cat.listeCategories();
			}
			 
			 
			//fonction qui retourne le nom de toutes les categories dans une liste
			 public List<Category> getcategories1(){
				 
				 
				 
				return cat.listeCategories1();
			}
			 
			 
			 //ajouter un like sur post
			 
			 public void addlikes(int id_post, int quantity){
				 
				 System.out.println("Called with parameter************* "+id_post);
				 ac.addLike(id_post,quantity);
				 
			 }
			 
			 
			 
			 
			 
			
			 public String cvvc(){
				// ActualiteController
				 
			
				// L.info("wasssssssssssssssmmmamamama");
					return "kk";
				}
			 
			 
			//ajouter actualite JSF
			public void addactualite() {
				Category x= catrep.getcategorie(Integer.parseInt(se));
				System.out.println("helllofgdgdfgfd");
				//Actualite actu =new Actualite();
				//Actualite acc=ac.setActualiteId(int.toInt(selectedelement)); on ajoute acc comme nouvelle categorie
				
				
				
				ac.addOrUpdateActualite(new Actualite( title, pubHouse, summary,quantity,releaseDate, image, authors,x));
		    }

			
			//supprimer actualite jsf
			
			public void removeActualite(int id){
				if(ac.sumLikesParPost(id)==0)
				ac.deleteactualiteById(id);
			}
			
			public List<Actualite> getActualites() {
				actualites=	ac.getActualiteList();
				return actualites;
			}

			public void setActualites(List<Actualite> actualites) {
				this.actualites = actualites;
			}
			
		    
			
			
			
		    // upload image 
				
			public void upload()  {
				//Ajout Localement du fichier
			/*	Scanner s = new Scanner(file.getInputStream());
				String filecontent =s.useDelimiter("\\A").next();
				s.close();
				System.out.println(filecontent);
				Files.write(Paths.get("C:\\"+file.getSubmittedFileName()), filecontent.getBytes(), StandardOpenOption.CREATE);*/
					       
				try (InputStream input = file.getInputStream()) {
					String fileName = file.getSubmittedFileName();
					 Files.copy(input, new File(folder, fileName).toPath());} 
				catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				

			}

			
			
			
			
			
			public StreamedContent getGraphicText() {
		        try {
		            return DefaultStreamedContent.builder()
		                    .contentType("image/png")
		                    .stream(() -> {
		                        try {
		                            BufferedImage bufferedImg = new BufferedImage(100, 25, BufferedImage.TYPE_INT_RGB);
		                            Graphics2D g2 = bufferedImg.createGraphics();
		                            g2.drawString("This is a text", 0, 10);
		                            ByteArrayOutputStream os = new ByteArrayOutputStream();
		                            ImageIO.write(bufferedImg, "png", os);
		                            return new ByteArrayInputStream(os.toByteArray());
		                        }
		                        catch (Exception e) {
		                            e.printStackTrace();
		                            return null;
		                        }
		                    })
		                    .build();
		        } catch (Exception e) {
		            e.printStackTrace();
		            return null;
		        }
		    }

			

			
			
		

			

		

		

		

			

			

			

			

			
			
			/* public StreamedContent getChart() {
			        try {
			            return DefaultStreamedContent.builder()
			                    .contentType("image/png")
			                    .stream(() -> {
			                        try {
			                            //JFreeChart jfreechart = ChartFactory.createPieChart("Cities", createDataset(), true, true, false);
			                        //    File chartFile = new File("dynamichart");
			                          Part file ;
			                          String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/uploads/")
			                        			.path(file.getSubmittedFileName()).toUriString();
			                        		   cin = fileDownloadUri;
			                        		  // Dossier D = new Dossier(cin);
			                        			//DS.ajouterDossier(D);
			                        		//   DS.ajouterDossier(new Dossier(cin));

			                          //  ChartUtilities.saveChartAsPNG(chartFile, jfreechart, 375, 300);
			                            return new FileInputStream(chartFile);
			                        }
			                        catch (Exception e) {
			                            e.printStackTrace();
			                            return null;
			                        }
			                    })
			                    .build();
			        } catch (Exception e) {
			            e.printStackTrace();
			            return null;
			        }
			    }*/
			
			
}
