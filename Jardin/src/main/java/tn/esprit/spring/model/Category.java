package tn.esprit.spring.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
public class Category implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String name;
    
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="category")
   	@JsonBackReference
   	private List<Actualite> actualites;
    //@OneToMany(mappedBy = "Category")
   // private Set<FavoriteCategorie> Fcc;
 
    public List<Actualite> getActualites() {
		return actualites;
	}

	public void setActualites(List<Actualite> actualites) {
		this.actualites = actualites;
	}

	public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id && Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
