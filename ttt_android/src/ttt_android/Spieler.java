package ttt_android;


public class Spieler {
	protected String name;
	protected String [][] zeichnen = {{" "," "," "},{" "," "," "},{" "," "," "}};
	protected int zeile_r�ck = 0;
	protected int spalte_r�ck = 0;
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
			zeile_r�ck = zeile;
			spalte_r�ck = spalte;
		}
		
		
	}
	
	public String getName(){
		return name;
	}
	public int getZeile(){
		return zeile_r�ck;
	}
	public int getSpalte(){
		return spalte_r�ck;
	}
	
}
