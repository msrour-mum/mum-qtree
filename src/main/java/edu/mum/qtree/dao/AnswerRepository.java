package edu.mum.qtree.dao;

import edu.mum.qtree.models.entities.Answer;
import edu.mum.qtree.models.entities.Question;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {}
