package org.tambola.Factory;

import org.junit.jupiter.api.Test;
import org.tambola.Exceptions.InvalidGamePatternException;
import org.tambola.GamePattern.*;

import static org.junit.jupiter.api.Assertions.*;

public class GamePatternFactoryTest {

    @Test
    public void testValidGamePatternTopRow() {
        GamePatternFactory factory = new GamePatternFactory();
        GamePatternStrategy strategy = factory.getGamePatternStrategy("top row");

        assertNotNull(strategy, "Expected a non-null strategy for 'top row'");
        assertTrue(strategy instanceof TopRowPatternStrategy, "Expected strategy to be an instance of TopRowPatternStrategy");
    }

    @Test
    public void testValidGamePatternMiddleRow() {
        GamePatternFactory factory = new GamePatternFactory();
        GamePatternStrategy strategy = factory.getGamePatternStrategy("middle row");

        assertNotNull(strategy, "Expected a non-null strategy for 'middle row'");
        assertTrue(strategy instanceof MiddleRowPatternStrategy, "Expected strategy to be an instance of MiddleRowPatternStrategy");
    }

    @Test
    public void testValidGamePatternBottomRow() {
        GamePatternFactory factory = new GamePatternFactory();
        GamePatternStrategy strategy = factory.getGamePatternStrategy("bottom row");

        assertNotNull(strategy, "Expected a non-null strategy for 'bottom row'");
        assertTrue(strategy instanceof BottomRowPatternStrategy, "Expected strategy to be an instance of BottomRowPatternStrategy");
    }

    @Test
    public void testValidGamePatternFullHouse() {
        GamePatternFactory factory = new GamePatternFactory();
        GamePatternStrategy strategy = factory.getGamePatternStrategy("full house");

        assertNotNull(strategy, "Expected a non-null strategy for 'full house'");
        assertTrue(strategy instanceof FullHouseStrategy, "Expected strategy to be an instance of FullHouseStrategy");
    }

    @Test
    public void testValidGamePatternEarlyFive() {
        GamePatternFactory factory = new GamePatternFactory();
        GamePatternStrategy strategy = factory.getGamePatternStrategy("early five");

        assertNotNull(strategy, "Expected a non-null strategy for 'early five'");
        assertTrue(strategy instanceof EarlyFiveStrategy, "Expected strategy to be an instance of EarlyFiveStrategy");
    }

    @Test
    public void testInvalidGamePattern() {
        GamePatternFactory factory = new GamePatternFactory();

        Exception exception = assertThrows(InvalidGamePatternException.class, () -> {
            factory.getGamePatternStrategy("invalid pattern");
        });

        String expectedMessage = "Sorry! The Game Pattern provided doesnt exist";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage, "Expected exception message to match");
    }
}
