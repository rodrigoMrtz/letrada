package br.com.letrada.game;

public record LetterResult(
    char letter,
    int position,
    LetterStatus status
) {  
}
