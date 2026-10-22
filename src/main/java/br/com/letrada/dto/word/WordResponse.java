package br.com.letrada.dto.word;

import br.com.letrada.entity.Word;

import java.time.LocalDateTime;

public record WordResponse(
        Long id,
        String word,
        String language,
        String category,
        String difficulty,
        Boolean active,
        LocalDateTime createdAt
) {
    public static WordResponse fromEntity(Word word) {
        return new WordResponse(
            word.getId(), 
            word.getWord(),
            word.getLanguage(), 
            word.getCategory(), 
            word.getDifficulty(), 
            word.getActive(), 
            word.getCreatedAt()
        );
    }
}