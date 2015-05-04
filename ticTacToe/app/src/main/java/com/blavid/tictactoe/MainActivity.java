package com.blavid.tictactoe;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    Button tl,tc,tr,ml,mc,mr,bl,bc,br,newGameButton;
    TextView txtWinner;
    final Game game = new Game();
    final Map<Button, Pair<Integer, Integer>> buttonToPair = new HashMap<>();
    int difficultyLevel;

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
        txtWinner = (TextView) findViewById(R.id.textViewWinner);

        buttonToPair.put(tl, new Pair<Integer, Integer>(0,0));
        buttonToPair.put(tc, new Pair<Integer, Integer>(0,1));
        buttonToPair.put(tr, new Pair<Integer, Integer>(0,2));
        buttonToPair.put(ml, new Pair<Integer, Integer>(1,0));
        buttonToPair.put(mc, new Pair<Integer, Integer>(1,1));
        buttonToPair.put(mr, new Pair<Integer, Integer>(1,2));
        buttonToPair.put(bl, new Pair<Integer, Integer>(2,0));
        buttonToPair.put(bc, new Pair<Integer, Integer>(2,1));
        buttonToPair.put(br, new Pair<Integer, Integer>(2,2));

        for (Button b : buttonToPair.keySet()) {
            b.setOnClickListener(this);
        }

        newGameButton.setOnClickListener(this);
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
        if (buttonToPair.containsKey(v)) {
            playerSelectsSquare((Button) v);
            Game.Player winner = game.checkForWinner();
            if (winner == Game.Player.NOBODY) {
                computerSelectsSquare();
                winner = game.checkForWinner();
                if (winner == Game.Player.COMPUTER) {
                    declareWinner(winner);
                }
            }
            else {
                declareWinner(winner);
            }
        }
        else if ((Button) v == newGameButton) {
            game.clearBoard();
            for (Button b : buttonToPair.keySet()) {
                b.setEnabled(true);
                b.setText("");
                b.setBackgroundColor(Color.LTGRAY);
            }
            txtWinner.setText("");
        }
    }

    private Button pairToButtonId(Pair<Integer, Integer> xy) {
        for (Map.Entry<Button, Pair<Integer, Integer>> entry : buttonToPair.entrySet()) {
            if (entry.getValue().equals(xy)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private void disableBoardButtons() {
        for (Button b : buttonToPair.keySet()) {
            b.setEnabled(false);
        }
    }

    private void playerSelectsSquare(Button b) {
        b.setBackgroundColor(Color.BLUE);
        b.setText("X");
        b.setEnabled(false);
        Pair<Integer, Integer> xy = buttonToPair.get(b);
        game.go(xy.first, xy.second, Game.Player.PLAYER);
    }

    private void computerSelectsSquare() {
        Pair<Integer, Integer> computerMoveLocation = game.computerMove(Game.DifficultyLevel.EASY);
        Button b = pairToButtonId(computerMoveLocation);
        b.setBackgroundColor(Color.DKGRAY);
        b.setText("O");
        b.setEnabled(false);
    }

    private void declareWinner(Game.Player winner) {
        txtWinner.setText(winner.toString() + " WINS!");
        disableBoardButtons();
    }
}
