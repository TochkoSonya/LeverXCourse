package leverXCourse.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.String;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Game")
public class Game {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int gameId;

	private String title;
	private String description;
	private Date createdDate;
	private Date updatedDate;

	@ManyToMany(mappedBy = "traderGames")
	private Set<Trader> traders;
}