package de.torbennils.tictactoe;

/**
 * Created by Torben on 13.07.2016.
 */

public class Logik {
    private String [][] array_spielfeld = {{" "," "," "},{" "," "," "},{" "," "," "}};
    private Spieler spieler_1;
    private Spieler spieler_2;
    private boolean gewonnen_boolean = false;
    private int zustand=0;

    //**********************************************************************************************************

    public Logik(int anzahl){
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
                zeichnen_spieler(zeile,spalte);
                if(!gewonnen()){
                    setzen_Ki();
                    zeichnen_Ki();
                }

            }else{
                setzen(zeile,spalte);
                zeichnen_spieler(zeile,spalte);
            }
        }

    }

    private void zeichnen_Ki() {

        Main_Activity.setZeichnen(spieler_1.getZeile(),spieler_1.getSpalte());
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

    private void zeichnen_spieler(int zeile_zeichnen, int spalte_zeichnen){

       Main_Activity.setZeichnen(zeile_zeichnen, spalte_zeichnen);
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
        if(gewonnen_1()&&gewonnen_1()){
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
}
