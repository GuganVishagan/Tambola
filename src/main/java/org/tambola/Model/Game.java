package org.tambola.Model;

import org.tambola.Exceptions.InvalidGamePatternException;
import org.tambola.Exceptions.InvalidNumbersAnnouncedException;
import org.tambola.Factory.GamePatternFactory;
import org.tambola.GamePattern.GamePatternStrategy;

import java.util.List;

public class Game {
    private int gameId;
    private GamePatternStrategy gamePatternStrategy;
    public GamePatternFactory gamePatternFactory;


    public Game(int gameId, GamePatternFactory gamePatternFactory) {
        this.gameId = gameId;
        this.gamePatternFactory = gamePatternFactory;
    }

    public GamePatternStrategy getGamePattern() {
        return this.gamePatternStrategy;
    }

    public String isGameWinner(Ticket ticket, List<Integer> announcedNumbers, String gamePattern) {
        if(announcedNumbers == null || announcedNumbers.size() == 0)
            throw new InvalidNumbersAnnouncedException();
        if (gamePattern == null) throw new InvalidGamePatternException("Sorry! The Game Pattern provided doesn't exist");
        this.gamePatternStrategy = this.gamePatternFactory.getGamePatternStrategy(gamePattern);

        if(this.gamePatternStrategy.isGameWinner(ticket, announcedNumbers))
            return "Accepted";
        else
            return "Rejected";
    }
}
