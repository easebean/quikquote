package com.easebean.quikquote.repository;

import com.easebean.quikquote.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Long, Quote> {
}
