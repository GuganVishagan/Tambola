package org.tambola.GamePattern;

import org.tambola.Model.Ticket;

import java.util.List;

public interface GamePatternStrategy {
    boolean isGameWinner(Ticket ticket, List<Integer> announcedNumbers);
}
