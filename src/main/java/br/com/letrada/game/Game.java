package br.com.letrada.game;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public final static int MAX_ATTEMPTS = 6;
    private final String secretWord;
    private final List<List<LetterResult>> attempts;
    private GameStatus status;
    
    public Game(String secretWord) {
        this.secretWord = secretWord;
        this.attempts = new ArrayList<>();
        this.status = GameStatus.IN_PROGRESS;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public List<List<LetterResult>> getAttempts() {
        return attempts;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void addAttempt(List<LetterResult> attempt) {
        if(attempts.size() >= MAX_ATTEMPTS) {
            throw new IllegalStateException(
                "O limite de tentativas foi atingido."
            );
        }

        if (status != GameStatus.IN_PROGRESS) {
            throw new IllegalStateException(
                "O jogo já foi encerrado."
            );
        }

        attempts.add(attempt);
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public void finishAttempt(String secretWord, String guess) {
        if (guess.equals(secretWord)) {
            status = GameStatus.WON;
            return;
        } 

        if (attempts.size() >= MAX_ATTEMPTS) {
            status = GameStatus.LOST;
            return;
        }
    }
}
