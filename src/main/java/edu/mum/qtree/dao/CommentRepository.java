package edu.mum.qtree.dao;

import edu.mum.qtree.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {}
