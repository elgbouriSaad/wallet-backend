package ma.emsi.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Objective {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int totalAmount;
	private int amountSaved;
	private LocalDate period;
	
	public Objective(String name, int totalAmount, int amountSaved, LocalDate period) {
		super();
		this.name = name;
		this.totalAmount = totalAmount;
		this.amountSaved = amountSaved;
		this.period = period;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getAmountSaved() {
		return amountSaved;
	}

	public void setAmountSaved(int amountSaved) {
		this.amountSaved = amountSaved;
	}

	public LocalDate getPeriod() {
		return period;
	}

	public void setPeriod(LocalDate period) {
		this.period = period;
	}
	
	
}
