package de.torbennils.tictactoe;

/**
 * Created by Nils on 18.07.2016.
 */

public class KiCracy extends Ki {
    public KiCracy(String x_o) {
        super(x_o);
    }

    public void setzten(int zeile_1, int spalte_1){
        int zusammen  = zeile_1 +spalte_1;

            int j = (int) (Math.random()*3);
            int k = (int) (Math.random()*3);

            if(zeichnen[j][k].equals(" ")){
                zeichnen[j][k] = name;
                zeile = j;
                spalte = k;
            }else{

                while (!(zeichnen[j][k].equals(" "))){

                    j = (int) (Math.random()*3);
                    k = (int) (Math.random()*3);
                    if(zeichnen[j][k].equals(" ")){
                        zeichnen[j][k] = name;
                        zeile = j;
                        spalte = k;
                        break;

                    }

                }

            }
        }


}
