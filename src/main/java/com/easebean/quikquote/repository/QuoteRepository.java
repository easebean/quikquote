package com.easebean.quikquote.repository;

import com.easebean.quikquote.model.Quote;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuoteRepository extends PagingAndSortingRepository<Quote, Long> {
    void deleteQuoteById(Long id);
    Optional<Quote> findQuoteById(Long id);
    List<Quote> findQuoteByAuthorName(String authorName);
    List<Quote> findQuoteByCategory(String category);
}
