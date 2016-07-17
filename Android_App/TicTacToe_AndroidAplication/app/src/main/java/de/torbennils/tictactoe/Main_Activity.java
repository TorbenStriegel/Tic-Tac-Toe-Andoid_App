package de.torbennils.tictactoe;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class Main_Activity extends AppCompatActivity {

    private static String spielerName1 = "";
    private static String spielerName2 = "";
    private static boolean auswahlKi = true;
    static EditText spieler1 = null;
    static EditText spieler2 = null;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Toast.makeText(this, "© Torben und Nils".toString(), Toast.LENGTH_LONG).show();
        spieler1 =  (EditText) findViewById(R.id.editText_Spieler1);
        spieler2 =  (EditText) findViewById(R.id.editText_Spieler2);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox_KiAuswahl);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auswahlKi = ((CheckBox) view).isChecked();
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
    }

    public static String getSpieler1(){ return spieler1.getText().toString(); }
    public static String getSpieler2(){
        if (auswahlKi){
            return"Dein Handy";
        }else{
            return spieler2.getText().toString();
        }
    }
    public static boolean getKiAuswahl(){
        return auswahlKi;
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
