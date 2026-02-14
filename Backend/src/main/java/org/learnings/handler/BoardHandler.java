package org.learnings.handler;

import org.learnings.Exceptions.InvalidMoveException;
import org.learnings.criteria.MoveCriteria;
import org.learnings.utils.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.learnings.utils.GameConstants.*;

@Service
public class BoardHandler {

    @Autowired
    private Board board;

    @Autowired
    private PlayerHandler playerHandler;

    public Board setBoardToInitialState() {

        board.resetBoard();
        playerHandler.clearData();
        board.setTurn(0);

        return board;
    }

    public Board writeValue(MoveCriteria moveCriteria) throws Exception {

        if(isMoveValidForAdd(moveCriteria)){

            if(board.getTurn() == 0){

                board.putValue(CROSS, moveCriteria.getRow(), moveCriteria.getColumn());

            }
            else {

                board.putValue(ZERO, moveCriteria.getRow(), moveCriteria.getColumn());

            }

            playerHandler.addMove(moveCriteria, board.getTurn());

            return board;

        }

        else throw new InvalidMoveException("Move is not valid");

    }

    private Boolean isMoveValidForAdd(MoveCriteria moveCriteria) {

        return board.getValue(moveCriteria.getRow(), moveCriteria.getColumn()) == null;

    }

    public Board undoMove() throws Exception {

        if(isMoveValidForUndo()){

            playerHandler.undoMove(board.getTurn());
            return board;

        }

        throw new Exception("Undo is not valid.");
    }

    private boolean isMoveValidForUndo() {

        return !playerHandler.st.isEmpty();

    }
}
