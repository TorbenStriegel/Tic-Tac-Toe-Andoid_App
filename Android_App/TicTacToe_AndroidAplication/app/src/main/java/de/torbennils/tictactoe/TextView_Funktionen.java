package de.torbennils.tictactoe;

import android.widget.TextView;

/**
 * Created by Torben on 15.07.2016.
 */

public class TextView_Funktionen {
    private TicTacToe_Activity tictactoe_activity = null;
    private TextView textViewSpiel = null;

     /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Konstruktor++++++++++++++++++++++++++++++++++++++++++++++++++++*/

    TextView_Funktionen(TicTacToe_Activity tictactoe_activity){
        this.tictactoe_activity = tictactoe_activity;
        textViewSpiel = (TextView) tictactoe_activity.findViewById(R.id.textView_spiel);
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Methoden++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Setter+++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void setText_textViewSpiel(String text){
        textViewSpiel.setText(text);
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Getter+++++++++++++++++++++++++++++++++++++++++++++++++++++*/
}
