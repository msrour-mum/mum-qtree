package edu.mum.qtree.dao;
import edu.mum.qtree.models.entities.Question;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface QuestionRepository extends CrudRepository<Question,Long > {




    @Transactional
    @Modifying
    @Query("UPDATE Question  q SET q.text =:text where q.id =:questionId")
    void UpdateData( @Param("questionId") long id,@Param("text") String text);



}
