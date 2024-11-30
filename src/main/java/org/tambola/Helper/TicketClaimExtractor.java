package org.tambola.Helper;

import org.tambola.Exceptions.InvalidNumbersAnnouncedException;
import org.tambola.Exceptions.NoTicketCreatedException;
import org.tambola.Model.Ticket;

public class TicketClaimExtractor {

    public String[][] ticketExtractor(Ticket ticket) {
        if(ticket.getTicket() == null)
            throw new NoTicketCreatedException();
        String[][] tambolaTicket = ticket.getTicket();
        return tambolaTicket;
    }
}
