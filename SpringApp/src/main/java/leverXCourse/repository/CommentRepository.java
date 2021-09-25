package leverXCourse.repository;

import leverXCourse.models.Comment;
import leverXCourse.models.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer>  {

    List<Comment> findByTrader(Trader trader);

    @Query("select c from Comment c inner join c.trader where c.status='active' and c.trader=?1")
    List<Comment> findCommentsWithActiveStatusByTrader(Trader trader);


}