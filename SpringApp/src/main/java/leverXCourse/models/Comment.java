package leverXCourse.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.String;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Comment")
public class Comment {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int commentId;
	private String message;
	private Date createdDate;
	private Status status;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="traderId")
	private Trader trader;
}