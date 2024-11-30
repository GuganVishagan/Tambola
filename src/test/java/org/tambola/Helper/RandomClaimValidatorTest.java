package org.tambola.Helper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class RandomClaimValidatorTest {

    /**
     * Test case to verify a valid Winner Claim
     */
    @Test
    public void testIsWinnerValidClaim() {
        RandomClaimValidator validator = new RandomClaimValidator();

        // Sample Tambola ticket
        String[][] tambolaTicket = {
                {"4", "16", "_", "48", "_"},
                {"7", "_", "23", "_", "80"},
                {"9", "_", "25", "56", "83"}
        };

        // Sample announced numbers
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 80, 9, 23);

        // Game count factor ( EARLY FIVE )
        int gameCountFactor = 5;

        // Validate
        boolean isWinner = validator.isWinner(tambolaTicket, announcedNumbers, gameCountFactor);

        // Assert
        assertTrue(isWinner, "Expected to be a winner with valid claim");
    }

    /**
     * Test case to verify a Winner Claim but fails as the announced numbers don't
     * match the given ticket condition.
     */
    @Test
    public void testIsWinnerInvalidClaimDueToMissingNumbers() {
        RandomClaimValidator validator = new RandomClaimValidator();

        // Sample Tambola ticket
        String[][] tambolaTicket = {
                {"4", "16", "_", "48", "_"},
                {"7", "_", "23", "_", "80"},
                {"9", "_", "25", "56", "83"}
        };

        // Sample announced numbers missing required numbers
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 80);

        // Game count factor ( EARLY FIVE )
        int gameCountFactor = 5;

        // Validate
        boolean isWinner = validator.isWinner(tambolaTicket, announcedNumbers, gameCountFactor);

        // Assert
        assertFalse(isWinner, "Expected not to be a winner due to missing required numbers");
    }

    /**
     * Test case to verify a Winner Claim but fails as the last announced numbers don't
     * match the given ticket condition and its not called at the earliest.
     */
    @Test
    public void testIsWinnerLastNumberNotMatching() {
        RandomClaimValidator validator = new RandomClaimValidator();

        // Sample Tambola ticket
        String[][] tambolaTicket = {
                {"4", "16", "_", "48", "_"},
                {"7", "_", "23", "_", "80"},
                {"9", "_", "25", "56", "83"}
        };

        // Sample announced numbers with the last number not on the ticket
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 80, 9, 233);

        // Game count factor matches valid numbers
        int gameCountFactor = 5;

        // Validate
        boolean isWinner = validator.isWinner(tambolaTicket, announcedNumbers, gameCountFactor);

        // Assert
        assertFalse(isWinner, "Expected not to be a winner because the last number does not match the ticket");
    }
}
