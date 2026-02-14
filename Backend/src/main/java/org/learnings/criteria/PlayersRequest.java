package org.learnings.criteria;

public class PlayersRequest {

    private PlayerCriteria player1;
    private PlayerCriteria player2;

    public PlayersRequest() { }

    public PlayerCriteria getPlayer1() {
        return player1;
    }

    public void setPlayer1(PlayerCriteria player1) {
        this.player1 = player1;
    }

    public PlayerCriteria getPlayer2() {
        return player2;
    }

    public void setPlayer2(PlayerCriteria player2) {
        this.player2 = player2;
    }
}
