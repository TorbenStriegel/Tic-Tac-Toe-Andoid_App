package de.torbennils.tictactoe;

import android.widget.TextView;

import static de.torbennils.tictactoe.Main_Activity.getSpieler1;
import static de.torbennils.tictactoe.Main_Activity.getSpieler2;

/**
 * Created by Torben on 15.07.2016.
 */

public class TextView_Funktionen {
    private TicTacToe_Activity tictactoe_activity = null;
    private TextView textViewSpiel = null;
    private TextView textViewSpieler1 = null;
    private TextView textViewSpieler2 = null;

     /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Konstruktor++++++++++++++++++++++++++++++++++++++++++++++++++++*/

    TextView_Funktionen(TicTacToe_Activity tictactoe_activity){
        this.tictactoe_activity = tictactoe_activity;
        textViewSpiel = (TextView) tictactoe_activity.findViewById(R.id.textView_spiel);
        textViewSpieler1 = (TextView) tictactoe_activity.findViewById(R.id.textView_spieler1);
        textViewSpieler2 = (TextView) tictactoe_activity.findViewById(R.id.textView_spieler2);

        textViewSpieler1.setText(getSpieler1()+":\n0");
        textViewSpieler2.setText(getSpieler2()+":\n0");
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Methoden++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Setter+++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void setText_textViewSpiel(String text){
        textViewSpiel.setText(text);
    }
    public void setText_textViewSpieler1(String text){
        textViewSpieler1.setText(text);
    }
    public void setText_textViewSpieler2(String text){
        textViewSpieler2.setText(text);
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Getter+++++++++++++++++++++++++++++++++++++++++++++++++++++*/
}
