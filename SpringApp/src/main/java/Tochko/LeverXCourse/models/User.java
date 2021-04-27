package Tochko.LeverXCourse.models;
import java.lang.String;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

import static Tochko.LeverXCourse.models.Status.*;


@Entity
@Table(name = "CommonUser")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private Date createdDate;
	private String role;
	private String status;


	@OneToMany(mappedBy = "user",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Trader> traders;

	public Set<Trader> getTraders() {
		return traders;
	}

	public User() {
		
	}
	
	public User(String firstName, String lastName, 
			String password, String email, Date createdDate,
				Role role, Status status) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.password=password;
		this.email=email;
		this.createdDate=createdDate;
		this.role=role.getCode();
		this.status=status.getCode();
	}

	public Long getUserId() {
		return userId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public String getRole() {
		return role;
	}

	public String getStatus() {
		return status;
	}
	
	
	public void setUserId(Long userId) {
		this.userId=userId;
	}
	
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	
	public void setPassword(String passwrod) {
		this.password=passwrod;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate=createdDate;
	}



	public void setRole(Role role) {
		this.role=role.getCode();
	}

	public void setStatus(Status status) {
		this.status=status.getCode();
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", name=" + firstName + ", email=" + email +"]";
	}
}