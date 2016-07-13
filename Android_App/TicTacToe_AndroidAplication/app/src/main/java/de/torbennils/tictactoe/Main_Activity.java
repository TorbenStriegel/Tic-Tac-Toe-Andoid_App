package de.torbennils.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class Main_Activity extends AppCompatActivity {
    Logik logik = new Logik(1);
    TextView textViewSpiel = null;
    static Button buttonSpiel1 = null;
    static Button buttonSpiel2 = null;
    static Button buttonSpiel3 = null;
    static Button buttonSpiel4 = null;
    static Button buttonSpiel5 = null;
    static Button buttonSpiel6 = null;
    static Button buttonSpiel7 = null;
    static Button buttonSpiel8 = null;
    static Button buttonSpiel9 = null;

    int runde = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewSpiel= (TextView) findViewById(R.id.textView_spiel);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "© Nils und Torben", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        buttonSpiel1 = (Button) findViewById(R.id.buttonSpiel_1);
        buttonSpiel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logik.setPosition(0,0);
                gewonnen();
            }
        });
        buttonSpiel2 = (Button) findViewById(R.id.buttonSpiel_2);
        buttonSpiel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logik.setPosition(0,1);
                gewonnen();
            }
        });
        buttonSpiel3 = (Button) findViewById(R.id.buttonSpiel_3);
        buttonSpiel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logik.setPosition(0,2);
                gewonnen();
            }
        });
        buttonSpiel4 = (Button) findViewById(R.id.buttonSpiel_4);
        buttonSpiel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logik.setPosition(1,0);
                gewonnen();
            }
        });

        buttonSpiel5 = (Button) findViewById(R.id.buttonSpiel_5);
        buttonSpiel5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logik.setPosition(1,1);
                gewonnen();
            }
        });

        buttonSpiel6 = (Button) findViewById(R.id.buttonSpiel_6);
        buttonSpiel6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logik.setPosition(1,2);
                gewonnen();
            }
        });

        buttonSpiel7 = (Button) findViewById(R.id.buttonSpiel_7);
        buttonSpiel7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logik.setPosition(2,0);
                gewonnen();
            }
        });

        buttonSpiel8 = (Button) findViewById(R.id.buttonSpiel_8);
        buttonSpiel8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logik.setPosition(2,1);
                gewonnen();
            }
        });

        buttonSpiel9 = (Button) findViewById(R.id.buttonSpiel_9);
        buttonSpiel9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logik.setPosition(2,2);
                gewonnen();
            }
        });

    }
    public static void setZeichnen(int zeile, int spalte) {
        if (zeile == 0){
            if (spalte == 0){
                buttonSpiel1.setText("X");
            }
            if (spalte == 1){
                buttonSpiel2.setText("X");
            }
            if (spalte == 2){
                buttonSpiel3.setText("X");
            }
        }
        if (zeile == 1){
            if (spalte == 0){
                buttonSpiel4.setText("X");
            }
            if (spalte == 1){
                buttonSpiel5.setText("X");
            }
            if (spalte == 2){
                buttonSpiel6.setText("X");
            }
        }
        if (zeile == 2){
            if (spalte == 0){
                buttonSpiel7.setText("X");
            }
            if (spalte == 1){
                buttonSpiel8.setText("X");
            }
            if (spalte == 2){
                buttonSpiel9.setText("X");
            }
        }

    }
   public void gewonnen(){
        runde++;
        if(logik.gewonnen()){
            textViewSpiel.setText("Du hast gewonnen :D");
        }else{
            if(runde%2 == 0){
                textViewSpiel.setText("Runde: "+runde+" (Spieler 2)");
            }else{
                textViewSpiel.setText("Runde: "+runde+" (Spieler 1)");
            }

        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_, menu);
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
}
