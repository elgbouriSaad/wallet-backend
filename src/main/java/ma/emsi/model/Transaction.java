package ma.emsi.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int amount;
	private boolean type;
	private LocalDate date;
	public Transaction(int amount, boolean type, LocalDate date) {
		super();
		this.amount = amount;
		this.type = type;
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	
}
