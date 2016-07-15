package de.torbennils.tictactoe;

import android.widget.Button;

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
    private Main_Activity main = null;
    private Button buttonSpiel1 = null;
    private Button buttonSpiel2 = null;
    private Button buttonSpiel3 = null;
    private Button buttonSpiel4 = null;
    private Button buttonSpiel5 = null;
    private Button buttonSpiel6 = null;
    private Button buttonSpiel7 = null;
    private Button buttonSpiel8 = null;
    private Button buttonSpiel9 = null;


    //**********************************************************************************************************

    public Logik(int anzahl, Main_Activity main){
        this.main = main;
        if (anzahl==1){
            int i =(int)(Math.random()*10);
            if(i>5){
                spieler_1 = new Ki("X");
                spieler_2 = new Spieler("O");
            }else{
                spieler_1 = new Ki("O");
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


    }


    //**********************************************************************************************************

    public void setPosition(int zeile ,int spalte){
        if(isValid(zeile,spalte)){
            if(isTHEREaKI()){
                zustand = 1;
                setzen(zeile,spalte);
                zeichnen_spieler(zeile,spalte,spieler_2);
                if(!gewonnen()){
                    setzen_Ki();
                    zeichnen_Ki();
                }

            }else{
                if (zustand_spieler==0){
                    setzen(zeile,spalte);
                    zeichnen_spieler(zeile,spalte,spieler_1);
                    zustand_spieler ++;
                }else{
                    setzen(zeile,spalte);
                    zeichnen_spieler(zeile,spalte,spieler_2);
                    zustand_spieler --;
                }

            }
        }

    }

    private void zeichnen_Ki() {
        if(zustand_gewonnen==0){
            main.setZeichnen(spieler_1.getZeile(),spieler_1.getSpalte(),spieler_1.getName());
        }
        if(gewonnen()){
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
            spieler_1.setString(array_spielfeld);
            spieler_1.setzten(zeile_setzen,spalte_setzen);
            array_spielfeld=spieler_1.getString();
            zustand++;
        }else if (zustand==1){
            spieler_2.setString(array_spielfeld);
            spieler_2.setzten(zeile_setzen,spalte_setzen);
            array_spielfeld=spieler_2.getString();
            zustand--;
        }

    }

    private void zeichnen_spieler(int zeile_zeichnen, int spalte_zeichnen,Spieler i){
        if(zustand_gewonnen==0){
            main.setZeichnen(zeile_zeichnen, spalte_zeichnen,i.getName());
        }
        if(gewonnen()){
            zustand_gewonnen=1;
        }

    }



    private boolean isTHEREaKI(){
        if(spieler_1 instanceof Ki){
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
        if(gewonnen_1()||gewonnen_2()){
            gewonnen_boolean=true;
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
                return "0";
            }else{
            	return "Unentschieden";
            }
        
    }
    
    public void setButtons(Button buttonSpiel1,Button buttonSpiel2,Button buttonSpiel3,Button buttonSpiel4,Button buttonSpiel5,Button buttonSpiel6,Button buttonSpiel7,Button buttonSpiel8,Button buttonSpiel9){
       this.buttonSpiel1 = buttonSpiel1;
       this.buttonSpiel2 = buttonSpiel2;
       this.buttonSpiel3 = buttonSpiel3;
       this.buttonSpiel4 = buttonSpiel4;
       this.buttonSpiel5 = buttonSpiel5;
       this.buttonSpiel6 = buttonSpiel6;
       this.buttonSpiel7 = buttonSpiel7;
       this.buttonSpiel8 = buttonSpiel8;
       this.buttonSpiel9 = buttonSpiel9;

    }
    
    public Button[] getButtons(){
    	Button[] �bergeben = new Button[3];
    	String name="X" ;
    	int x = 0;
    	
    	
            if((array_spielfeld[0][0].equals(name))&&(array_spielfeld[0][1].equals(name))&&(array_spielfeld[0][2].equals(name))){
               �bergeben[x]=buttonSpiel1;
               x++;
               �bergeben[x]=buttonSpiel2;
               x++;
               �bergeben[x]=buttonSpiel3;
               x=0;
            }else if ((array_spielfeld[1][0].equals(name))&&(array_spielfeld[1][1].equals(name))&&(array_spielfeld[1][2].equals(name))){
                �bergeben[x]=buttonSpiel4;
                x++;
                �bergeben[x]=buttonSpiel5;
                x++;
                �bergeben[x]=buttonSpiel6;
                x=0;
             }else if ((array_spielfeld[2][0].equals(name))&&(array_spielfeld[2][1].equals(name))&&(array_spielfeld[2][2].equals(name))){
                 �bergeben[x]=buttonSpiel7;
                 x++;
                 �bergeben[x]=buttonSpiel8;
                 x++;
                 �bergeben[x]=buttonSpiel9;
                 x=0;
              }else if((array_spielfeld[0][0].equals(name))&&(array_spielfeld[1][0].equals(name))&&(array_spielfeld[2][0].equals(name))){
                  �bergeben[x]=buttonSpiel1;
                  x++;
                  �bergeben[x]=buttonSpiel4;
                  x++;
                  �bergeben[x]=buttonSpiel7;
                  x=0;
               }else if((array_spielfeld[0][1].equals(name))&&(array_spielfeld[1][1].equals(name))&&(array_spielfeld[2][1].equals(name))){
                   �bergeben[x]=buttonSpiel2;
                   x++;
                   �bergeben[x]=buttonSpiel5;
                   x++;
                   �bergeben[x]=buttonSpiel8;
                   x=0;
                }else if((array_spielfeld[0][2].equals(name))&&(array_spielfeld[1][2].equals(name))&&(array_spielfeld[2][2].equals(name))){
                    �bergeben[x]=buttonSpiel3;
                    x++;
                    �bergeben[x]=buttonSpiel6;
                    x++;
                    �bergeben[x]=buttonSpiel9;
                    x=0;
                 }else if((array_spielfeld[0][0].equals(name))&&(array_spielfeld[1][1].equals(name))&&(array_spielfeld[2][2].equals(name))){
                     �bergeben[x]=buttonSpiel1;
                     x++;
                     �bergeben[x]=buttonSpiel5;
                     x++;
                     �bergeben[x]=buttonSpiel9;
                     x=0;
                  }else if((array_spielfeld[2][0].equals(name))&&(array_spielfeld[1][1].equals(name))&&(array_spielfeld[0][2].equals(name))){
                      �bergeben[x]=buttonSpiel7;
                      x++;
                      �bergeben[x]=buttonSpiel5;
                      x++;
                      �bergeben[x]=buttonSpiel3;
                      x=0;
                   }
  
    	
    	
    	return �bergeben;
    }
    
}
