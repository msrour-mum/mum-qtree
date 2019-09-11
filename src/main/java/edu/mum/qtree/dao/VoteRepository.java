package edu.mum.qtree.dao;

import edu.mum.qtree.models.Vote;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote, Integer> {}
