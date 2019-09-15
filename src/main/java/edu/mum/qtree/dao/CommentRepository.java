package edu.mum.qtree.dao;

        import edu.mum.qtree.models.entities.Comment;
        import edu.mum.qtree.models.entities.Question;
        import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {}
