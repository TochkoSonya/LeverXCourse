package Tochko.LeverXCourse.models;
import javax.persistence.*;
import java.lang.String;
import java.util.Date;

@Entity
@Table(name="Comment")
public class Comment {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int commentId;

	private String message;
	private Date createdDate;
	private String status;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="traderId")
	private Trader trader;

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {this.trader=trader; }

	public Comment() { }

	public Comment(String message, Date createdDate, Status status) {
	this.message=message;
	this.createdDate=createdDate;
	this.status=status.getCode();

	}

	public int getCommentId() {
		return commentId;
	}
	
	public String getMessage() {
		return message;
	}

	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setMessage(String message) {
		this.message=message;
	}

	
	public void setCreatedDate(Date createdDate) {
		this.createdDate=createdDate;
	}
	
	public void setStatus(Status status) {
		this.status=status.getCode();
	}
}