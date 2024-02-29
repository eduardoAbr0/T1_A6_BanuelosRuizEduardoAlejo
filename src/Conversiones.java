import java.text.DecimalFormat;

public class Conversiones {
	DecimalFormat df = new DecimalFormat("0.00");
	//KM-MILLAS
	public String kilometrosM(double km) {
		double conversion = km/1.609;
		return df.format(conversion);
	}
	//KM-PIES
	public String kilometrosP(double km) {
		double conversion = km*3281;
		return df.format(conversion);
	}
	//KM-PULGADAS
	public String kilometrosPg(double km) {
		double conversion = km*39370;
		return df.format(conversion);
	}
}
