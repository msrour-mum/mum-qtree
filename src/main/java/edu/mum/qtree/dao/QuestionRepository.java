package edu.mum.qtree.dao;
import edu.mum.qtree.models.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {}
