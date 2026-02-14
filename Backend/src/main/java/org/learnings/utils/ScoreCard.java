package org.learnings.utils;

public record ScoreCard(
        Integer totalMatches,
        Integer winsByPlayer0,
        Integer winsByPlayer1
) {}
