package org.learnings.utils;

import org.learnings.criteria.PlayerCriteria;
import java.util.Arrays;

import static org.learnings.utils.GameConstants.INITIAL_WINS;

public class Player extends PlayerCriteria {

    private final Integer[] rows = new Integer[3];
    private final Integer[] columns = new Integer[3];

    public Player(String name, String age) {
        super(name, age);
        Arrays.fill(rows, 0);
        Arrays.fill(columns, 0);
    }


    public Integer noOfWins = INITIAL_WINS;



    public Integer[] getRows() {
        return rows;
    }

    public Integer[] getColumns() {
        return columns;
    }

    public void setRow(Integer row) {

      this.rows[row]++;

    }

    public void setColumn(Integer column) {

       this.columns[column]++;

    }

    public void undoRow(Integer row){

        this.rows[row]--;

    }

    public void  undoColumn(Integer column){

        this.columns[column]--;

    }

    public void clearRows(){

        Arrays.fill(rows, 0);

    }

    public void clearColumns(){

        Arrays.fill(columns, 0);

    }


}
