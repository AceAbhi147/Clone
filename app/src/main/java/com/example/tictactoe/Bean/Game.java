package com.example.tictactoe.Bean;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Move[] movesList;
    private boolean isPlayer1Active;
    private int currMove;
    private Status status;

    public Game(Player player1, Player player2, boolean isPlayer1Active, int size) {
        this.board = new Board(size);
        this.player1 = player1;
        this.player2 = player2;
        this.movesList = new Move[size * size];
        this.isPlayer1Active = isPlayer1Active;
        this.currMove = 0;
        this.status = Status.UNDECIDED;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Move[] getMovesList() {
        return movesList;
    }

    public void setMovesList(Move[] movesList) {
        this.movesList = movesList;
    }

    public boolean isPlayer1Active() {
        return isPlayer1Active;
    }

    public void setPlayer1Active(boolean player1Active) {
        isPlayer1Active = player1Active;
    }

    public int getCurrMove() {
        return currMove;
    }

    public void setCurrMove(int currMove) {
        this.currMove = currMove;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Player getActivePlayer() {
        return this.isPlayer1Active ? player1 : player2;
    }

    public void makeMove(int r, int c) {
        boolean isWinner = getBoard().markValueAndCheckWinner(
                r, c, this.getActivePlayer().getPlayerPiece());
        this.isPlayer1Active = !this.isPlayer1Active;
        this.movesList[this.currMove++] = new Move(getActivePlayer(), r, c);

        if(isWinner)
            this.setStatus(getActivePlayer().getPlayerPiece() == Symbol.X
                    ? Status.PLAYER_X_WON : Status.PLAYER_O_WON);
        if(this.getBoard().getCurrEmptyCells() == 0)
            this.setStatus(Status.DRAW);
    }
}
