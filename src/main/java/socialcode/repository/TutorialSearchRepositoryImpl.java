package socialcode.repository;


import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import socialcode.model.Tutorial;

import org.hibernate.SessionFactory;
import java.util.List;


@Transactional("transactionManager2")
@Repository("TutorialSearchRepository")
public class TutorialSearchRepositoryImpl implements TutorialSearchRepository {

    @Autowired
    private SessionFactory mySessionFactory;

    public void indexTutorials()
    {
        try
        {
            Session session = mySessionFactory.getCurrentSession();

            FullTextSession fullTextSession = Search.getFullTextSession(session);
            fullTextSession.createIndexer().startAndWait();
        }catch (Exception e){
            //What to do?? What to do to you.
        }

    }

    public List<Tutorial> search(String searchText) {


        Session session = mySessionFactory.getCurrentSession();

        FullTextSession fullTextSession = Search.getFullTextSession(session);

        QueryBuilder qb = fullTextSession.getSearchFactory()
                .buildQueryBuilder().forEntity(Tutorial.class).get();
        org.apache.lucene.search.Query query = qb
                .keyword().onFields("text","title")
                .matching(searchText)
                .createQuery();

        org.hibernate.Query hibQuery =
                fullTextSession.createFullTextQuery(query, Tutorial.class);
        System.out.println(hibQuery.list().size());
        List<Tutorial> results = hibQuery.list();
        return results;

    } // method search
}
