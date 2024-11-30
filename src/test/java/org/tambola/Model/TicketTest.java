package org.tambola.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tambola.Exceptions.IncorrectTicketNumberDimensions;
import org.tambola.Exceptions.InvalidTicketNumbersException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicketTest {

    // Instance of the Ticket class being tested
    private Ticket ticket;

    @BeforeEach
    public void setUp() {
        // Initialize a Ticket object with 1 ticket, 3 rows, and 9 columns
        ticket = new Ticket(1, 3, 9);
    }

    /**
     * Test case to ensure that an exception is thrown when null is passed to the setTicket method.
     */
    @Test
    void setTicketThrowsException() {
        // Passing null as ticket numbers
        List<String> ticketNumbers = null;

        // Expecting InvalidTicketNumbersException to be thrown
        assertThrows(InvalidTicketNumbersException.class, () -> ticket.setTicket(ticketNumbers));
    }

    /**
     * Test case to validate that the Ticket constructor initializes a ticket
     * with the correct dimensions (rows and columns).
     */
    @Test
    void testConstructorInitializesTicketWithCorrectSize() {
        // Retrieve the ticket array
        String[][] ticketArray = ticket.getTicket();

        // Assert the number of rows and columns
        assertEquals(3, ticketArray.length); // 3 rows
        assertEquals(9, ticketArray[0].length); // 9 columns in each row
    }

    /**
     * Test case to verify that the setTicket method correctly sets ticket numbers
     * when the input list has valid dimensions.
     */
    @Test
    void testSetTicketSuccessfullySetsTicketNumbers() {
        // Create a list of valid ticket numbers
        List<String> ticketNumbers = new ArrayList<>();

        // Populate the ticket numbers
        Collections.addAll(ticketNumbers,
                "4", "16", "_", "_", "48", "_", "63", "76", "_",
                "7", "_", "23", "38", "_", "52", "_", "_", "80",
                "9", "_", "25", "_", "_", "56", "64", "_", "_");

        // Call setTicket with the valid ticket numbers
        ticket.setTicket(ticketNumbers);

        // No exception should be thrown, implying successful execution
    }

    /**
     * Test case to ensure that an exception is thrown when the ticket numbers list
     * does not match the expected dimensions of the ticket.
     */
    @Test
    void testSetTicketThrowsExceptionForIncorrectTicketNumbers() {
        // Create an invalid list of ticket numbers with incorrect size
        List<String> ticketNumbers = new ArrayList<>();

        // Populate the ticket numbers (less than the required count for 3x9 ticket)
        Collections.addAll(ticketNumbers,
                "4", "16", "_", "_", "48", "_", "63", "76", "_",
                "7", "_", "23", "38", "_", "52", "_", "_");

        // Expecting IncorrectTicketNumberDimensions exception to be thrown
        assertThrows(IncorrectTicketNumberDimensions.class, () -> ticket.setTicket(ticketNumbers));
    }
}
