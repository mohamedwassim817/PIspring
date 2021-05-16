package tn.esprit.spring.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Commentaire")
public class Commentaire  {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String contenu;
    @Column(nullable = false)
    private int nbrAgree;
    
    @ManyToOne
    Actualite actu;
	public int getId() {
		return id;
	}
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", contenu=" + contenu + ", nbrAgree=" + nbrAgree + "]";
	}
	public Commentaire(int id, String contenu, int nbrAgree) {
		super();
		this.id = id;
		this.contenu = contenu;
		this.nbrAgree = nbrAgree;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public int getNbrAgree() {
		return nbrAgree;
	}
	public void setNbrAgree(int nbrAgree) {
		this.nbrAgree = nbrAgree;
	}

}
