package org.tambola.GamePattern;

import org.tambola.Exceptions.InvalidNumbersAnnouncedException;
import org.tambola.Exceptions.NoTicketCreatedException;
import org.tambola.Helper.RandomClaimValidator;
import org.tambola.Helper.RowClaimValidator;
import org.tambola.Helper.TicketClaimExtractor;
import org.tambola.Model.Ticket;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EarlyFiveStrategy implements GamePatternStrategy {
    private TicketClaimExtractor ticketClaimExtractor = new TicketClaimExtractor();
    private RandomClaimValidator randomClaimValidator = new RandomClaimValidator();
    @Override
    public boolean isGameWinner(Ticket ticket, List<Integer> announcedNumbers) {
        String[][] tambolaTicket = ticketClaimExtractor.ticketExtractor(ticket);
        int gameCountFactor = 5;
        return randomClaimValidator.isWinner(tambolaTicket, announcedNumbers, gameCountFactor);

    }
}
