package de.torbennils.tictactoe;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class TicTacToe_Activity extends AppCompatActivity {
    private Logik logik = null;
    private Buttons_Funktionen buttons_funktionen = null;
    private TextView_Funktionen textView_funktionen = null;
    private int anzahlButtons = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Erzeugen von Opjekten++++++++++++++++++++++++++++++++++++++++++++++++++++*/

        textView_funktionen = new TextView_Funktionen(this);
        buttons_funktionen = new Buttons_Funktionen(this,anzahlButtons,textView_funktionen); //Refernz this, Anzahl der Buttons, Refernz auf TextView_Funktionen
        logik = new Logik(2, this, buttons_funktionen); //Anzahl Spieler, Refernz this, Refernz auf Buttons_Funktionen

    }

    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Methoden++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Setter+++++++++++++++++++++++++++++++++++++++++++++++++++++*/

    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Getter+++++++++++++++++++++++++++++++++++++++++++++++++++++*/

    public Logik getReferenzLogik(){
        return logik;
    }
    public Buttons_Funktionen getReferenzButtons_Funktionen(){
        return buttons_funktionen;
    }
    public TextView_Funktionen getReferenzTextView_Funktionen(){
        return textView_funktionen;
    }
}
