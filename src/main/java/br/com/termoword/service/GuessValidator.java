package br.com.termoword.service;

import br.com.termoword.entity.Word;
import br.com.termoword.exception.InvalidGuessException;
import br.com.termoword.repository.WordRepository;

import org.springframework.stereotype.Service;

@Service 
public class GuessValidator {
    
    private final WordRepository wordRepository;
    private final WordNormalizer wordNormalizer;

    public GuessValidator(
        WordRepository wordRepository,
        WordNormalizer wordNormalizer
    ) {
        this.wordRepository = wordRepository;
        this.wordNormalizer = wordNormalizer;
    }

    public Word validate(String word){
        String normalizedWord = wordNormalizer.normalize(word);

        if(normalizedWord.length() != 5){
            throw new InvalidGuessException(normalizedWord);
        }

        return wordRepository
            .findByWordIgnoreCaseAndActiveTrue(normalizedWord)
            .orElseThrow(() -> new InvalidGuessException(normalizedWord));
    }
}
