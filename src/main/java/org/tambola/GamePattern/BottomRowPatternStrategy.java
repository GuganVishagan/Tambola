package org.tambola.GamePattern;

import org.tambola.Helper.RowClaimValidator;
import org.tambola.Helper.TicketClaimExtractor;
import org.tambola.Model.Ticket;

import java.util.List;

public class BottomRowPatternStrategy implements GamePatternStrategy {
    private RowClaimValidator rowClaimValidator = new RowClaimValidator();
    private TicketClaimExtractor ticketClaimExtractor = new TicketClaimExtractor();
    @Override
    public boolean isGameWinner(Ticket ticket, List<Integer> announcedNumbers) {
        String[][] tambolaTicket = ticketClaimExtractor.ticketExtractor(ticket);
        int bottomRow = tambolaTicket.length - 1;
        return rowClaimValidator.isWinner(tambolaTicket, announcedNumbers, bottomRow);
    }
}
