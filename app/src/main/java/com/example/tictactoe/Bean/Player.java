package com.example.tictactoe.Bean;

public class Player {
    private Symbol playerPiece;

    public Player(Symbol playerPiece) {
        this.playerPiece = playerPiece;
    }

    public Symbol getPlayerPiece() {
        return playerPiece;
    }

    public void setPlayerPiece(Symbol playerPiece) {
        this.playerPiece = playerPiece;
    }
}
