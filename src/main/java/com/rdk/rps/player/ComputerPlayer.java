package com.rdk.rps.player;

import com.rdk.rps.game.Figure;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 *
 */
@Service
public class ComputerPlayer implements Player {

    @Override
    public String getName() {
        return "Skynet";
    }


    public static class ComputerPlayerRandomizer {
        private static Random random = new Random();
        private static Figure[] figures = Figure.values();

        public static Figure getRandomFigure() {
            int pick = random.nextInt(Figure.values().length);
            return figures[pick];
        }
    }

}
