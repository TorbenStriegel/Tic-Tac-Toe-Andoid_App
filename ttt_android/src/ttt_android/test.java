package ttt_android;

public class test {

	public static void main(String[] args) {
		Logik logisch  = new Logik(1);
		logisch.setPosition(1, 1);
		logisch.setPosition(1, 2);
		

	}
	
	public static void setzeichnen(int i  ,int b){
		System.out.println("Zeile: "+i+" Spalte: "+b);
		System.out.println(FromZeileSpalteIntoButton.umrechnen(i,b));
	}

}
