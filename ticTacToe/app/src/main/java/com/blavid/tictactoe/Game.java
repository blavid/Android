package com.blavid.tictactoe;

import android.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by blake on 4/26/2015.
 */
public class Game {
    public static final int BOARD_WIDTH = 3;
    public enum Player {
        PLAYER,
        COMPUTER,
        NOBODY
    }
    public enum DifficultyLevel {
        EASY,
        HARD,
        IMPOSSIBLE
    }
    public Player[][] _board;

    public Game() {
        _board = new Player[BOARD_WIDTH][BOARD_WIDTH];
        clearBoard();
    }

    public void clearBoard() {
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++)
                _board[i][j] = Player.NOBODY;
        }
    }

    protected void go(int x, int y, Player player) {
        _board[x][y] = player;
    }
    public Player checkForWinner() {
        for (int i = 0; i < BOARD_WIDTH; i++) {
            if (     ( _board[0][i] == Player.COMPUTER
                    && _board[1][i] == Player.COMPUTER
                    && _board[2][i] == Player.COMPUTER)
                   || (_board[i][0] == Player.COMPUTER
                    && _board[i][1] == Player.COMPUTER
                    && _board[i][2] == Player.COMPUTER)) {
                return Player.COMPUTER;
            }
            else if (( _board[0][i] == Player.PLAYER
                    && _board[1][i] == Player.PLAYER
                    && _board[2][i] == Player.PLAYER)
                   || (_board[i][0] == Player.PLAYER
                    && _board[i][1] == Player.PLAYER
                    && _board[i][2] == Player.PLAYER)) {
                return Player.PLAYER;
            }

        }
        if (( _board[0][0] == Player.COMPUTER
        && _board[1][1] == Player.COMPUTER
        && _board[2][2] == Player.COMPUTER)
    ||   ( _board[0][2] == Player.COMPUTER
        && _board[1][1] == Player.COMPUTER
        && _board[2][0] == Player.COMPUTER)) {
            return Player.COMPUTER;
        }
        else if (( _board[0][0] == Player.PLAYER
                && _board[1][1] == Player.PLAYER
                && _board[2][2] == Player.PLAYER)
            ||   ( _board[0][2] == Player.PLAYER
                && _board[1][1] == Player.PLAYER
                && _board[2][0] == Player.PLAYER)) {
            return Player.PLAYER;
        }
            return Player.NOBODY;
    }

    protected Pair<Integer, Integer> computerMove(DifficultyLevel level) {
        Pair<Integer, Integer> xy = null;
        // Make a list of available positions from which to choose
        Map<Integer, Pair<Integer, Integer>> availablePositions = new HashMap<>();
        int index = 0;
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if (_board[i][j] == Player.NOBODY) {
                    availablePositions.put(index++, new Pair<Integer, Integer>(i,j));
                }
            }
        }
        switch (level) {
            case EASY:
                int random = new Random().nextInt(availablePositions.size());
                xy = availablePositions.get(random);
                break;
            case HARD:
                break;
            case IMPOSSIBLE:
                break;
            default:
                break;
        }
        go(xy.first, xy.second, Player.COMPUTER);
        return xy;
    }
}
