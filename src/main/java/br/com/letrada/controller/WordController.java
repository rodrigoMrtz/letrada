package br.com.letrada.controller;

import br.com.letrada.service.WordService;
import br.com.letrada.dto.word.CreateWordRequest;
import br.com.letrada.dto.word.UpdateWordRequest;
import br.com.letrada.dto.word.WordResponse;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/words")
public class WordController {
    
    private final WordService wordservice;

    public WordController(WordService wordservice) {
        this.wordservice = wordservice;
    }

    @PostMapping 
    @ResponseStatus (HttpStatus.CREATED)
    public WordResponse create(
        @Valid @RequestBody CreateWordRequest request
    ) {
        return wordservice.create(request);
    }

    @GetMapping("/{id}")
    public WordResponse findById(@PathVariable Long id) {
        return wordservice.findById(id);
    }

    @GetMapping 
    public List<WordResponse> findAll() {
        return wordservice.findAll();
    }

    @PutMapping ("/{id}")
    public WordResponse update(
        @PathVariable Long id,
        @Valid @RequestBody UpdateWordRequest request
    ) {
        return wordservice.update(id, request);   
    }

    @DeleteMapping ({"/{id}"})
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        wordservice.delete(id);
    }
}
