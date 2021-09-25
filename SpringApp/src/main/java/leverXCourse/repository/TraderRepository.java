package leverXCourse.repository;

import leverXCourse.models.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TraderRepository extends JpaRepository<Trader, Integer>{

    @Query("select t from Trader t inner join t.user where t.user.status=?1")
    List<Trader> findTraderWithProcessingStatus(String status);

    @Query("select t from Trader t inner join t.user where t.user.status='active'")
    List<Trader> findTraderWithActiveStatus();

    @Query("select t from Trader t inner join t.user where t.user.userId=?1")
    List<Trader> findTraderByUserId(int userId);

}
