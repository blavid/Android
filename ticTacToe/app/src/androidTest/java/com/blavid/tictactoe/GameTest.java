package com.blavid.tictactoe;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.Assert;

/**
 * Created by blake on 4/26/2015.
 */
public class GameTest extends AndroidTestCase {

    @SmallTest
    public void testCheckForWinner() {
        Game game = new Game();
        game.clearBoard();
        // SET UP BOARD:
        // X . .
        // X O O
        // X . .
        Assert.assertEquals(game.checkForWinner(), Game.winner.NOBODY);
        game._board[0][0].click(Cell.XO.X);
        Assert.assertEquals(game.checkForWinner(), Game.winner.NOBODY);
        game._board[1][1].click(Cell.XO.O);
        Assert.assertEquals(game.checkForWinner(), Game.winner.NOBODY);
        game._board[1][0].click(Cell.XO.X);
        Assert.assertEquals(game.checkForWinner(), Game.winner.NOBODY);
        game._board[1][2].click(Cell.XO.O);
        Assert.assertEquals(game.checkForWinner(), Game.winner.NOBODY);
        game._board[2][0].click(Cell.XO.X);
        Assert.assertEquals(game.checkForWinner(), Game.winner.PLAYER);
    }
}
