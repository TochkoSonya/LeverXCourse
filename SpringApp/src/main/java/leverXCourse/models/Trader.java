package leverXCourse.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.String;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Trader")
public class Trader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int traderId;
    private String title;
    private String description;

    @ManyToOne(optional = false,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", nullable = false)
    private User user;


    @OneToMany(mappedBy = "trader", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Comment> comments;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "TraderGame",
            joinColumns = @JoinColumn(name = "traderId"),
            inverseJoinColumns = @JoinColumn(name = "gameId"))
    private Set<Game> traderGames;
}