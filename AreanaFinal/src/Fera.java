import java.util.Random;

public class Fera extends Personagem{
	int poderAtaque = 0;
	
	public Fera(){
		Random geradorPoder = new Random();
		poderAtaque = geradorPoder.nextInt(11)+10 ;
	}
	
	public double morder() {
		System.out.println("Fera morde");
		return poderAtaque+10;
	}
	
	public double usarGarra() {
		System.out.println("Fera ataca com garra");
		return poderAtaque;
	}
	
	public void atacar(Personagem p) {
		Random gerador = new Random();
		if(gerador.nextInt(2) == 0) {
			p.defender(this.morder());
		}
		else {
			p.defender(this.usarGarra());
		}
	}
	public void esquivar(double d){
		Random esquiva = new Random();
		if(esquiva.nextInt(4)>0){
			System.out.println("Fera nao esquivou");
			this.nivelEnergia-=d;
			System.out.println("Fera recebeu "+d+" de dano");
			
		}
		else{
			System.out.println("Fera esquivou do ataque");
		}
	}
	public void defender(double d){
		this.esquivar(d);
	}
}
