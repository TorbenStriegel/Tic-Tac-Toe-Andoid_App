package de.torbennils.tictactoe;

import android.widget.Button;

public class Buttons_Funktionen {

    private Button[] buttons;
    private int buttonAnzahl;

    Buttons_Funktionen(int anzahlButtons, Button[] buttonArray){
        this.buttonAnzahl = anzahlButtons;
        this.buttons = buttonArray;
    }

    public Button[] getButtonArray(){
        return buttons;
    }

}
