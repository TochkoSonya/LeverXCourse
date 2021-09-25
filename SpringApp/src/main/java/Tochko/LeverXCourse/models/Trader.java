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

	private String title;
	private String description;

	@ManyToOne(optional = false,
			fetch = FetchType.EAGER)
	@JoinColumn(name="userId", nullable = false)
	private User user;


	@OneToMany(mappedBy = "trader",fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
	private Set<Comment> comments;

	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="TraderGame",
				joinColumns=@JoinColumn(name="traderId"),
				inverseJoinColumns = @JoinColumn(name="gameId"))
	private Set<Game> traderGames;

	public Trader() { }

	public Trader(String title, String description) {
		this.title=title;
		this.description=description;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public Set<Game> getTraderGames() {
		return traderGames;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
	    this.user=user;
    }

	public int getTraderId() {
		return traderId;
	}

	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}

	public void setTitle(String title) {
		this.title=title;
	}
	
	public void setDescription(String description) {
		this.description=description;
	}

	@Override
	public String toString() {
		return "Trader [ traderId= "+ traderId +" title= "+ title +" description= "+ description +" ]";
	}
}