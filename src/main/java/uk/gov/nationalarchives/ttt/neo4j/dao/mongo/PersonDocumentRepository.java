package uk.gov.nationalarchives.ttt.neo4j.dao.mongo;

import org.springframework.data.repository.PagingAndSortingRepository;
import uk.gov.nationalarchives.ttt.neo4j.domain.graphperson.MongoPerson;

/**
 * Created by jcharlet on 14/11/15.
 */
public interface PersonDocumentRepository
        extends PagingAndSortingRepository<MongoPerson, String>, PersonDocumentRepositoryCustom
{
}
