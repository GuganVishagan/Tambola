package org.tambola.GamePattern;


import org.tambola.Exceptions.InvalidNumbersAnnouncedException;
import org.tambola.Exceptions.NoTicketCreatedException;
import org.tambola.Helper.RowClaimValidator;
import org.tambola.Helper.TicketClaimExtractor;
import org.tambola.Model.Ticket;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MiddleRowPatternStrategy implements GamePatternStrategy {
    private TicketClaimExtractor ticketClaimExtractor = new TicketClaimExtractor();
    private RowClaimValidator rowClaimValidator = new RowClaimValidator();
    @Override
    public boolean isGameWinner(Ticket ticket, List<Integer> announcedNumbers) {
        String[][] tambolaTicket = ticketClaimExtractor.ticketExtractor(ticket);
        int middleRow = tambolaTicket.length/2;
        return rowClaimValidator.isWinner(tambolaTicket, announcedNumbers, middleRow);
    }
}
