package ttt_android;

public class FromZeileSpalteIntoButton {
	private static int zeile =10;
	private static int spalte = 10;
	private static String name = "Name";
	
	
	private static String umrechnen(int zeile_üb, int spalte_üb){
		zeile = zeile_üb;
		spalte = spalte_üb;
		if (zeile ==0 &&spalte==0){
			name= "Button1";
		}else if (zeile ==0 &&spalte==1){
			name= "Button2";
		}else if (zeile ==0 &&spalte==2){
			name= "Button3";
		}else if (zeile ==1 &&spalte==0){
			name= "Button4";
		}else if (zeile ==1 &&spalte==1){
			name= "Button5";
		}else if (zeile ==1 &&spalte==2){
			name= "Button6";
		}else if (zeile ==2 &&spalte==0){
			name= "Button7";
		}else if (zeile ==2 &&spalte==1){
			name= "Button8";
		}else if (zeile ==2 &&spalte==2){
			name= "Button9";
		}
		return name;
	}
}
