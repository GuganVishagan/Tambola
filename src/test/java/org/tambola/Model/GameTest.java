package org.tambola.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.tambola.Factory.GamePatternFactory;
import org.tambola.GamePattern.GamePatternStrategy;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    // Instance of the Game class being tested
    private Game game;

    // Mocked dependencies for GamePatternFactory and GamePatternStrategy
    @Mock
    private GamePatternFactory gamePatternFactory;

    @Mock
    private GamePatternStrategy gamePatternStrategy;

    @BeforeEach
    public void setUp() {
        // Initialize Mockito annotations for @Mock fields
        MockitoAnnotations.openMocks(this);

        // Create a Game instance with the mocked GamePatternFactory
        game = new Game(1, gamePatternFactory);
    }

    /**
     * Test case to verify the behavior when the game pattern strategy
     * determines the ticket is a winning ticket.
     */
    @Test
    void testisGameWinnerExpected() {
        // Mock input data
        Ticket ticket = new Ticket(1, 3, 9);
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 63, 76);
        String gamePattern = "Full House";

        // Mock behavior for factory and strategy
        Mockito.when(gamePatternFactory.getGamePatternStrategy(gamePattern)).thenReturn(gamePatternStrategy);
        Mockito.when(gamePatternStrategy.isGameWinner(ticket, announcedNumbers)).thenReturn(true);

        // Call the method under test
        String result = game.isGameWinner(ticket, announcedNumbers, gamePattern);

        // Assert the result
        assertEquals("Accepted", result);

        // Verify interactions with mocks
        Mockito.verify(gamePatternFactory).getGamePatternStrategy(gamePattern);
        Mockito.verify(gamePatternStrategy).isGameWinner(ticket, announcedNumbers);
    }

    /**
     * Test case to verify the behavior when the game pattern strategy
     * determines the ticket is not a winning ticket.
     */
    @Test
    void testisGameWinnerRejected() {
        // Mock input data
        Ticket ticket = new Ticket(1, 3, 9);
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 63, 76);
        String gamePattern = "Full House";

        // Mock behavior for factory and strategy
        Mockito.when(gamePatternFactory.getGamePatternStrategy(gamePattern)).thenReturn(gamePatternStrategy);
        Mockito.when(gamePatternStrategy.isGameWinner(ticket, announcedNumbers)).thenReturn(false);

        // Call the method under test
        String result = game.isGameWinner(ticket, announcedNumbers, gamePattern);

        // Assert the result
        assertEquals("Rejected", result);

        // Verify interactions with mocks
        Mockito.verify(gamePatternFactory).getGamePatternStrategy(gamePattern);
        Mockito.verify(gamePatternStrategy).isGameWinner(ticket, announcedNumbers);
    }

    /**
     * Test case to verify that the game pattern strategy is correctly set and retrieved.
     */
    @Test
    void testGamePattern() {
        // Assert that the initial game pattern is null
        assertEquals(null, game.getGamePattern());

        // Mock input data
        String gamePattern = "Full House";
        Mockito.when(gamePatternFactory.getGamePatternStrategy(gamePattern)).thenReturn(gamePatternStrategy);

        // Call the method to set the game pattern
        game.isGameWinner(new Ticket(1, 3, 9), Arrays.asList(4, 16, 48, 63, 76), gamePattern);

        // Assert that the game pattern strategy was set correctly
        assertEquals(gamePatternStrategy, game.getGamePattern());
    }
}
