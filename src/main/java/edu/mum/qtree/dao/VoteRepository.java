package edu.mum.qtree.dao;

import edu.mum.qtree.models.entities.Vote;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote, Integer> {}
