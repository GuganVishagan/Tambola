package org.tambola.Model;

import org.tambola.Exceptions.IncorrectTicketNumberDimensions;
import org.tambola.Exceptions.InvalidTicketNumbersException;

import java.util.List;

public class Ticket {
    private int ticketId;
    private String[][] ticket;

    public Ticket(int ticketId, int ticketRow, int ticketColumn) {
        this.ticketId = ticketId;
        this.ticket = new String[ticketRow][ticketColumn];
    }

    public String[][] getTicket() {
        return ticket;
    }

    public void setTicket(List<String> ticketNumbers) {
        if(ticketNumbers == null) throw new InvalidTicketNumbersException("Please provide valid ticket numbers");
        int row = this.ticket.length;
        int col = this.ticket[0].length;
        if(ticketNumbers.size() != row * col) throw new IncorrectTicketNumberDimensions("The ticket numbers should be of length exactly to" + " "+ row*col);
        int ticketNumbersIndex = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                this.ticket[i][j] = ticketNumbers.get(ticketNumbersIndex++);
            }
        }
    }
}
