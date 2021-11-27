package com.example.tictactoe.Bean;

public enum Symbol {
    X(-1),
    O(1);

    private final int val;

    Symbol(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
