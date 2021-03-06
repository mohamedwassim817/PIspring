package tn.esprit.spring.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

// #{session.lastAccessedTime} jsf date de session
@Entity
@Table(name = "actualite")
public class Actualite  implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

   
	private double price;

    private String pubHouse;

    private String summary;

    private Date releaseDate;
    
    public Actualite() {
		super();
		// TODO Auto-generated constructor stub
	}


    public Actualite(String title, double price, String pubHouse, String summary, Date releaseDate, int quantity,
			String status, Category category, int nbPage) {
		super();
		this.title = title;
		this.price = price;
		this.pubHouse = pubHouse;
		this.summary = summary;
		this.releaseDate = releaseDate;
		this.quantity = quantity;
		this.status = status;
		this.category = category;
		this.nbPage = nbPage;
	}

	private int quantity;

    private String status;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;
    
   
    
    public Actualite(String title, String pubHouse, String summary, int quantity,Date date, String image, String authors) {
		super();
		
		this.title = title;
		this.pubHouse = pubHouse;
		this.summary = summary;
		this.quantity = quantity;
		this.image = image;
		this.releaseDate=date;
		Authors = authors;
	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy="actu")
    private Set <Commentaire> comment;
    
	
   

	public Set<Commentaire> getComment() {
		return comment;
	}

	public void setComment(Set<Commentaire> comment) {
		this.comment = comment;
	}

	private String image;

    private int nbPage;

    private String Authors;

    private boolean isDiscounted = false;
//    @ManyToOne   
//    private Packet pkt;
    public Actualite(int id) {
        this.id = id;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getNbPage() {
		return nbPage;
	}

	public void setNbPage(int nbPage) {
		this.nbPage = nbPage;
	}

	public String getAuthors() {
		return Authors;
	}

	public void setAuthors(String authors) {
		Authors = authors;
	}

	public boolean isDiscounted() {
		return isDiscounted;
	}

	public void setDiscounted(boolean isDiscounted) {
		this.isDiscounted = isDiscounted;
	}

	public Actualite(String title, double price, String pubHouse, String summary, Date releaseDate, int quantity,
			String status, Category category, String image, int nbPage, String authors, boolean isDiscounted) {
		super();
		this.title = title;
		this.price = price;
		this.pubHouse = pubHouse;
		this.summary = summary;
		this.releaseDate = releaseDate;
		this.quantity = quantity;
		this.status = status;
		this.category = category;
		this.image = image;
		this.nbPage = nbPage;
		Authors = authors;
		this.isDiscounted = isDiscounted;
	}

	public Actualite(int id, String title, double price) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
	}

	public Actualite(String title2, double price2, String pubHouse2, String summary2, Date releaseDate2, int quantity2, String status2, Category categorie) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Actualite(String title3, double price3, String pubHouse3, String summary3, Date releaseDate3, int quantity2, String status3) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Actualite(String title2, String pubHouse2, String summary2, int quantity2, Date releaseDate2, String image2,
			String authors2, Category c) {
		// TODO Auto-generated constructor stub
	}

	public Actualite(int id2, String title2, String pubHouse2, String summary2, int quantity2, Date releaseDate2,
			String image2, String authors2, Category x) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Actualite [id=" + id + ", title=" + title + ", price=" + price + ", pubHouse=" + pubHouse + ", summary="
				+ summary + ", releaseDate=" + releaseDate + ", quantity=" + quantity + ", status=" + status
				+ ", category=" + category + ", image=" + image + ", nbPage=" + nbPage + ", Authors=" + Authors
				+ ", isDiscounted=" + isDiscounted + "]";
	}

	
	

}