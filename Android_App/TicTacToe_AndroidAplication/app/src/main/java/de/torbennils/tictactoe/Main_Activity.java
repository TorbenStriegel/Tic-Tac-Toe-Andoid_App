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
    private Logik logik = null;
    private Buttons_Funktionen buttons_funktionen = null;
    private TextView_Funktionen textView_funktionen = null;
    private Button[] button;
    private int anzahlButtons = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Erzeugen von Opjekten++++++++++++++++++++++++++++++++++++++++++++++++++++*/

        textView_funktionen = new TextView_Funktionen(this);
        buttons_funktionen = new Buttons_Funktionen(this,anzahlButtons,textView_funktionen); //Refernz this, Anzahl der Buttons, Refernz auf TextView_Funktionen
        logik = new Logik(2, this, buttons_funktionen); //Anzahl Spieler, Refernz this, Refernz auf Buttons_Funktionen
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
