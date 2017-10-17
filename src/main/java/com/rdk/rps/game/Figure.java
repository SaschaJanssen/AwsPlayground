package com.rdk.rps.game;

import com.google.common.base.Preconditions;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

/**
 * Rock Paper Scissors Lizard Spock figures rule implementation
 */
public enum Figure {
    ROCK {
        @Override
        public Figure compete(Figure against) {

            if (LIZARD.equals(against) || SCISSORS.equals(against) || this.equals(against)) {
                return this;
            }

            return against.compete(this);
        }
    }, PAPER {
        @Override
        public Figure compete(Figure against) {
            if (SPOCK.equals(against) || ROCK.equals(against) || this.equals(against)) {
                return this;
            }

            return against.compete(this);
        }
    }, SCISSORS {
        @Override
        public Figure compete(Figure against) {
            if (LIZARD.equals(against) || PAPER.equals(against) || this.equals(against)) {
                return this;
            }

            return against.compete(this);
        }
    }, LIZARD {
        @Override
        public Figure compete(Figure against) {
            if (PAPER.equals(against) || SPOCK.equals(against) || this.equals(against)) {
                return this;
            }

            return against.compete(this);
        }
    }, SPOCK {
        @Override
        public Figure compete(Figure against) {
            if (ROCK.equals(against) || SCISSORS.equals(against) || this.equals(against)) {
                return this;
            }

            return against.compete(this);
        }
    };


    public static Figure parseAttackFigureInput(String value) {
        Preconditions.checkArgument(isNotEmpty(value), "The attack figure string should not be empty");

        try {
            return valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            String possibleAttacks = Stream.of(Figure.values()).map(i -> i.name()).collect(Collectors.joining(", "));
            throw new IllegalArgumentException(value + " is not a valid attack figure, choose from " + possibleAttacks, e);
        }

    }

    public abstract Figure compete(Figure against);

}
