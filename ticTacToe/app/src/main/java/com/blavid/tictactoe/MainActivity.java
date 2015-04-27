package com.blavid.tictactoe;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    Cell tl,tc,tr,ml,mc,mr,bl,bc,br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tl = new Cell((Button) findViewById(R.id.btnTopLeft));

        tc = new Cell((Button) findViewById(R.id.btnTopCenter));
        tr = new Cell((Button) findViewById(R.id.btnTopRight));
        ml = new Cell((Button) findViewById(R.id.btnMiddleLeft));
        mc = new Cell((Button) findViewById(R.id.btnMiddleCenter));
        mr = new Cell((Button) findViewById(R.id.btnMiddleRight));
        bl = new Cell((Button) findViewById(R.id.btnBottomLeft));
        bc = new Cell((Button) findViewById(R.id.btnBottomCenter));
        br = new Cell((Button) findViewById(R.id.btnBottomRight));

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

    }
}
