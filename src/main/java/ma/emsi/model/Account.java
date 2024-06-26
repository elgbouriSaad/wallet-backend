package ma.emsi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.model.Objective;
import java.util.*;

@Data
@NoArgsConstructor
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int balance;

	public Account(String name, int balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	

}
