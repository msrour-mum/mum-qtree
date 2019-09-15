package edu.mum.qtree.dao;

import edu.mum.qtree.models.entities.QuestionTags;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("QuestionTagsRepository")

public interface QuestionTagsRepository extends CrudRepository<QuestionTags,Integer> {
}
