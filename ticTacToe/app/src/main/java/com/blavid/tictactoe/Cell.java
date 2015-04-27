package com.blavid.tictactoe;

import android.content.DialogInterface;
import android.widget.Button;

/**
 * Created by blake on 4/26/2015.
 */
public class Cell implements DialogInterface.OnClickListener{
    private Button _button;
    private boolean _clicked;
    private XO _xOrO;


    @Override
    public void onClick(DialogInterface dialog, int which) {

    }

    public enum XO {
        X,
        O,
        EMPTY
    }

    public Cell(Button button) {
        _button = button;
        _xOrO = XO.EMPTY;
        _clicked = false;
    }

    public boolean isClicked() {
        return _clicked;
    }

    public void click(XO xOrO) {
        this._clicked = true;
        _xOrO = xOrO;
    }

    public void clear() {
        _clicked = false;
        _xOrO = XO.EMPTY;
    }

}
