package org.example.demo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "links", path = "links")
public interface LinkRepository extends PagingAndSortingRepository<Link, String> {

}


