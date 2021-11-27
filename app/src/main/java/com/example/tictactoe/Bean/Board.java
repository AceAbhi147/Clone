package com.example.tictactoe.Bean;

public class Board {
    private Symbol[][] board;
    private int[] columnSum;
    private int[] rowSum;
    private int diagSum;
    private int secDiagSum;
    private int currEmptyCells;
    private int size;

    public Board(int size) {
        this.size = size;
        this.initializeBoard();
    }

    public Symbol[][] getBoard() {
        return board;
    }

    public void setBoard(Symbol[][] board) {
        this.board = board;
    }

    public int[] getColumnSum() {
        return columnSum;
    }

    public void setColumnSum(int[] columnSum) {
        this.columnSum = columnSum;
    }

    public int[] getRowSum() {
        return rowSum;
    }

    public void setRowSum(int[] rowSum) {
        this.rowSum = rowSum;
    }

    public int getDiagSum() {
        return diagSum;
    }

    public void setDiagSum(int diagSum) {
        this.diagSum = diagSum;
    }

    public int getSecDiagSum() {
        return secDiagSum;
    }

    public void setSecDiagSum(int secDiagSum) {
        this.secDiagSum = secDiagSum;
    }

    public int getCurrEmptyCells() {
        return currEmptyCells;
    }

    public void setCurrEmptyCells(int currEmptyCells) {
        this.currEmptyCells = currEmptyCells;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private void initializeBoard() {
        this.board = new Symbol[this.size][this.size];
        this.columnSum = new int[this.size];
        this.rowSum = new int[this.size];
        this.diagSum = 0;
        this.secDiagSum = 0;
        this.currEmptyCells = this.size * this.size;
    }

    public boolean markValueAndCheckWinner(int r, int c, Symbol symbol) {
        if(this.board[r][c] != null) {
            throw new IllegalArgumentException();
        }

        this.board[r][c] = symbol;
        this.columnSum[c] += symbol.getVal();
        this.rowSum[r] += symbol.getVal();

        if(r == c)
            this.diagSum += symbol.getVal();
        if(r + c == this.size - 1)
            this.secDiagSum += symbol.getVal();

        --this.currEmptyCells;
        return playerWon(r, c);
    }

    private boolean playerWon(int r, int c) {
        return Math.abs(this.columnSum[c]) == 3 || Math.abs(this.rowSum[r]) == 3
                || Math.abs(diagSum) == 3 || Math.abs(secDiagSum) == 3;
    }
}
