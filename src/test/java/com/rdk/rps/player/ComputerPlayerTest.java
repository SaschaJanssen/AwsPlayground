package com.rdk.rps.player;

import com.rdk.rps.game.Figure;
import org.junit.Test;

import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class ComputerPlayerTest {

    @Test
    public void should_pick_random_figure() throws Exception {
        Figure randomFigure = ComputerPlayer.ComputerPlayerRandomizer.getRandomFigure();
        assertThat(randomFigure, isIn(Figure.values()));
    }
}