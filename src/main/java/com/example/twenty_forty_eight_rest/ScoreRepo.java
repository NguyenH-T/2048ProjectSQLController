package com.example.twenty_forty_eight_rest;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ScoreRepo extends PagingAndSortingRepository<Score, Long> {

    Iterable<Score> findAll(Sort sort);

    void delete(Score entity);

    Score save(Score entity);
}
