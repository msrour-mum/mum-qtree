package edu.mum.qtree.dao;

import edu.mum.qtree.models.entities.Answer;
import edu.mum.qtree.models.entities.Question;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository("AnswerRepository")
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Answer q SET q.text =:text where q.id =:id")
    void UpdateData(@Param("id") long id, @Param("text") String text);
}
