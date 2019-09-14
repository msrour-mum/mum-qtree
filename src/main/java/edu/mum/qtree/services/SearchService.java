package edu.mum.qtree.services;
//import com.mkyong.model.BaseballCard;


import edu.mum.qtree.models.entities.Question;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {


    @Autowired
    private final EntityManager centityManager;


    @Autowired
    public SearchService(EntityManager entityManager) {
        super();
        this.centityManager = entityManager;
    }


    public void initializeHibernateSearch() {

        try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(centityManager);
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Transactional
        public List<Question> fuzzySearch(String searchTerm) {

       FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(centityManager);
        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Question.class).get();
        Query luceneQuery = qb.keyword().fuzzy().withEditDistanceUpTo(1).withPrefixLength(1).onFields("text")
                .matching(searchTerm).createQuery();

        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Question.class);

        // execute search

        List<Question> BaseballCardList = null;



       /* FullTextEntityManager fullTextEntityManager
                = Search.getFullTextEntityManager(centityManager);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Question.class)
                .get();

        org.apache.lucene.search.Query query = queryBuilder
                .keyword()
                .onField("name")
                .matching(searchTerm)
                .createQuery();

        Query query = queryBuilder
                .keyword()
                .wildcard()
                .onField("name")
                .matching("Quesion*")
                .createQuery();


        Query query = queryBuilder
                .keyword()
                .fuzzy()
                .withEditDistanceUpTo(2)
                .withPrefixLength(0)
                .onField("text")
                .matching(searchTerm)
                .createQuery();

        org.hibernate.search.jpa.FullTextQuery jpaQuery
                = fullTextEntityManager.createFullTextQuery(query, Question.class);
*/


        try {
           // BaseballCardList = jpaQuery.getResultList();


            Question q=new Question();
            q.setId(1);
            q.setText("sdsadsdsdsdas");
            BaseballCardList =new ArrayList<>();
            BaseballCardList.add(q);
            //List<Question> results = jpaQuery.getResultList();
            //return  results;
        } catch (NoResultException nre) {
            ;// do nothing
            int x=0;

        }

        return BaseballCardList;


    }
}
