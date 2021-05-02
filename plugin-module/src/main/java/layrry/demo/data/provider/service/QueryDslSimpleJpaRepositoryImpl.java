
package layrry.demo.data.provider.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QuerydslJpaPredicateExecutor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.querydsl.EntityPathResolver;
import org.springframework.data.querydsl.SimpleEntityPathResolver;

import javax.persistence.EntityManager;
import java.util.Optional;

/**
 * QueryDslSimpleJpaRepository implementation.
 *
 * @param <T> the domain type the repository manages
 * @param <ID> the type of the id of the entity the repository manages
 */
public class QueryDslSimpleJpaRepositoryImpl<T, ID> extends
        SimpleJpaRepository<T, ID> implements QueryDslSimpleJpaRepository<T, ID> {


    /**
     * The EntityManager.
     */
    private EntityManager em;

    /**
     * The Querydsl delegate repository.
     */
    private QuerydslJpaPredicateExecutor<T> querydslJpaRepository;

    /**
     * The EntityPathResolver.
     */
    private static final EntityPathResolver RESOLVER = SimpleEntityPathResolver.INSTANCE;

    /**
     * Constructor.
     *
     * @param entityInformation
     * @param entityManager
     */
    public QueryDslSimpleJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        em = entityManager;
        querydslJpaRepository =
                new QuerydslJpaPredicateExecutor<>(entityInformation, entityManager, RESOLVER, null);
    }

    @Override
    public Optional<T> findOne(Predicate predicate) {
        return querydslJpaRepository.findOne(predicate);
    }

    @Override
    public Iterable<T> findAll(Predicate predicate) {
        return querydslJpaRepository.findAll(predicate);
    }

    @Override
    public Iterable<T> findAll(Predicate predicate, Sort sort) {
        return querydslJpaRepository.findAll(predicate, sort);
    }

    @Override
    public Iterable<T> findAll(Predicate predicate, OrderSpecifier<?>... orders) {
        return querydslJpaRepository.findAll(predicate, orders);
    }

    @Override
    public Iterable<T> findAll(OrderSpecifier<?>... orders) {
        return querydslJpaRepository.findAll(orders);
    }

    @Override
    public Page<T> findAll(Predicate predicate, Pageable pageable) {
        return querydslJpaRepository.findAll(predicate, pageable);
    }

    @Override
    public long count(Predicate predicate) {
        return querydslJpaRepository.count(predicate);
    }

    @Override
    public boolean exists(Predicate predicate) {
        return querydslJpaRepository.exists(predicate);
    }

    /**
     * Get the repository EntityManager.
     *
     * @return the EntityManager
     */
    public EntityManager getJpaEntityManager() {
        return em;
    }
}
