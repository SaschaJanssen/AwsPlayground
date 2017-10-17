package com.rdk.rps.game;

import java.util.Objects;

/**
 *
 */
public class Match {

    private final Figure playerOneFigure;
    private final Figure playerTwofigure;
    private final Figure winnerFigure;

    public Match(Figure playerOneFigure, Figure playerTwofigure, Figure winnerFigure) {
        this.playerOneFigure = playerOneFigure;
        this.playerTwofigure = playerTwofigure;
        this.winnerFigure = winnerFigure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return playerOneFigure == match.playerOneFigure &&
                playerTwofigure == match.playerTwofigure &&
                winnerFigure == match.winnerFigure;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerOneFigure, playerTwofigure, winnerFigure);
    }

    @Override
    public String toString() {
        return "Match{" +
                "playerOneFigure=" + playerOneFigure +
                ", playerTwofigure=" + playerTwofigure +
                ", winnerFigure=" + winnerFigure +
                '}';
    }
}
