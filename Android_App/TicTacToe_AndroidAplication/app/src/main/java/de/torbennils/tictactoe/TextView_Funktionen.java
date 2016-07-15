package de.torbennils.tictactoe;

import android.widget.TextView;

/**
 * Created by Torben on 15.07.2016.
 */

public class TextView_Funktionen {
    private Main_Activity main_activity = null;
    private TextView textViewSpiel = null;

     /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Konstruktor++++++++++++++++++++++++++++++++++++++++++++++++++++*/

    TextView_Funktionen(Main_Activity main_activity){
        this.main_activity = main_activity;
        textViewSpiel = (TextView) main_activity.findViewById(R.id.textView_spiel);
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Methoden++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Setter+++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void setText_textViewSpiel(String text){
        textViewSpiel.setText(text);
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Getter+++++++++++++++++++++++++++++++++++++++++++++++++++++*/
}
