package org.tambola.Factory;

import org.tambola.Exceptions.InvalidGamePatternException;
import org.tambola.GamePattern.*;

public class GamePatternFactory {
    public GamePatternStrategy getGamePatternStrategy(String gamePattern) {
        switch (gamePattern.toLowerCase()) {
            case "top row":
                return new TopRowPatternStrategy();
            case "middle row":
                return new MiddleRowPatternStrategy();
            case "bottom row":
                return new BottomRowPatternStrategy();
            case "full house":
                return new FullHouseStrategy();
            case "early five":
                return new EarlyFiveStrategy();
            default:
                throw new InvalidGamePatternException("Sorry! The Game Pattern provided doesnt exist");
        }
    }
}
