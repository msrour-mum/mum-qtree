package edu.mum.qtree.dao;

import edu.mum.qtree.models.entities.QuestionTags;
import org.springframework.data.repository.CrudRepository;

public interface QuestionTagsRepository extends CrudRepository<QuestionTags,Integer> {
}
