package edu.mum.qtree.dao;


import edu.mum.qtree.models.custom.ItemSearchResult;
import org.springframework.data.repository.CrudRepository;

public interface SearchRepository extends CrudRepository<ItemSearchResult,Long> { }
