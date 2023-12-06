package ma.emsi.model;
import java.util.List;

import jakarta.persistence.*;
@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private List<Category> sousCategory; 
	
	public Category(String name, List<Category> sousCategory) {
		super();
		this.name = name;
		this.sousCategory = sousCategory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
