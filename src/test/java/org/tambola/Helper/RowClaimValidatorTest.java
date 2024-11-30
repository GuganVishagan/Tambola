package org.tambola.Helper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class RowClaimValidatorTest {

    /**
     * Test case to verify a valid Winner Claim
     */
    @Test
    public void testIsWinnerValidClaim() {
        RowClaimValidator validator = new RowClaimValidator();

        // Sample Tambola ticket
        String[][] tambolaTicket = {
                {"4", "16", "_", "48", "_"},
                {"7", "23", "38", "52", "80"},
                {"9", "_", "25", "56", "83"}
        };

        // Announced numbers cover all non-empty cells in the specified row
        List<Integer> announcedNumbers = Arrays.asList(7, 23, 38, 52, 80);

        // Validate for row index 1 (middle row)
        boolean isWinner = validator.isWinner(tambolaTicket, announcedNumbers, 1);

        // Assert
        assertTrue(isWinner, "Expected to be a winner for the valid row claim");
    }

    /**
     * Test case to verify a Winner Claim but fails as the announced numbers don't
     * match the given ticket condition.
     */
    @Test
    public void testIsWinnerInvalidClaimDueToMissingNumbers() {
        RowClaimValidator validator = new RowClaimValidator();

        // Sample Tambola ticket
        String[][] tambolaTicket = {
                {"4", "16", "_", "48", "_"},
                {"7", "23", "38", "52", "80"},
                {"9", "_", "25", "56", "83"}
        };

        // Announced numbers are missing some required cells in the specified row
        List<Integer> announcedNumbers = Arrays.asList(7, 23, 38);

        // Validate for row index 1 (middle row)
        boolean isWinner = validator.isWinner(tambolaTicket, announcedNumbers, 1);

        // Assert
        assertFalse(isWinner, "Expected not to be a winner due to missing required numbers");
    }

    /**
     * Test case to verify a Winner Claim but fails as the last announced numbers don't
     * match the given ticket condition and its not called at the earliest.
     */
    @Test
    public void testIsWinnerInvalidClaimDueToLastNumberMismatch() {
        RowClaimValidator validator = new RowClaimValidator();

        // Sample Tambola ticket
        String[][] tambolaTicket = {
                {"4", "16", "_", "48", "_"},
                {"7", "23", "38", "52", "80"},
                {"9", "_", "25", "56", "83"}
        };

        // Announced numbers cover all required cells but the last number does not match any cell in the row
        List<Integer> announcedNumbers = Arrays.asList(7, 23, 38, 52, 80, 999);

        // Validate for row index 1 (middle row)
        boolean isWinner = validator.isWinner(tambolaTicket, announcedNumbers, 1);

        // Assert
        assertFalse(isWinner, "Expected not to be a winner because the last announced number does not match any cell in the row");
    }

    /**
     * Test case to verify a Winner Claim but throws an exception
     * as the row index is Invalid.
     */

    @Test
    public void testIsWinnerInvalidRowIndex() {
        RowClaimValidator validator = new RowClaimValidator();

        // Sample Tambola ticket
        String[][] tambolaTicket = {
                {"4", "16", "_", "48", "_"},
                {"7", "23", "38", "52", "80"},
                {"9", "_", "25", "56", "83"}
        };

        // Announced numbers
        List<Integer> announcedNumbers = Arrays.asList(7, 23, 38, 52, 80);

        // Validate for an invalid row index
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            validator.isWinner(tambolaTicket, announcedNumbers, 5);
        });

        // Assert
        assertNotNull(exception, "Expected an exception for invalid row index");
    }
}
