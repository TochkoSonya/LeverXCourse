package leverXCourse.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.String;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CommonUser")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	private String firstName;
	private String lastName;
	private int password;
	private String email;
	private Date createdDate;
	private Role role;
	private Status status;

	@OneToMany(	mappedBy = "user",
			cascade = CascadeType.ALL)
	private Set<Trader> traders;
}