package Tochko.LeverXCourse.models;
import javax.persistence.*;
import java.lang.String;
import java.util.Set;

@Entity
@Table(name="Trader")
public class Trader {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int traderId;

	//private int userId;
	private String title;
	private String description;


	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="userId")
	private User user;

	@OneToMany(mappedBy = "trader",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Comment> comments;

	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="TraderGame",
				joinColumns=@JoinColumn(name="traderId"),
				inverseJoinColumns = @JoinColumn(name="gameId"))
	private Set<Game> traderGames;

	public Set<Comment> getComments() {
		return comments;
	}

	public Set<Game> getTraderGames() {
		return traderGames;
	}

	public User getUser() {
		return user;
	}


	public int getTraderId() {
		return traderId;
	}
	
//	public int getUserId() {
//		return userId;
//	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setTraderId(int traderId) {
		this.traderId=traderId;
	}
	
//	public void setUserId(int userId) {
//		this.userId=userId;
//	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public void setDescription(String description) {
		this.description=description;
	}
}