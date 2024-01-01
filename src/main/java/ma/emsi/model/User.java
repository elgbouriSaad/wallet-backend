package ma.emsi.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(unique = true)
	private String email;

	private String password;

	private int amount;

	@Column(name = "date_salary")
	private LocalDate dateSalary;

	private int salary;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Account> accounts = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL)
	private Setting setting;

	@Column(name = "email_verified")
	private boolean emailVerified;

	public User() {
	}

	public User(String firstName, String lastName, String email, String password, int amount, LocalDate dateSalary, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.amount = amount;
		this.dateSalary = dateSalary;
		this.salary = salary;
	}

	// Getter and setter methods...

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Setting getSetting() {
		return setting;
	}

	public void setSetting(Setting setting) {
		this.setting = setting;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public boolean isEnabled() {
		return true;
	}

	public Collection<User> getAuthorities() {
		return null;
	}
}
