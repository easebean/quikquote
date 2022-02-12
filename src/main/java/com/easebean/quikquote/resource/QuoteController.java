package com.easebean.quikquote.resource;

import com.easebean.quikquote.model.Quote;
import com.easebean.quikquote.service.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quote")
public class QuoteController {
    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Quote>> getAllQuotes(){
        List<Quote> quote = quoteService.allQuotes();
        return new ResponseEntity<List<Quote>>(quote, HttpStatus.OK);
    }

    @GetMapping("/find/a/{authorName}")
    public ResponseEntity<List<Quote>> getAllQuotesOfAuthor(@PathVariable("authorName") String name){
        List<Quote> quote = quoteService.findQuoteByAuthorName(name);
        return new ResponseEntity<List<Quote>>(quote,HttpStatus.OK);
    }

    @GetMapping("/find/c/{category}")
    public ResponseEntity<List<Quote>> getAllQuotesOfCategory(@PathVariable("category") String name){
        List<Quote> quote = quoteService.findQuoteByCategory(name);
        return new ResponseEntity<List<Quote>>(quote,HttpStatus.OK);
    }

    @GetMapping("/find/i/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable("id") Long id){
        Quote quote = quoteService.findQuoteById(id);
        return new ResponseEntity<Quote>(quote,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Quote> addQuote(@RequestBody Quote quote){
        Quote newQuote = quoteService.addQuote(quote);
        return new ResponseEntity<>(newQuote,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteQuote(@PathVariable("id") Long id){
        quoteService.deleteQuote(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
