package br.com.letrada.service;

import br.com.letrada.entity.Word;
import br.com.letrada.exception.WordNotFoundException;
import br.com.letrada.dto.word.WordResponse;
import br.com.letrada.dto.word.CreateWordRequest;
import br.com.letrada.repository.WordRepository;
import br.com.letrada.dto.word.UpdateWordRequest;

import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class WordService {

    private final WordRepository wordrepository;

    public WordService(WordRepository wordrepository) {
        this.wordrepository = wordrepository;
    }

    public WordResponse create(CreateWordRequest request) {
        Word word = new Word();
        word.setWord(request.word());
        word.setLanguage(request.language());
        word.setCategory(request.category());
        word.setDifficulty(request.difficulty());
        
        Word savedWord = wordrepository.save(word);

        return WordResponse.fromEntity(savedWord);
    }

    public WordResponse findById(Long id) {
        Word word = wordrepository.findById(id)
                .orElseThrow(() -> new WordNotFoundException(id));
        return WordResponse.fromEntity(word);
    }

    public List<WordResponse> findAll() {
        return wordrepository.findAll().stream()
                .map(WordResponse::fromEntity)
                .toList();
    }

    public WordResponse update(Long id, UpdateWordRequest request){
        
        Word word = wordrepository.findById(id)
            .orElseThrow(() -> new WordNotFoundException(id));

        word.setWord(request.word());
        word.setLanguage(request.language());
        word.setCategory(request.category());
        word.setDifficulty(request.difficulty());

        Word updatedWord = wordrepository.save(word);

        return WordResponse.fromEntity(updatedWord);
    }

    public void delete(Long id){
        Word word = wordrepository.findById(id)
            .orElseThrow(() -> new WordNotFoundException(id));
        
        wordrepository.delete(word);
    }
}
