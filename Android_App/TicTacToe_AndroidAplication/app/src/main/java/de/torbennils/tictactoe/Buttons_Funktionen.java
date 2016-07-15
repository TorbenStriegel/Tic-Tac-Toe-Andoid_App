package de.torbennils.tictactoe;

import android.graphics.Color;
import android.widget.Button;

public class Buttons_Funktionen {

    private Button[] buttons;
    private int buttonAnzahl = 0;
    private Main_Activity main_activity = null;

    public Buttons_Funktionen(Main_Activity main_activity,int anzahlButtons, Button[] buttonArray){
        this.main_activity = main_activity;
        this.buttonAnzahl = anzahlButtons;
        this.buttons = buttonArray;
    }
    public void setFarbe(Button[] buttonAnmalen, int buttonFarbe){
     for (int i =0;i < buttonAnmalen.length;i++){
         buttonAnmalen[i].setBackgroundColor(buttonFarbe);
        }
    }

    public Button[] getButtonArray(){
        return buttons;
    }

}
