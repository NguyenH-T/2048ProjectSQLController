package com.example.twenty_forty_eight_rest;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface CrudRepository<T, Id> extends PagingAndSortingRepository<T, Id> {
    
    <S extends T> S save(S Entity);

    void delete(T entity);

    Iterable<T> findAll(Sort sort);
}