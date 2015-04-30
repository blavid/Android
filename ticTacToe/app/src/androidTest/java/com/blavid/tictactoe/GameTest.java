package com.blavid.tictactoe;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.Assert;

/**
 * Created by blake on 4/26/2015.
 */
public class GameTest extends AndroidTestCase {
    private Game game;

    @Override
    protected void setUp() {
        game = new Game();
    }

    @SmallTest
    public void testCheckForWinner_playerVertical() {
        game.clearBoard();
        // SET UP BOARD:
        // X . .
        // X O O
        // X . .
        Assert.assertEquals(Game.Player.NOBODY, game.checkForWinner());
        game._board[0][0] = Game.Player.PLAYER;
        Assert.assertEquals(Game.Player.NOBODY, game.checkForWinner());
        game._board[1][1] = Game.Player.COMPUTER;
        Assert.assertEquals(Game.Player.NOBODY, game.checkForWinner());
        game._board[1][0] = Game.Player.PLAYER;
        Assert.assertEquals(Game.Player.NOBODY, game.checkForWinner());
        game._board[1][2] = Game.Player.COMPUTER;
        Assert.assertEquals(Game.Player.NOBODY, game.checkForWinner());
        game._board[2][0] = Game.Player.PLAYER;
        Assert.assertEquals(Game.Player.PLAYER, game.checkForWinner());
    }

    @SmallTest
    public void testCheckForWinner_playerHorizontal() {
        game.clearBoard();
        // SET UP BOARD:
        // X X X
        // . O O
        // . . .
        Assert.assertEquals(Game.Player.NOBODY, game.checkForWinner());
        game._board[0][0] = Game.Player.PLAYER;
        Assert.assertEquals(Game.Player.NOBODY, game.checkForWinner());
        game._board[1][1] = Game.Player.COMPUTER;
        Assert.assertEquals(Game.Player.NOBODY, game.checkForWinner());
        game._board[0][1] = Game.Player.PLAYER;
        Assert.assertEquals(Game.Player.NOBODY, game.checkForWinner());
        game._board[1][2] = Game.Player.COMPUTER;
        Assert.assertEquals(Game.Player.NOBODY, game.checkForWinner());
        game._board[0][2] = Game.Player.PLAYER;
        Assert.assertEquals(Game.Player.PLAYER, game.checkForWinner());
    }

    @SmallTest
    public void testCheckForWinner_playerDiagonal() {
        game.clearBoard();
        // SET UP BOARD:
        // X . .
        // O X O
        // O . X
        Assert.assertEquals(Game.Player.NOBODY, game.checkForWinner());
        game._board[0][0] = Game.Player.PLAYER;
        Assert.assertEquals(Game.Player.NOBODY, game.checkForWinner());
        game._board[1][0] = Game.Player.COMPUTER;
        Assert.assertEquals(Game.Player.NOBODY, game.checkForWinner());
        game._board[1][1] = Game.Player.PLAYER;
        Assert.assertEquals(Game.Player.NOBODY, game.checkForWinner());
        game._board[1][2] = Game.Player.COMPUTER;
        Assert.assertEquals(Game.Player.NOBODY, game.checkForWinner());
        game._board[2][2] = Game.Player.PLAYER;
        Assert.assertEquals(Game.Player.PLAYER, game.checkForWinner());
    }
}
