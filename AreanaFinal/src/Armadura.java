import java.util.*;

public class Armadura {
	double poderDefesa;
	double estadoConservacao;
	public Armadura(){
		Random gerador = new Random();
		poderDefesa = gerador.nextInt(7)+1;
		estadoConservacao= gerador.nextInt(50)+50;
	}
}
