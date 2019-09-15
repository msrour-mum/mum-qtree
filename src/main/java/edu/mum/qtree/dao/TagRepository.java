package edu.mum.qtree.dao;

import edu.mum.qtree.models.entities.Tag;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository("TagRepository")

public interface TagRepository extends CrudRepository<Tag, Integer>

{

    @Query("select t from Tag t where t.name=:name")
    Optional<Tag> findByName(@Param("name") String name);



}
