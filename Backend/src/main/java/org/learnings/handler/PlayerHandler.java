package org.learnings.handler;

import jdk.javadoc.doclet.Reporter;
import org.learnings.criteria.MoveCriteria;
import org.learnings.criteria.PlayersRequest;
import org.learnings.utils.Board;
import org.learnings.criteria.PlayerCriteria;
import org.learnings.utils.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Stack;

import static org.learnings.utils.GameConstants.*;
import static org.learnings.utils.GameConstants.INITIAL_VALUE;
import static org.learnings.utils.GameConstants.WINS_BY_PLAYER0;
import static org.learnings.utils.GameConstants.WINS_BY_PLAYER1;


@Service
public class PlayerHandler {

@Autowired
Board board;

    public Player player1;
    public Player player2;

    public final Stack<MoveCriteria> st = new Stack<>();

    public void onBoardPlayers(PlayersRequest playersRequest) {

        PlayerCriteria p1 = playersRequest.getPlayer1();
        PlayerCriteria p2 = playersRequest.getPlayer2();

        this.player1 = new Player(p1.getName(), p1.getAge());
        this.player2 = new Player(p2.getName(), p2.getAge());

        board.setTurn(0);
        INITIAL_NO_OF_MATCHES = INITIAL_VALUE;
        WINS_BY_PLAYER0 = INITIAL_VALUE;
        WINS_BY_PLAYER1 = INITIAL_VALUE;

    }


    public void addMove(MoveCriteria moveCriteria, Integer turn){

        if(turn == 0){

            player1.setRow(moveCriteria.getRow());
            player1.setColumn(moveCriteria.getColumn());

        }
        else{

            player2.setRow(moveCriteria.getRow());
            player2.setColumn(moveCriteria.getColumn());

        }

        st.push(moveCriteria);
        board.changeTurn();

    }

    public void undoMove(Integer turn){

        MoveCriteria moveCriteria = st.pop();
        board.changeTurn();

        if(turn == 0){

            player1.undoRow(moveCriteria.getRow());
            player1.undoColumn(moveCriteria.getColumn());

        }
        else{

            player2.undoRow(moveCriteria.getRow());
            player2.undoColumn(moveCriteria.getColumn());

        }

        board.undo(moveCriteria.getRow(), moveCriteria.getColumn());

    }

    public Boolean checkWinner(Integer turn){

        if(turn == 0){

            return checkRows(player1) || checkColumns(player1) || checkDiagonals(player1);

        }
        else {

            return checkRows(player2) || checkColumns(player2) || checkDiagonals(player2);

        }
    }

    private Boolean checkRows(Player player){

        return player.getRows()[0] == 3 ||  player.getRows()[1] == 3 || player.getRows()[2] == 3;

    }

    private Boolean checkColumns(Player player){

        return player.getColumns()[0] == 3 || player.getColumns()[1] == 3 || player.getColumns()[2] == 3;

    }

    private Boolean checkDiagonals(Player player){

        Character symbol = (player == player1) ? CROSS : ZERO;

        if (board.getValue(0,0) == symbol &&
                board.getValue(1,1) == symbol &&
                board.getValue(2,2) == symbol) {
            return true;
        }

        if (board.getValue(0,2) == symbol &&
                board.getValue(1,1) == symbol &&
                board.getValue(2,0) == symbol) {
            return true;
        }

        return false;
    }


    public void clearData(){

        if (player1 != null) {
            player1.clearRows();
            player1.clearColumns();
        }
        if (player2 != null) {
            player2.clearRows();
            player2.clearColumns();
        }


    }

}
