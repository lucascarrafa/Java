import java.util.Random;

public class Golpes {
	String nomeGolpe;
	double poderOfensivo;
	public Golpes(String nome){
		Random gerador = new Random();
		poderOfensivo = gerador.nextInt(7)+12;
		this.nomeGolpe=nome;
	}
	public Golpes(String nome, int power){
		poderOfensivo = power;
		this.nomeGolpe=nome;
	}	
}
