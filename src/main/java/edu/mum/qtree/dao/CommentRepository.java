package edu.mum.qtree.dao;

import edu.mum.qtree.models.entities.Comment;
import edu.mum.qtree.models.entities.Question;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Comment q SET q.text =:text where q.id =:id")
    void UpdateData(@Param("id") long id, @Param("text") String text);
}
