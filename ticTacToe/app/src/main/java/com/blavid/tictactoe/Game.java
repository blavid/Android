package com.blavid.tictactoe;

/**
 * Created by blake on 4/26/2015.
 */
public class Game {
    public Cell[][] _board;
    public static final int BOARD_WIDTH = 3;
    public enum winner {
        PLAYER,
        COMPUTER,
        NOBODY
    }

    public Game() {
        clearBoard();
    }

    public void clearBoard() {
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++)
            _board[i][j].clear();
        }
    }

    public winner checkForWinner() {
        return winner.NOBODY;
    }
}
