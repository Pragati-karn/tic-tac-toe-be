package org.learnings.controller;


import org.learnings.criteria.MoveCriteria;
import org.learnings.handler.BoardHandler;
import org.learnings.handler.PlayerHandler;
import org.learnings.utils.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.learnings.utils.GameConstants.*;

@RestController
public class BoardController {

@Autowired
private BoardHandler boardHandler;

@Autowired
private PlayerHandler playerHandler;

    @GetMapping("/getBoard")
    public Board getBoard() {

        return boardHandler.setBoardToInitialState();

    }

    @PostMapping("/writeValue")
    public Board writeValue(@RequestBody MoveCriteria moveCriteria) throws Exception {

        return boardHandler.writeValue(moveCriteria);
    }

    @PostMapping("/winner")
    public String getWinner(){

        if(playerHandler.checkWinner(0)){
            INITIAL_NO_OF_MATCHES++;
            WINS_BY_PLAYER0++;
            return "0";
        }
        else if(playerHandler.checkWinner(1)){
            INITIAL_NO_OF_MATCHES++;
            WINS_BY_PLAYER1++;
            return "1";
        }

        return "";

    }

    @PostMapping("/undoMove")
    public Board undoMove() throws Exception {

        return boardHandler.undoMove();
    }
}
