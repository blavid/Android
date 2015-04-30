package com.blavid.tictactoe;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    Button tl,tc,tr,ml,mc,mr,bl,bc,br,newGameButton;
    final Game game = new Game();
    final Map<Button, Pair<Integer, Integer>> buttonToPair = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tl = (Button) findViewById(R.id.btnTopLeft);
        tc = (Button) findViewById(R.id.btnTopCenter);
        tr = (Button) findViewById(R.id.btnTopRight);
        ml = (Button) findViewById(R.id.btnMiddleLeft);
        mc = (Button) findViewById(R.id.btnMiddleCenter);
        mr = (Button) findViewById(R.id.btnMiddleRight);
        bl = (Button) findViewById(R.id.btnBottomLeft);
        bc = (Button) findViewById(R.id.btnBottomCenter);
        br = (Button) findViewById(R.id.btnBottomRight);
        newGameButton = (Button) findViewById(R.id.btnNewGame);

        buttonToPair.put(tl, new Pair<Integer, Integer>(0,0));
        buttonToPair.put(tl, new Pair<Integer, Integer>(0,1));
        buttonToPair.put(tl, new Pair<Integer, Integer>(0,2));
        buttonToPair.put(tl, new Pair<Integer, Integer>(1,0));
        buttonToPair.put(tl, new Pair<Integer, Integer>(1,1));
        buttonToPair.put(tl, new Pair<Integer, Integer>(1,2));
        buttonToPair.put(tl, new Pair<Integer, Integer>(2,0));
        buttonToPair.put(tl, new Pair<Integer, Integer>(2,1));
        buttonToPair.put(tl, new Pair<Integer, Integer>(2,2));

        for (Button b : buttonToPair.keySet()) {
            b.setOnClickListener(this);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        if (buttonToPair.containsKey(v)) {
            v.setBackgroundColor(Color.BLUE);
            ((Button)v).setText("X");
            button.setEnabled(false);
            Pair<Integer, Integer> xy = buttonToPair.get(button);
            game.go(xy.first, xy.second, Game.Player.PLAYER);
            if (game.checkForWinner() == Game.Player.NOBODY) {
                Pair<Integer, Integer> computerMoveLocation = game.computerMove();
                Button b = pairToButtonId(computerMoveLocation);
                b.setBackgroundColor(Color.DKGRAY);
                b.setText("O");
                b.setEnabled(false);
            }
        }
        else if (button == newGameButton) {
            game.clearBoard();
            for (Button b : buttonToPair.keySet()) {
                b.setEnabled(true);
                b.setText("");
                b.setBackgroundColor(Color.LTGRAY);
            }
        }
    }

    private Button pairToButtonId(Pair<Integer, Integer> xy) {
        for (Map.Entry<Button, Pair<Integer, Integer>> entry : buttonToPair.entrySet()) {
            if (entry.getValue() == xy) {
                return entry.getKey();
            }
        }
        return null;
    }
}
