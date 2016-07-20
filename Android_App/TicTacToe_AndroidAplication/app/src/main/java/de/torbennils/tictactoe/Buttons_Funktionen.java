package de.torbennils.tictactoe;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import java.util.Random;

import static de.torbennils.tictactoe.Main_Activity.getSpieler1;
import static de.torbennils.tictactoe.Main_Activity.getSpieler2;

public class Buttons_Funktionen {

    private Button[] buttons;
    private TicTacToe_Activity tictactoe_activity = null;
    private TextView_Funktionen textView_funktionen = null;
    private Random random = new Random();
    private FloatingActionButton buttonResset = null;
    private int anzahlButtons = 0;
    private int anzahlRunden = 1;
    private Logik logik =null;
    private int spieler1 = 0;
    private int spieler2 = 0;
    private String spielerName1 = "";
    private String spielerName2 = "";
    private String textAusgabe = "";

    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Konstruktor++++++++++++++++++++++++++++++++++++++++++++++++++++*/

    public Buttons_Funktionen(final TicTacToe_Activity tictactoe_activity, int anzahlButtons, TextView_Funktionen textView_funktionen) {
        this.tictactoe_activity = tictactoe_activity;
        this.textView_funktionen = textView_funktionen;
        this.anzahlButtons = anzahlButtons;
        logik=tictactoe_activity.getReferenzLogik();
        buttons = new Button[anzahlButtons];
        buttons[0] = (Button) tictactoe_activity.findViewById(R.id.buttonSpiel_0);
        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tictactoe_activity.getReferenzLogik().setPosition(0, 0);
            }
        });
        buttons[1] = (Button) tictactoe_activity.findViewById(R.id.buttonSpiel_1);
        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tictactoe_activity.getReferenzLogik().setPosition(0, 1);
            }
        });
        buttons[2] = (Button) tictactoe_activity.findViewById(R.id.buttonSpiel_2);
        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tictactoe_activity.getReferenzLogik().setPosition(0, 2);
            }
        });
        buttons[3] = (Button) tictactoe_activity.findViewById(R.id.buttonSpiel_3);
        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tictactoe_activity.getReferenzLogik().setPosition(1, 0);
            }
        });
        buttons[4] = (Button) tictactoe_activity.findViewById(R.id.buttonSpiel_4);
        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tictactoe_activity.getReferenzLogik().setPosition(1, 1);
            }
        });
        buttons[5] = (Button) tictactoe_activity.findViewById(R.id.buttonSpiel_5);
        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tictactoe_activity.getReferenzLogik().setPosition(1, 2);
            }
        });
        buttons[6] = (Button) tictactoe_activity.findViewById(R.id.buttonSpiel_6);
        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tictactoe_activity.getReferenzLogik().setPosition(2, 0);
            }
        });
        buttons[7] = (Button) tictactoe_activity.findViewById(R.id.buttonSpiel_7);
        buttons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tictactoe_activity.getReferenzLogik().setPosition(2, 1);
            }
        });
        buttons[8] = (Button) tictactoe_activity.findViewById(R.id.buttonSpiel_8);
        buttons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tictactoe_activity.getReferenzLogik().setPosition(2, 2);
            }
        });
        buttonResset = (FloatingActionButton) tictactoe_activity.findViewById(R.id.fab);
        buttonResset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anzahlRunden++;
                resetButtons();
                int zufallsZahl = random.nextInt(3);
                if (zufallsZahl == 0){
                    textAusgabe = "Neue Runde neues Glück ;D";
                }
                if (zufallsZahl == 1){
                    textAusgabe = "Kopf nicht hängen lassen :)";
                }
                if (zufallsZahl == 2){
                    textAusgabe = "Weiter So!!!";
                }
                if (zufallsZahl == 3){
                    textAusgabe = getSpieler1()+" vor, noch ein Tor!";
                }
                Snackbar.make(view, textAusgabe, Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        for (int i =0;i < anzahlButtons;i++) {
            buttons[i].setTextColor(Color.BLACK);
        }
    }

    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Methoden++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Setter+++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void setFarbeArray(Button[] buttonReferenz, int buttonFarbe) {
        for (int i = 0; i < buttonReferenz.length; i++) {
            this.setFarbe(buttonReferenz[i],buttonFarbe);
        }
    }

    public void setFarbe(Button buttonReferenz, int buttonFarbe) {
        buttonReferenz.setBackgroundColor(buttonFarbe);
    }

    public void setText(Button buttonReferenz, String buttonText) {
        buttonReferenz.setText(buttonText);
    }

    public void setTextFarbe(Button buttonReferenz, int buttonFarbe) {
        buttonReferenz.setTextColor(buttonFarbe);
    }

    public void setTextFarbeArray(Button[] buttonReferenz, int textFarbe) {
        for (int i = 0; i < buttonReferenz.length; i++) {
            buttonReferenz[i].setTextColor(textFarbe);
        }
    }

    public void resetButtons() {
        for (int i =0;i < anzahlButtons;i++){
            buttons[i].setTextColor(Color.BLACK);
            buttons[i].setText("");
        }

        textView_funktionen.setText_textViewSpiel("Runde: " + anzahlRunden);
        tictactoe_activity.setNewRefernzLogik();

    }

    public void setSpielerName(String spielerName1, String spielerName2) {
        this.spielerName1 = spielerName1;
        this.spielerName2 = spielerName2;
        textView_funktionen.setText_textViewSpieler1(getSpieler1()+"("+spielerName1+"):\n"+spieler1);
        textView_funktionen.setText_textViewSpieler2(getSpieler2()+"("+spielerName2+"):\n"+spieler2);
    }

    public void gewonnen(){
        logik=tictactoe_activity.getReferenzLogik();
            if(logik.hatspieler2gewonnen()){
                spieler1++;
                textView_funktionen.setText_textViewSpieler1(getSpieler1()+"("+spielerName1+"):\n"+spieler1);
            }else if(logik.hatspieler1gewonnen()){
                spieler2++;
                textView_funktionen.setText_textViewSpieler2(getSpieler2()+"("+spielerName2+"):\n"+spieler2);
            }
        }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Getter+++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public Button[] getButtonArray() {
        return buttons;
    }

}