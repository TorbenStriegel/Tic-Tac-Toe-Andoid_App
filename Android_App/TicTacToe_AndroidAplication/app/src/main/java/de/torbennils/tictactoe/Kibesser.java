package de.torbennils.tictactoe;

/**
 * Created by Nils on 18.07.2016.
 */

public class Kibesser extends Ki {
    public Kibesser(String x_o) {
        super(x_o);
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

//*********************************************************************************************************************
        for (int i = 0; i <3; i++) {
            if(!gezeichnet){
                if(((zeichnen[i][2].equals(name))&&(zeichnen[i][1].equals(name)))||((zeichnen[i][0].equals(name))&&(zeichnen[i][1].equals(name)))||((zeichnen[i][2].equals(name))&&(zeichnen[i][0].equals(name)))){
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
                if(((zeichnen[2][i].equals(name))&&(zeichnen[1][i].equals(name)))||((zeichnen[0][i].equals(name))&&(zeichnen[1][i].equals(name)))||((zeichnen[2][i].equals(name))&&(zeichnen[0][i].equals(name)))){
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
                if(((zeichnen[0][0].equals(name))&&(zeichnen[1][1].equals(name)))||((zeichnen[0][0].equals(name))&&(zeichnen[2][2].equals(name)))||((zeichnen[2][2].equals(name))&&(zeichnen[1][1].equals(name)))){
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
                if(((zeichnen[0][2].equals(name))&&(zeichnen[1][1].equals(name)))||((zeichnen[0][2].equals(name))&&(zeichnen[2][0].equals(name)))||((zeichnen[0][2].equals(name))&&(zeichnen[1][1].equals(name)))){
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

}