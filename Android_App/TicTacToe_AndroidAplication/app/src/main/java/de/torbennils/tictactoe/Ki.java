package de.torbennils.tictactoe;

/**
 * Created by Torben on 13.07.2016.
 */

public class Ki extends Spieler{
    private String name;
    private String [][] zeichnen = {{" "," "," "},{" "," "," "},{" "," "," "}};
    private boolean gezeichnet =false;
    private int zeile = 10;
    private int spalte = 10;
    private String name_nicht ;
    public Ki(String x_o) {
        super(x_o);
        if(x_o.equals("O")){
            name_nicht = "X";
        }else{
            name_nicht = "O";
        }

        name = x_o;
    }

    public void setString(String[][] i){
        zeichnen =i;
    }

    public String[][] getString(){
        return zeichnen;
    }
    public void setzten(int zeile_1, int spalte_1){
        int zusammen  = zeile_1 +spalte_1;
        gezeichnet = false;



        for (int i = 0; i <3; i++) {
        	 if(!gezeichnet){
            if(((zeichnen[i][2].equals(name_nicht))&&(zeichnen[i][1].equals(name_nicht)))||((zeichnen[i][0].equals(name_nicht))&&(zeichnen[i][1].equals(name_nicht)))||((zeichnen[i][2].equals(name_nicht))&&(zeichnen[i][0].equals(name_nicht)))){
                if(zeichnen[i][0].equals(" ")){
                    zeichnen[i][0] = name;
                    zeile = i;
                    spalte = 0;
                    gezeichnet = true;
                }else if(zeichnen[i][1].equals(" ")){
                    zeichnen[i][1] = name;
                    zeile = i;
                    spalte = 1;
                    gezeichnet = true;
                }else if(zeichnen[i][2].equals(" ")){
                    zeichnen[i][2] = name;
                    zeile = i;
                    spalte = 2;
                    gezeichnet = true;
                }

            }
        	 }
        	 if(!gezeichnet){
        	 if(((zeichnen[2][i].equals(name_nicht))&&(zeichnen[1][i].equals(name_nicht)))||((zeichnen[0][i].equals(name_nicht))&&(zeichnen[1][i].equals(name_nicht)))||((zeichnen[2][i].equals(name_nicht))&&(zeichnen[0][i].equals(name_nicht)))){
                if(zeichnen[0][i].equals(" ")){
                    zeichnen[0][i] = name;
                    zeile = 0;
                    spalte = i;
                    gezeichnet = true;
                }else if(zeichnen[1][i].equals(" ")){
                    zeichnen[1][i] = name;
                    zeile = 1;
                    spalte = i;
                    gezeichnet = true;
                }else if(zeichnen[2][i].equals(" ")){
                    zeichnen[2][i] = name;
                    zeile = 2;
                    spalte = i;
                    gezeichnet = true;
                }

            }
        	 }
        	 if(!gezeichnet){
        	 if(((zeichnen[0][0].equals(name_nicht))&&(zeichnen[1][1].equals(name_nicht)))||((zeichnen[0][0].equals(name_nicht))&&(zeichnen[2][2].equals(name_nicht)))||((zeichnen[2][2].equals(name_nicht))&&(zeichnen[1][1].equals(name_nicht)))){
                if(zeichnen[0][0].equals(" ")){
                    zeichnen[0][0] = name;
                    zeile = 0;
                    spalte = 0;
                    gezeichnet=true;
                }else if(zeichnen[1][1].equals(" ")){
                    zeichnen[1][1] = name;
                    zeile = 1;
                    spalte = 1;
                    gezeichnet =true;
                }else if(zeichnen[2][2].equals(" ")) {
                    zeichnen[2][2] = name;
                    zeile = 2;
                    spalte = 2;
                    gezeichnet = true;
                }

            }
        	 }
        	 if(!gezeichnet){
        	 if(((zeichnen[0][2].equals(name_nicht))&&(zeichnen[1][1].equals(name_nicht)))||((zeichnen[0][2].equals(name_nicht))&&(zeichnen[2][0].equals(name_nicht)))||((zeichnen[0][2].equals(name_nicht))&&(zeichnen[1][1].equals(name_nicht)))){
                if(zeichnen[0][2].equals(" ")){
                    zeichnen[0][2] = name;
                    zeile = 0;
                    spalte = 2;
                    gezeichnet = true;
                }else if(zeichnen[1][1].equals(" ")){
                    zeichnen[1][1] = name;
                    zeile = 1;
                    spalte = 1;
                    gezeichnet = true;
                }else if(zeichnen[2][0].equals(" ")){
                    zeichnen[2][0] = name;
                    zeile = 2;
                    spalte = 0;
                    gezeichnet = true;
                }

            }
        }
        }

        if(!gezeichnet){
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


    public int getZeile(){
        return zeile;
    }

    public int getSpalte(){
        return spalte;
    }





    public String getName(){
        return name;
    }

}
