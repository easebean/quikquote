package com.easebean.quikquote.service;

import com.easebean.quikquote.model.Quote;
import com.easebean.quikquote.repository.QuoteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuoteService {
    private final QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public Quote addQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    public List<Quote> allQuotes() {
        return (List<Quote>) quoteRepository.findAll();
    }

   public Quote findQuoteById(Long id)
   {
       return quoteRepository.findQuoteById(id).orElse(null);
   }

    public List<Quote> findQuoteByAuthorName(String name)
    {
        return quoteRepository.findQuoteByAuthorName(name);
    }

    public List<Quote> findQuoteByCategory(String category)
    {
        return quoteRepository.findQuoteByCategory(category);
    }

    public List<Quote> getQuotes(Pageable page){
        Page<Quote> response = quoteRepository.findAll(page);
        return response.get().collect(Collectors.toList());
    }

    @Transactional
    public void deleteQuote(Long id)
    {
        quoteRepository.deleteQuoteById(id);
    }

}
