package de.torbennils.tictactoe;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

public class Buttons_Funktionen {

    private Button[] buttons;
    private Main_Activity main_activity = null;

    public Buttons_Funktionen(Main_Activity main_activity){
        this.main_activity = main_activity;

        buttons [0] = (Button) main_activity.findViewById(R.id.buttonSpiel_1);
        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                logik.setPosition(2,1);
            }
        });

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
