package de.torbennils.tictactoe;

import android.graphics.Color;
import android.os.Handler;
import android.widget.Button;

import static android.R.attr.delay;

/**
 * Created by Torben on 13.07.2016.
 */

public class Logik {
    private String [][] array_spielfeld = {{" "," "," "},{" "," "," "},{" "," "," "}};
    private Spieler spieler_1;
    private Spieler spieler_2;
    private boolean gewonnen_boolean = false;
    private int zustand=0;
    private int zustand_spieler=0;
    private int zustand_gewonnen=0;
    private int zustand_unentschieden=0;
    private TicTacToe_Activity main = null;
    private Button[] buttons = null;
    private Buttons_Funktionen funktionen_buttons ;
    private Handler myHandler;
    private boolean kisturn = false;
    private boolean schongewonnenundubergeben = false;
    private int werstartet;
    private int weristdran;//wenn spieler 1(ki) dran dann 2 uebergeben
    private TextView_Funktionen textView_funktionen;

    //**********************************************************************************************************

    public Logik(int anzahl,int art, TicTacToe_Activity main, Buttons_Funktionen funktionen_buttons,TextView_Funktionen textView_funktionen ){
        this.main = main;
        this.funktionen_buttons = funktionen_buttons;
        werstartet =  (int)(Math.random()*10);
        this.textView_funktionen = textView_funktionen;
        setButtons();
        myHandler=new Handler();
        if (anzahl==1){
            int i =(int)(Math.random()*10);
            if(i>5){
                if (art==0){
                    spieler_1 = new KiCracy("X");
                }else if(art==1){
                    spieler_1 =new Ki("X");
                }else if(art==2){
                    spieler_1 =new Kibesser("X");
                }
                spieler_2 = new Spieler("O");
            }else{
                if (art==0){
                    spieler_1 = new KiCracy("O");
                }else if(art==1){
                    spieler_1 =new Ki("O");
                }else if(art==2){
                    spieler_1 =new Kibesser("O");

                }
                spieler_2 = new Spieler("X");
            }
        }else if (anzahl==2){
            int i =(int)(Math.random()*10);
            if(i>5){
                spieler_1 = new Spieler("X");
                spieler_2 = new Spieler("O");
            }else{
                spieler_1 = new Spieler("O");
                spieler_2 = new Spieler("X");
            }
        }
            weristdran=1;
        if (werstartet>=5) {
            weristdran = 2;
            zustand = 0;
            zustand_spieler=1;

            if (spieler_1 instanceof Ki||spieler_1 instanceof Kibesser|| spieler_1 instanceof KiCracy ) {
                kisturn = true;
                setzen_Ki();
                myHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        zeichnen_Ki();
                    }

                }, 500);
            }
        }
        funktionen_buttons.setSpielerName(spieler_2.getName(),spieler_1.getName());
        textView_funktionen.setWerIstDran(weristdran);
    }


    //**********************************************************************************************************

    public void setPosition(int zeile ,int spalte){
        if(isValid(zeile,spalte)&&!gewonnen()){
            if(isTHEREaKI()){
                zustand = 0;

                    if (!kisturn) {
                        kisturn = true;
                        setzen(zeile, spalte);

                        zeichnen_spieler(zeile, spalte, spieler_2);

                        if (!gewonnen() && !(zustand_unentschieden > 8)) {

                            setzen_Ki();
                            myHandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    zeichnen_Ki();
                                }

                            }, 500);

                        }

                    }

            }else{
                if (zustand_spieler==0){
                    setzen(zeile,spalte);
                    zeichnen_spieler(zeile,spalte,spieler_2);
                    weristdran=2;
                    textView_funktionen.setWerIstDran(weristdran);
                    zustand_spieler ++;
                }else{
                    setzen(zeile,spalte);
                    zeichnen_spieler(zeile,spalte,spieler_1);
                    weristdran=1;
                    textView_funktionen.setWerIstDran(weristdran);
                    zustand_spieler --;
                }

            }
        }

    }

    private void zeichnen_Ki() {
        kisturn=false;
        if(zustand_gewonnen==0){

            if (spieler_1.getZeile() ==0&&spieler_1.getSpalte()==0){
                funktionen_buttons.setText(buttons[0],spieler_1.getName());
            }
            if (spieler_1.getZeile() ==0&&spieler_1.getSpalte()==1){
                funktionen_buttons.setText(buttons[1],spieler_1.getName());
            }
            if (spieler_1.getZeile() ==0&&spieler_1.getSpalte()==2){
                funktionen_buttons.setText(buttons[2],spieler_1.getName());
            } if (spieler_1.getZeile() ==1&&spieler_1.getSpalte()==0){
                funktionen_buttons.setText(buttons[3],spieler_1.getName());
            }
            if (spieler_1.getZeile() ==1&&spieler_1.getSpalte()==1){
                funktionen_buttons.setText(buttons[4],spieler_1.getName());
            }
            if (spieler_1.getZeile() ==1&&spieler_1.getSpalte()==2){
                funktionen_buttons.setText(buttons[5],spieler_1.getName());
            } if (spieler_1.getZeile() ==2&&spieler_1.getSpalte()==0){
                funktionen_buttons.setText(buttons[6],spieler_1.getName());
            }
            if (spieler_1.getZeile() ==2&&spieler_1.getSpalte()==1){
                funktionen_buttons.setText(buttons[7],spieler_1.getName());
            }
            if (spieler_1.getZeile() ==2&&spieler_1.getSpalte()==2){
                funktionen_buttons.setText(buttons[8],spieler_1.getName());
            }
            weristdran=1;
            textView_funktionen.setWerIstDran(weristdran);
            zustand_unentschieden++;
        }
        if(gewonnen()){
            funktionen_buttons.gewonnen();
            zustand_gewonnen=1;
        }
    }


    private void setzen_Ki() {
        spieler_1.setString(array_spielfeld);
        spieler_1.setzten(100,100);
        array_spielfeld=spieler_1.getString();

    }


    private void setzen(int zeile_setzen, int spalte_setzen){

        if (zustand==0) {
            spieler_2.setString(array_spielfeld);
            spieler_2.setzten(zeile_setzen,spalte_setzen);
            array_spielfeld=spieler_2.getString();
            zustand++;
        }else if (zustand==1){
            spieler_1.setString(array_spielfeld);
            spieler_1.setzten(zeile_setzen,spalte_setzen);
            array_spielfeld=spieler_1.getString();
            zustand--;
        }

    }

    private void zeichnen_spieler(int zeile_zeichnen, int spalte_zeichnen,Spieler i){
        if(zustand_gewonnen==0){
            if (zeile_zeichnen ==0&&spalte_zeichnen==0){
                funktionen_buttons.setText(buttons[0],i.getName());
            }
            if (zeile_zeichnen ==0&&spalte_zeichnen==1){
                funktionen_buttons.setText(buttons[1],i.getName());
            }
            if (zeile_zeichnen ==0&&spalte_zeichnen==2){
                funktionen_buttons.setText(buttons[2],i.getName());
            }
            if (zeile_zeichnen ==1&&spalte_zeichnen==0){
                funktionen_buttons.setText(buttons[3],i.getName());
            }
            if (zeile_zeichnen ==1&&spalte_zeichnen==1){
                funktionen_buttons.setText(buttons[4],i.getName());
            }
            if (zeile_zeichnen ==1&&spalte_zeichnen==2){
                funktionen_buttons.setText(buttons[5],i.getName());
            }if (zeile_zeichnen ==2&&spalte_zeichnen==0){
                funktionen_buttons.setText(buttons[6],i.getName());
            }
            if (zeile_zeichnen ==2&&spalte_zeichnen==1){
                funktionen_buttons.setText(buttons[7],i.getName());
            }
            if (zeile_zeichnen ==2&&spalte_zeichnen==2){
                funktionen_buttons.setText(buttons[8],i.getName());
            }
            weristdran=2;
            textView_funktionen.setWerIstDran(weristdran);
            zustand_unentschieden++;
        }
        if(gewonnen()){
            funktionen_buttons.gewonnen();
            zustand_gewonnen=1;
        }

    }



    private boolean isTHEREaKI(){
        if(spieler_1 instanceof Ki||spieler_1 instanceof Kibesser|| spieler_1 instanceof KiCracy ){
            return true;
        }else{
            return false;
        }

    }

    private boolean isValid(int zeile_test,int spalte_test ){
        if(array_spielfeld[zeile_test][spalte_test].equals(" ")||array_spielfeld[zeile_test][spalte_test].equals("")){
            return true;
        }else{
            return false;
        }
    }

    public boolean gewonnen(){
        if((gewonnen_1()||gewonnen_2())&&!gewonnen_boolean){
            gewonnen_boolean=true;
            this.setButtonsfarbe();
        }
        return gewonnen_boolean;
    }

    private boolean gewonnen_1(){
        boolean noch_nicht_1=true;
        for (int i = 0; i <3; i++) {
            if((array_spielfeld[i][0].equals("X"))&&(array_spielfeld[i][1].equals("X"))&&(array_spielfeld[i][2].equals("X"))){
                noch_nicht_1=false;
            }
        }
        for (int i = 0; i <3; i++) {
            if((array_spielfeld[0][i].equals("X"))&&(array_spielfeld[1][i].equals("X"))&&(array_spielfeld[2][i].equals("X"))){
                noch_nicht_1=false;
            }
        }

        if((array_spielfeld[0][0].equals("X"))&&(array_spielfeld[1][1].equals("X"))&&(array_spielfeld[2][2].equals("X"))){
            noch_nicht_1=false;
        }

        if((array_spielfeld[0][2].equals("X"))&&(array_spielfeld[1][1].equals("X"))&&(array_spielfeld[2][0].equals("X"))){
            noch_nicht_1=false;
        }

        return !noch_nicht_1;
    }


    private boolean gewonnen_2(){
        boolean noch_nicht_2=true;
        for (int i = 0; i <3; i++) {
            if((array_spielfeld[i][0].equals("O"))&&(array_spielfeld[i][1].equals("O"))&&(array_spielfeld[i][2].equals("O"))){
                noch_nicht_2=false;
            }
        }
        for (int i = 0; i <3; i++) {
            if((array_spielfeld[0][i].equals("O"))&&(array_spielfeld[1][i].equals("O"))&&(array_spielfeld[2][i].equals("O"))){
                noch_nicht_2=false;
            }
        }

        if((array_spielfeld[0][0].equals("O"))&&(array_spielfeld[1][1].equals("O"))&&(array_spielfeld[2][2].equals("O"))){
            noch_nicht_2=false;
        }

        if((array_spielfeld[0][2].equals("O"))&&(array_spielfeld[1][1].equals("O"))&&(array_spielfeld[2][0].equals("O"))){
            noch_nicht_2=false;
        }

        return !noch_nicht_2;
    }

    public String getGewonnenName(){

           if(gewonnen_1()){
                return "X";
           }else if(gewonnen_2()){
                return "O";
            }else{
              return "Unentschieden";
            }

    }
    
    public void setButtons(){
        buttons=funktionen_buttons.getButtonArray();
    }

    public void setButtonsfarbe(){
        setButtons();
        String name="X" ;
      Button[] ubergeben = new Button[3];
        int i = Color.GREEN;
        name=spieler_1.getName();


        int x = 0;
        ubergeben[x]=buttons[0];
        x++;
        ubergeben[x]=buttons[0];
        x++;
        ubergeben[x]=buttons[0];
        x=0;


      
      
            if((array_spielfeld[0][0].equals(name))&&(array_spielfeld[0][1].equals(name))&&(array_spielfeld[0][2].equals(name))){
               ubergeben[x]=buttons[0];
               x++;
               ubergeben[x]=buttons[1];
               x++;
               ubergeben[x]=buttons[2];
               x=0;
                i=Color.RED;
            }else if ((array_spielfeld[1][0].equals(name))&&(array_spielfeld[1][1].equals(name))&&(array_spielfeld[1][2].equals(name))){
                ubergeben[x]=buttons[3];
                x++;
                ubergeben[x]=buttons[4];
                x++;
                ubergeben[x]=buttons[5];
                x=0;
                i = Color.RED;
             }else if ((array_spielfeld[2][0].equals(name))&&(array_spielfeld[2][1].equals(name))&&(array_spielfeld[2][2].equals(name))){
                 ubergeben[x]=buttons[6];
                 x++;
                 ubergeben[x]=buttons[7];
                 x++;
                 ubergeben[x]=buttons[8];
                 x=0;
                i = Color.RED;
              }else if((array_spielfeld[0][0].equals(name))&&(array_spielfeld[1][0].equals(name))&&(array_spielfeld[2][0].equals(name))){
                  ubergeben[x]=buttons[0];
                  x++;
                  ubergeben[x]=buttons[3];
                  x++;
                  ubergeben[x]=buttons[6];
                  x=0;
                i = Color.RED;
               }else if((array_spielfeld[0][1].equals(name))&&(array_spielfeld[1][1].equals(name))&&(array_spielfeld[2][1].equals(name))){
                   ubergeben[x]=buttons[1];
                   x++;
                   ubergeben[x]=buttons[4];
                   x++;
                   ubergeben[x]=buttons[7];
                   x=0;
                i = Color.RED;
                }else if((array_spielfeld[0][2].equals(name))&&(array_spielfeld[1][2].equals(name))&&(array_spielfeld[2][2].equals(name))){
                    ubergeben[x]=buttons[2];
                    x++;
                    ubergeben[x]=buttons[5];
                    x++;
                    ubergeben[x]=buttons[8];
                    x=0;
                i = Color.RED;
                 }else if((array_spielfeld[0][0].equals(name))&&(array_spielfeld[1][1].equals(name))&&(array_spielfeld[2][2].equals(name))){
                     ubergeben[x]=buttons[0];
                     x++;
                     ubergeben[x]=buttons[4];
                     x++;
                     ubergeben[x]=buttons[8];
                     x=0;
                i = Color.RED;
                  }else if((array_spielfeld[2][0].equals(name))&&(array_spielfeld[1][1].equals(name))&&(array_spielfeld[0][2].equals(name))){
                      ubergeben[x]=buttons[6];
                      x++;
                      ubergeben[x]=buttons[4];
                      x++;
                      ubergeben[x]=buttons[2];
                      x=0;
                i = Color.RED;

                   }
        name=spieler_2.getName();

        if((array_spielfeld[0][0].equals(name))&&(array_spielfeld[0][1].equals(name))&&(array_spielfeld[0][2].equals(name))){
                ubergeben[x]=buttons[0];
                x++;
                ubergeben[x]=buttons[1];
                x++;
                ubergeben[x]=buttons[2];
                x=0;
            }else if ((array_spielfeld[1][0].equals(name))&&(array_spielfeld[1][1].equals(name))&&(array_spielfeld[1][2].equals(name))){
                ubergeben[x]=buttons[3];
                x++;
                ubergeben[x]=buttons[4];
                x++;
                ubergeben[x]=buttons[5];
                x=0;
            }else if ((array_spielfeld[2][0].equals(name))&&(array_spielfeld[2][1].equals(name))&&(array_spielfeld[2][2].equals(name))){
                ubergeben[x]=buttons[6];
                x++;
                ubergeben[x]=buttons[7];
                x++;
                ubergeben[x]=buttons[8];
                x=0;
            }else if((array_spielfeld[0][0].equals(name))&&(array_spielfeld[1][0].equals(name))&&(array_spielfeld[2][0].equals(name))){
                ubergeben[x]=buttons[0];
                x++;
                ubergeben[x]=buttons[3];
                x++;
                ubergeben[x]=buttons[6];
                x=0;
            }else if((array_spielfeld[0][1].equals(name))&&(array_spielfeld[1][1].equals(name))&&(array_spielfeld[2][1].equals(name))){
                ubergeben[x]=buttons[1];
                x++;
                ubergeben[x]=buttons[4];
                x++;
                ubergeben[x]=buttons[7];
                x=0;
            }else if((array_spielfeld[0][2].equals(name))&&(array_spielfeld[1][2].equals(name))&&(array_spielfeld[2][2].equals(name))){
                ubergeben[x]=buttons[2];
                x++;
                ubergeben[x]=buttons[5];
                x++;
                ubergeben[x]=buttons[8];
                x=0;
            }else if((array_spielfeld[0][0].equals(name))&&(array_spielfeld[1][1].equals(name))&&(array_spielfeld[2][2].equals(name))){
                ubergeben[x]=buttons[0];
                x++;
                ubergeben[x]=buttons[4];
                x++;
                ubergeben[x]=buttons[8];
                x=0;
            }else if((array_spielfeld[2][0].equals(name))&&(array_spielfeld[1][1].equals(name))&&(array_spielfeld[0][2].equals(name))){
                ubergeben[x]=buttons[6];
                x++;
                ubergeben[x]=buttons[4];
                x++;
                ubergeben[x]=buttons[2];
                x=0;

            }
  
      


                funktionen_buttons.setTextFarbeArray(ubergeben, i);

        }
            

    public String getSpieler1name() {
        return spieler_2.getName();
    }

    public String getSpieler2name(){
        return spieler_1.getName();

    }

    public boolean hatspieler1gewonnen(){
        if (!schongewonnenundubergeben) {
            if (spieler_1.getName().equals("X")) {
                if (gewonnen_1()) {
                    schongewonnenundubergeben=true;
                    return true;

                } else {
                    return false;
                }
            } else if (spieler_1.getName().equals("O")) {
                if (gewonnen_2()) {
                    schongewonnenundubergeben=true;
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }

        }else{
            return false;
        }
    }
    public boolean hatspieler2gewonnen() {
        if (!schongewonnenundubergeben) {
            if (spieler_2.getName().equals("X")) {
                if (gewonnen_1()) {
                    schongewonnenundubergeben = true;
                    return true;

                } else {
                    return false;
                }
            } else if (spieler_2.getName().equals("O")) {
                if (gewonnen_2()) {
                    schongewonnenundubergeben = true;
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }
        }else {
            return false;
        }
    }

}

