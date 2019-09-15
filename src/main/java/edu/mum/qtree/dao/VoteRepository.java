package edu.mum.qtree.dao;

import edu.mum.qtree.models.entities.Answer;
import edu.mum.qtree.models.entities.Question;
import edu.mum.qtree.models.entities.User;
import edu.mum.qtree.models.entities.Vote;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository("VoteRepository")
public interface VoteRepository extends CrudRepository<Vote, Long> {
    @Query("select t from Vote t where t.user=:userId and t.answer=:answerId")
    Optional<Vote> findByData(@Param("userId") User userId, @Param("answerId") Answer answerId);


    @Transactional
    @Modifying
    @Query("UPDATE Vote q SET q.like =:like where q.id =:id")
    void UpdateData(@Param("id") long id, @Param("like") int like);
}
