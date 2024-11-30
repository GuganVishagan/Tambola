package org.tambola.Model;

import java.util.ArrayList;
import java.util.List;

public class Round {
    int roundId;
    List<Game> games;

    public Round(int roundId) {
        this.roundId = roundId;
        this.games = new ArrayList<>();
    }

    public int getRoundId() {
        return roundId;
    }

    public void setGame(Game game){
        this.games.add(game);
    }

    public List<Game> getAllGames(){
        return this.games;
    }
}
