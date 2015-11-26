package uk.gov.nationalarchives.ttt.neo4j.dao.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import uk.gov.nationalarchives.ttt.neo4j.domain.Link;

/**
 * Created by jcharlet on 14/11/15.
 */
public interface LinkRepository
        extends PagingAndSortingRepository<Link, String>, LinkRepositoryCustom
{

    Page<Link> findByScoreGreaterThan(Double scoreThreshold, Pageable pageRequest);
}
