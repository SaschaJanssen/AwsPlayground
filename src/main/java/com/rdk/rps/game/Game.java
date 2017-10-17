package com.rdk.rps.game;

import com.rdk.rps.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class Game {

    private static final Logger LOG = LoggerFactory.getLogger(Game.class);

    private final Player playerOne;
    private final Player playerTwo;

    private List<Match> matches;

    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.matches = new ArrayList<>();
    }

    public int getNumberOfMatches() {
        return matches.size();
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Match play(Figure figurePlayerOne, Figure figurePlayerTwo) {

        Figure result = figurePlayerOne.compete(figurePlayerTwo);

        LOG.info("player one picked [{}], player two picked [{}], winner [{}]", figurePlayerOne, figurePlayerTwo, result);

        Match match = new Match(figurePlayerOne, figurePlayerTwo, result);

        matches.add(match);

        return match;

    }
}
