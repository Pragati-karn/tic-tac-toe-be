package org.learnings.controller;

import org.learnings.criteria.PlayersRequest;
import org.learnings.handler.PlayerHandler;
import org.learnings.criteria.PlayerCriteria;
import org.learnings.utils.ScoreCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.learnings.utils.GameConstants.*;

@RestController
public class PlayerController{

@Autowired
PlayerHandler playerHandler;

    @PostMapping("/submitPlayer")
    public void submitPlayer(@RequestBody PlayersRequest playersRequest){

        playerHandler.onBoardPlayers(playersRequest);

    }

    @GetMapping("/scoreCard")
    public ScoreCard scoreCard() {

        return new ScoreCard(
                INITIAL_NO_OF_MATCHES,
                WINS_BY_PLAYER0,
                WINS_BY_PLAYER1
        );

    }

}
