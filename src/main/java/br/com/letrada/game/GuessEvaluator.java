package br.com.letrada.game;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component 
public class GuessEvaluator {
    public List<LetterResult> evaluate(String secretWord, String guess) {
        List<LetterResult> results = new ArrayList<>();
        int[] remainingLetters = new int[26];

        // Conta as letras da palavra secreta que ainda não foram usadas
        for (int i = 0; i < secretWord.length(); i++) {
            char letter = secretWord.charAt(i);

            // Compara se a letra da palavra secreta é diferente da letra da tentativa na mesma posição
            if (letter != guess.charAt(i)) {
                // Se for diferente, guarda a letra da palavra secreta na contagem de letras restantes
                remainingLetters[letter - 'A']++;
            }
        }

        // identifica as letras na possicao correta
        for (int i = 0; i < guess.length(); i++){

            char letter = guess.charAt(i);

            if (letter == secretWord.charAt(i)) {
                results.add(new LetterResult(
                    letter, i, LetterStatus.CORRECT
                ));
            } else {
                results.add(null);
            }
        }

        // identifica letras existentes em outras posições
        for (int i = 0; i < guess.length(); i++) {
            
            if (results.get(i) != null) {
                continue;
            }

            char letter = guess.charAt(i);
            int index = letter - 'A';

            if (index >= 0 && index < remainingLetters.length 
                    && remainingLetters[index] > 0) {
                results.set(i, new LetterResult(
                    letter, i, LetterStatus.PRESENT
                ));
                
                remainingLetters[index]--;
            } else {
                results.set(i, new LetterResult(
                    letter, i, LetterStatus.ABSENT
                ));
            }
        }
        
        return results;
    }
}
