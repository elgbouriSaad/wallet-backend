package ma.emsi.model;

import java.time.LocalDate;

import jakarta.persistence.*;

public class User {
	@Id
	//i'm not sure about this @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int amount;
	private LocalDate dateSalary;
	private int salary;
	
	
	public User(String firstName, String lastName, String email, String password, int amount, LocalDate dateSalary,
			int salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.amount = amount;
		this.dateSalary = dateSalary;
		this.salary = salary;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public LocalDate getDateSalary() {
		return dateSalary;
	}
	public void setDateSalary(LocalDate dateSalary) {
		this.dateSalary = dateSalary;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	

}