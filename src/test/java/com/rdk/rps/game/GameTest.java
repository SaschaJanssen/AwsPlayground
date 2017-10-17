package com.rdk.rps.game;

import com.rdk.rps.player.HumanPlayer;
import com.rdk.rps.player.Player;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 *
 */
public class GameTest {

    private Game game;

    private Player playerOne;
    private Player playerTwo;

    @Before
    public void setUp() {

        playerOne = new HumanPlayer("Sascha");
        playerTwo = new HumanPlayer("MrSpock");
    }

    @Test
    public void should_hold_empty_game() throws Exception {
        game = new Game(playerOne, playerTwo);
        assertThat(game.getNumberOfMatches(), equalTo(0));
        assertThat(game.getPlayerOne(), equalTo(playerOne));
        assertThat(game.getPlayerTwo(), equalTo(playerTwo));
    }

    @Test
    public void should_run_a_game_for_players() throws Exception {

        game = new Game(playerOne, playerTwo);

        Match matchResult = game.play(Figure.ROCK, Figure.PAPER);

        assertThat(matchResult, not(nullValue()));
        assertThat(game.getNumberOfMatches(), equalTo(1));
    }
}
