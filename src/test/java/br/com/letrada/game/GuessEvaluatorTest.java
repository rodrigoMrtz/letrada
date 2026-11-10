package br.com.letrada.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class GuessEvaluatorTest {

    private final GuessEvaluator evaluator = new GuessEvaluator();

    @Test 
    void shouldMarkCorrectLetters() {
        List<LetterResult> results = 
            evaluator.evaluate("CASAS", "CASAS");

        assertEquals(5, results.size());

        for (LetterResult result : results) {
            assertEquals(LetterStatus.CORRECT, result.status());
        }

    }
    
    @Test 
    void shouldMarkPresentLetters() {
        List<LetterResult> results =
            evaluator.evaluate("CASAS", "SUCOS");

            assertEquals(LetterStatus.PRESENT, results.get(0).status());// S
            assertEquals(LetterStatus.PRESENT, results.get(2).status());// C
    }

    @Test
    void shouldMarkAbsentLetters() {
        List<LetterResult> results =
            evaluator.evaluate("CASAS", "MUNDO");
        
        for (LetterResult result : results) {
            assertEquals(LetterStatus.ABSENT, result.status());
        }
    }

    @Test 
    void shouldNotMarkMoreRepeatedLettersThanSecretContains() {
        List<LetterResult> results = 
            evaluator.evaluate("CASAS", "SAAAA");

        assertEquals(LetterStatus.PRESENT, results.get(0).status());
        assertEquals(LetterStatus.CORRECT, results.get(1).status());
        assertEquals(LetterStatus.ABSENT, results.get(2).status());
        assertEquals(LetterStatus.CORRECT, results.get(3).status());
        assertEquals(LetterStatus.ABSENT, results.get(4).status());
    }
}
