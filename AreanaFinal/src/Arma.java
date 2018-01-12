import java.util.*;

public class Arma implements Fogo, Perfurante, EfeitoMoral {
	String descricao;
	ArrayList<Golpes> golpesArma = new ArrayList<Golpes>();
	public Arma(){
		Random gerador = new Random();
		int tipo = gerador.nextInt(3);
		if(tipo==0){
			this.descricao="Bomba";
			this.golpesArma.add(explodir());
		}
		if(tipo==1){
			this.descricao="ArmadeFogo";
			this.golpesArma.add(atirar());
		}
		if(tipo==2){
			this.descricao="lanca";
			this.golpesArma.add(perfurar());
		}
		
	}
	public Arma(int x){
		this.descricao="espada";
		this.golpesArma.add(new Golpes("cortar"));
	}
	@Override
	public Golpes explodir() {
		return new Golpes("explodir", 25);
	}
	@Override
	public Golpes perfurar() {
		return new Golpes("perfurar", 15);
	}
	@Override
	public Golpes atirar() {
		return new Golpes("atirar", 18);
	}
}
