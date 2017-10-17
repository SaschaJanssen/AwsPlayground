package com.rdk.rps.game;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.rdk.rps.game.Figure.*;
import static org.junit.Assert.assertEquals;

/**
 *
 */
public class FigureTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
    }

    @Test
    public void should_be_drawn_if_both_enter_the_same_figure() {
        assertEquals(ROCK, ROCK.compete(ROCK));
        assertEquals(PAPER, PAPER.compete(PAPER));
        assertEquals(SCISSORS, SCISSORS.compete(SCISSORS));
        assertEquals(LIZARD, LIZARD.compete(LIZARD));
        assertEquals(SPOCK, SPOCK.compete(SPOCK));
    }

    @Test
    public void scissors_should_cut_paper() {
        assertEquals(SCISSORS, SCISSORS.compete(PAPER));
        assertEquals(SCISSORS, PAPER.compete(SCISSORS));
    }

    @Test
    public void paper_should_cover_rock() {
        assertEquals(PAPER, PAPER.compete(ROCK));
        assertEquals(PAPER, ROCK.compete(PAPER));
    }

    @Test
    public void rock_should_crush_lizard() {
        assertEquals(ROCK, ROCK.compete(LIZARD));
        assertEquals(ROCK, LIZARD.compete(ROCK));
    }

    @Test
    public void lizard_should_poison_spock() {
        assertEquals(LIZARD, LIZARD.compete(SPOCK));
        assertEquals(LIZARD, SPOCK.compete(LIZARD));
    }

    @Test
    public void spock_should_smash_scissors() {
        assertEquals(SPOCK, SPOCK.compete(SCISSORS));
        assertEquals(SPOCK, SCISSORS.compete(SPOCK));
    }

    @Test
    public void scissors_should_decapitate_lizard() {
        assertEquals(SCISSORS, SCISSORS.compete(LIZARD));
        assertEquals(SCISSORS, LIZARD.compete(SCISSORS));
    }

    @Test
    public void lizard_should_eat_paper() {
        assertEquals(LIZARD, LIZARD.compete(PAPER));
        assertEquals(LIZARD, PAPER.compete(LIZARD));
    }

    @Test
    public void paper_should_disprove_spock() {
        assertEquals(PAPER, PAPER.compete(SPOCK));
        assertEquals(PAPER, SPOCK.compete(PAPER));
    }

    @Test
    public void spock_should_vaporize_rock() {
        assertEquals(SPOCK, SPOCK.compete(ROCK));
        assertEquals(SPOCK, ROCK.compete(SPOCK));
    }

    @Test
    public void rock_should_crush_scissors() {
        assertEquals(ROCK, ROCK.compete(SCISSORS));
        assertEquals(ROCK, SCISSORS.compete(ROCK));
    }


    @Test
    public void should_throw_iae_on_empty_string_input() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The attack figure string should not be empty");
        Figure.parseAttackFigureInput("");
    }

    @Test
    public void should_throw_npe_if_attack_string_is_not_valid() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("FOO is not a valid attack figure, choose from ROCK, PAPER, SCISSORS, LIZARD, SPOCK");
        Figure.parseAttackFigureInput("FOO");
    }

    @Test
    public void should_parse_input_string_figure_to_enum() throws Exception {
        Figure result = Figure.parseAttackFigureInput("SCISSORS");
        assertEquals(SCISSORS, result);
    }
}
