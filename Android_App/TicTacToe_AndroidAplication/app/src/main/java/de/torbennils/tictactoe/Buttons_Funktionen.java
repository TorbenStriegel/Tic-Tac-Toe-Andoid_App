package de.torbennils.tictactoe;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;

public class Buttons_Funktionen {

    private Button[] buttons;
    private TicTacToe_Activity tictactoe_activity = null;
    private TextView_Funktionen textView_funktionen = null;
    FloatingActionButton buttonResset = null;
    private int anzahlButtons = 0;
    private int anzahlRunden = 1;
    private Logik logik =null;

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
                Snackbar.make(view, "Neue Runde neues Glück ;D", Snackbar.LENGTH_LONG).setAction("Action", null).show();
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

    public void gewonnen(){
        logik=tictactoe_activity.getReferenzLogik();
        if(logik.gewonnen()){
            textView_funktionen.setText_textViewSpiel(logik.getGewonnenName()+" hat gewonnen :D");
        }else{
            anzahlRunden++;
            if(anzahlRunden%2 == 0){
                textView_funktionen.setText_textViewSpiel("Runde: "+anzahlRunden);
            }else{
                textView_funktionen.setText_textViewSpiel("Runde: "+anzahlRunden);
            }
        }
    }
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++Getter+++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public Button[] getButtonArray() {
        return buttons;
    }


}