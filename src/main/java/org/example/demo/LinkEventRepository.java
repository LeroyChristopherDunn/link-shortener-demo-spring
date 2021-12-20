package org.example.demo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "events", path = "events")
public interface LinkEventRepository extends PagingAndSortingRepository<LinkEvent, Long> {

    @RestResource(exported = false)
    @Override
    <S extends LinkEvent> S save(S entity);

    @RestResource(exported = false)
    @Override
    <S extends LinkEvent> Iterable<S> saveAll(Iterable<S> entities);

    @RestResource(exported = false)
    @Override
    void deleteById(Long aLong);

    @RestResource(exported = false)
    @Override
    void delete(LinkEvent entity);

    @RestResource(exported = false)
    @Override
    void deleteAll(Iterable<? extends LinkEvent> entities);

    @RestResource(exported = false)
    @Override
    void deleteAll();
}


