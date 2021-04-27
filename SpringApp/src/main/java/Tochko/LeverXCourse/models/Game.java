package Tochko.LeverXCourse.models;
import javax.persistence.*;
import java.lang.String;
import java.util.Date;
import java.util.Set;

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

	public Set<Trader> getTraders() {
		return traders;
	}

	public Game() { }

	public Game(String title, String description, Date createdDate, Date updatedDate) {
		this.title=title;
		this.description=description;
		this.createdDate=createdDate;
		this.updatedDate=updatedDate;
	}

	public int getGameId() {
		return gameId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	
	public Date getUpdatedDate() {
		return updatedDate;
	}
	
	public void setGameId(int gameId) {
		this.gameId=gameId;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public void setDescription(String description) {
		this.description=description;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate=createdDate;
	}
	
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate=updatedDate;
	}

	@Override
	public String toString() {
		return "Game [id=" + gameId + ", title=" + title + ", description=" + description +"]";
	}
}