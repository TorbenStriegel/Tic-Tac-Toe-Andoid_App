package de.torbennils.tictactoe;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.apptracker.android.listener.AppModuleListener;
import com.apptracker.android.track.AppTracker;

public class Main_Activity extends AppCompatActivity {

    private static String spielerName1 = "";
    private static String spielerName2 = "";
    private static boolean auswahlKi = false;
    private static boolean auswahlKi1 = false;
    private static boolean auswahlKi2 = false;
    private static boolean auswahlKi3 = false;
    static EditText spieler1 = null;
    static EditText spieler2 = null;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        if(savedInstanceState == null) {                                // Werbung
            // Initialize Leadbolt SDK with your api key
            AppTracker.startSession(getApplicationContext(),"UrakQru4vYKJ4rfUtsqMea22IMwgjvZn",AppTracker.ENABLE_AUTO_CACHE);
        }
        // cache Leadbolt Ad without showing it
        AppTracker.loadModuleToCache(getApplicationContext(),"inapp");
        AppTracker.setAgeRange("18-25");
        // Allowed values for Age range are: "13-17", "18-25", "26-35", "36-45", "46+"

        AppTracker.setGender("Female");
        // Allowed values for Gender are: "Male", "Female"

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gameOver();
        Toast.makeText(this, "© Torben und Nils".toString(), Toast.LENGTH_LONG).show();
        spieler1 =  (EditText) findViewById(R.id.editText_Spieler1);
        spieler2 =  (EditText) findViewById(R.id.editText_Spieler2);

        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox_KiAuswahl1);
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox_KiAuswahl2);
        final CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox_KiAuswahl3);
        checkBox1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                auswahlKi1 = ((CheckBox) view).isChecked();
                if (auswahlKi1){
                    spieler2.setVisibility(View.INVISIBLE);
                    auswahlKi2 = false;
                    auswahlKi3 = false;
                }else{
                    spieler2.setVisibility(View.VISIBLE);
                }
                if (auswahlKi1){
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                }
           }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auswahlKi2 = ((CheckBox) view).isChecked();
                if (auswahlKi2){
                    spieler2.setVisibility(View.INVISIBLE);
                    auswahlKi1 = false;
                    auswahlKi3 = false;
                }else{
                    spieler2.setVisibility(View.VISIBLE);
                }
                if (auswahlKi2){
                    checkBox1.setChecked(false);
                    checkBox3.setChecked(false);
                }
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auswahlKi3 = ((CheckBox) view).isChecked();
                if (auswahlKi3){
                    spieler2.setVisibility(View.INVISIBLE);
                    auswahlKi1 = false;
                    auswahlKi2 = false;
                }else{
                    spieler2.setVisibility(View.VISIBLE);
                }
                if (auswahlKi3){
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                }
            }
        });

        FloatingActionButton fab_start = (FloatingActionButton) findViewById(R.id.fab_start);
        fab_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ticTacToe_Activity = new Intent(Main_Activity.this, TicTacToe_Activity.class);
                startActivity(ticTacToe_Activity);
            }
        });
        //spieler2.setVisibility(View.INVISIBLE);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {                       // Menü oben rechts
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.settings) {
            Intent settings_Activity = new Intent(Main_Activity.this, Impressum_Activity.class);
            startActivity(settings_Activity);
            return true;
        }
        if (id == R.id.advertisment) {
            gameOver();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void gameOver() {                                                        // aufrufen wenn Werbung kommen soll
        if (AppTracker.isAdReady("inapp")) {
            AppTracker.loadModule(getApplicationContext(), "inapp");
        }
    }
    public void onConfigurationChanged(Configuration newConfig)             // Nicht drehbar
    {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Methoden++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Getter+++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public static String getSpieler1(){ return spieler1.getText().toString(); }  // Spielername 1
    public static String getSpieler2(){  // Spielername 2
        if (auswahlKi1){
            return"Easy";
        }if (auswahlKi2){
            return"Normal";
        }if (auswahlKi3){
            return"Boss";
        }else{
            return spieler2.getText().toString();
        }
    }

    public static boolean getKiAuswahl(){
        if (auswahlKi1 || auswahlKi2 || auswahlKi3){
            auswahlKi = true;
        }else{
            auswahlKi = false;
        }
        return auswahlKi;
    }

    public static boolean getKi1Auswahl(){
        return auswahlKi1;
    }
    public static boolean getKi2Auswahl(){
        return auswahlKi2;
    }
    public static boolean getKi3Auswahl(){
        return auswahlKi3;
    }
}
