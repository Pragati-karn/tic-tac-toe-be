package org.learnings.utils;

import org.learnings.Interfaces.BoardGenerator;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.learnings.utils.GameConstants.COLUMN;
import static org.learnings.utils.GameConstants.ROW;


@Service
public class Board implements BoardGenerator {

    private int turn = 0;

    private final Character[][] board = new Character[ROW][COLUMN];

    @Override
    public Character[][] getBoard() {
        return board;
    }

    public void putValue(Character character, int r , int c){

        board[r][c] = character;

    }

    public void undo(Integer r,  Integer c){

        board[r][c] = null;

    }

    public void changeTurn(){

        turn = 1 - turn;

    }

    public Character getValue(Integer r, Integer c){
        return board[r][c];

    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public Integer getTurn() {
        return turn;
    }

    public void resetBoard(){

        IntStream.range(0, ROW).forEach(i -> Arrays.fill(board[i] , null));

    }
}
