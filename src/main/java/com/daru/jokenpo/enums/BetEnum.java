package com.daru.jokenpo.enums;

import java.util.Arrays;
import java.util.List;

public enum BetEnum {
    ROCK, PAPER, SCISSORS, LIZARD, SPOCK;

    public List<BetEnum> losesTo;

    public boolean losesTo(BetEnum betEnum){
        return losesTo.contains(betEnum);
    }

    static {
        PAPER.losesTo = Arrays.asList(SCISSORS, LIZARD);
        SCISSORS.losesTo = Arrays.asList(ROCK, SPOCK);
        ROCK.losesTo = Arrays.asList(PAPER, SPOCK);
        LIZARD.losesTo = Arrays.asList(SCISSORS, ROCK);
        SPOCK.losesTo = Arrays.asList(PAPER, LIZARD);
    }
}
