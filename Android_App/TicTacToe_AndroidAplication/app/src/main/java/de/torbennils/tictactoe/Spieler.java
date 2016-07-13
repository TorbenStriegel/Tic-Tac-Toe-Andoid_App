package de.torbennils.tictactoe;

/**
 * Created by Torben on 13.07.2016.
 */

public class Spieler {
    protected String name;
    protected String [][] zeichnen = {{" "," "," "},{" "," "," "},{" "," "," "}};
    protected int zeile_rück = 0;
    protected int spalte_rück = 0;
    public Spieler (String x_o){
        name= x_o;
    }

    public void setString(String[][] i){
        zeichnen =i;
    }

    public String[][] getString(){
        return zeichnen;
    }
    public void setzten(int zeile, int spalte){
        if(zeichnen[zeile][spalte].equals(" ")){
            zeichnen[zeile][spalte] = name;
            zeile_rück = zeile;
            spalte_rück = spalte;
        }


    }

    public String getName(){
        return name;
    }
    public int getZeile(){
        return zeile_rück;
    }
    public int getSpalte(){
        return spalte_rück;
    }

}
