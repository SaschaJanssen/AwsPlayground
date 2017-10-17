package com.rdk.rps.controller;

import com.rdk.rps.game.Figure;
import com.rdk.rps.game.Game;
import com.rdk.rps.game.Match;
import com.rdk.rps.player.ComputerPlayer;
import com.rdk.rps.player.HumanPlayer;
import com.rdk.rps.player.Player;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
public class GameController {

    private final Game game;

    public GameController() {
        Player playerOne = new HumanPlayer("Sascha");
        Player playerTwo = new ComputerPlayer();

        this.game = new Game(playerOne, playerTwo);
    }

    @RequestMapping("/play/{figure}")
    @ResponseBody
    public Match play(@PathVariable("figure") String figure) {
        Match currentMatch = game.play(Figure.parseAttackFigureInput(figure), ComputerPlayer.ComputerPlayerRandomizer.getRandomFigure());
        return currentMatch;
    }

}
