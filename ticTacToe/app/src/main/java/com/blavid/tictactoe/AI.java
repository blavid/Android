package com.blavid.tictactoe;

import android.graphics.Point;

import java.util.Random;

/**
 * Created by blake on 4/26/2015.
 */
public class AI {
    public static Point go() {
        Point coord = new Point();
        Random random = new Random();
        int x = random.nextInt(2);
        int y = random.nextInt(2);
        coord.set(x, y);
        return coord;
    }
}
