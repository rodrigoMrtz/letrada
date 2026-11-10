package br.com.letrada.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class GameTest {

    //TODO: Implement unit tests for the Game class to ensure proper functionality and behavior.
    @Test
    void shouldStartGameInProgress() {
        // Implement test logic to verify that a new game starts with the status IN_PROGRESS.
        Game game = new Game("CASAS");

        assertEquals(GameStatus.IN_PROGRESS, game.getStatus());
        assertTrue(game.getAttempts().isEmpty());
    }

    @Test 
    void shouldFinishGameWhenPlayerWins() {
        // Implement test logic to verify that the game status changes to WON when the player guesses the secret word correctly.
        Game game = new Game("CASAS");

        game.addAttempt(List.of());
        game.finishAttempt("CASAS", "CASAS");

        assertEquals(GameStatus.WON, game.getStatus());
    }

    @Test 
    void shouldFinishGameWhenPlayerUsesAllAttempts() {
        // Implement test logic to verify that the game status changes to LOST when the player uses all attempts without guessing the secret word.
        Game game = new Game("CASAS");

        for(int i = 0; i < Game.MAX_ATTEMPTS; i++) {
            game.addAttempt(List.of());
            game.finishAttempt("CASAS", "MUNDO");
        }

        assertEquals(GameStatus.LOST, game.getStatus());
    }

    @Test 
    void shouldNotAllowMoreThanSixAttempts() {
        // Implement test logic to verify that the game does not allow more than six attempts.
        Game game = new Game("CASAS");

        for (int i = 0; i < Game.MAX_ATTEMPTS; i++) {
            game.addAttempt(List.of());
        }

        assertThrows(IllegalStateException.class, 
            () ->  game.addAttempt(List.of())
        );
    }

    @Test 
    void shouldNotAllowAttemptsAfterGameIsFinished() {
        // Implement test logic to verify that no more attempts can be added after the game has been finished (either WON or LOST).
        Game game = new Game("CASAS");

        game.addAttempt(List.of());
        game.finishAttempt("CASAS", "CASAS");

        assertThrows(IllegalStateException.class,
            () -> game.addAttempt(List.of())
        );
    }
}