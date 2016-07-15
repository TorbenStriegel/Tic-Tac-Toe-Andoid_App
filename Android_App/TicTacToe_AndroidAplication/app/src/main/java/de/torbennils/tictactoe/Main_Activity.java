package de.torbennils.tictactoe;


import android.graphics.Color;
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
    Logik logik = null;
    TextView textViewSpiel = null;
    Button buttonSpiel1 = null;
    Button buttonSpiel2 = null;
    Button buttonSpiel3 = null;
    Button buttonSpiel4 = null;
    Button buttonSpiel5 = null;
    Button buttonSpiel6 = null;
    Button buttonSpiel7 = null;
    Button buttonSpiel8 = null;
    Button buttonSpiel9 = null;
    Button[] buttons_farbig;

    int runde = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        logik = new Logik(1, this);
        textViewSpiel= (TextView) findViewById(R.id.textView_spiel);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
                Snackbar.make(view, "Neue Runde neues Glück ;D", Snackbar.LENGTH_LONG).setAction("Action", null).show();
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
    public void setZeichnen(int zeile, int spalte,String name) {
            if (zeile == 0) {
                if (spalte == 0) {
                    buttonSpiel1.setText(name);
                }
                if (spalte == 1) {
                    buttonSpiel2.setText(name);
                }
                if (spalte == 2) {
                    buttonSpiel3.setText(name);
                }
            }
            if (zeile == 1) {
                if (spalte == 0) {
                    buttonSpiel4.setText(name);
                }
                if (spalte == 1) {
                    buttonSpiel5.setText(name);
                }
                if (spalte == 2) {
                    buttonSpiel6.setText(name);
                }
            }
            if (zeile == 2) {
                if (spalte == 0) {
                    buttonSpiel7.setText(name);
                }
                if (spalte == 1) {
                    buttonSpiel8.setText(name);
                }
                if (spalte == 2) {
                    buttonSpiel9.setText(name);
                }
            }

    }
   public void gewonnen(){
        if(logik.gewonnen()){
            textViewSpiel.setText(logik.getGewonnenName()+" hat gewonnen :D");
            logik.setButtons(buttonSpiel1,buttonSpiel2,buttonSpiel3,buttonSpiel4,buttonSpiel5,buttonSpiel6,buttonSpiel7,buttonSpiel8,buttonSpiel9);
            buttons_farbig = logik.getButtons();
            buttons_farbig[0].setBackgroundColor(Color.GREEN);
            buttons_farbig[1].setBackgroundColor(Color.GREEN);
            buttons_farbig[2].setBackgroundColor(Color.GREEN);
        }else{
            runde++;
            if(runde%2 == 0){
                textViewSpiel.setText("Runde: "+runde);
            }else{
                textViewSpiel.setText("Runde: "+runde);
            }
        }
    }

    public void reset(){
        logik = new Logik(1, this);
        runde =0;
        buttonSpiel1.setText("");
        buttonSpiel2.setText("");
        buttonSpiel3.setText("");
        buttonSpiel4.setText("");
        buttonSpiel5.setText("");
        buttonSpiel6.setText("");
        buttonSpiel7.setText("");
        buttonSpiel8.setText("");
        buttonSpiel9.setText("");
        logik.setButtons(buttonSpiel1,buttonSpiel2,buttonSpiel3,buttonSpiel4,buttonSpiel5,buttonSpiel6,buttonSpiel7,buttonSpiel8,buttonSpiel9);
        buttons_farbig = logik.getButtons();
        buttons_farbig[0].setBackgroundColor(Color.LTGRAY);
        buttons_farbig[1].setBackgroundColor(Color.GREEN);
        buttons_farbig[2].setBackgroundColor(Color.GREEN);
        textViewSpiel.setText("Los geht´s :D");
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
