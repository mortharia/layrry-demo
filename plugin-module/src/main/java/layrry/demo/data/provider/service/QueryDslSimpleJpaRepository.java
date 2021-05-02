

package layrry.demo.data.provider.service;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Custom QueryDsl JpaRepository.
 */

/**
 *  Querydsl SimpleJpaRepository.
 *
 * @param <T> the domain type the repository manages
 * @param <ID> the type of the id of the entity the repository manages
 */
public interface QueryDslSimpleJpaRepository<T, ID> extends
        PagingAndSortingRepository<T, ID>, QuerydslPredicateExecutor<T> {
}
