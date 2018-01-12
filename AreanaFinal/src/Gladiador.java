import java.util.*;

public class Gladiador extends Lutador {
	int poderAtaque;
	ArrayList<Arma> armas = new ArrayList<Arma>();
	ArrayList<Armadura> armaduras = new ArrayList<Armadura>();
	
	public Gladiador(){
		Random geradorPoder = new Random();
		this.poderAtaque = geradorPoder.nextInt(3)+8;
		this.armas.add(new Arma(1));
		this.armas.add(new Arma());
		this.armas.add(new Arma());
		this.armaduras.add(new Armadura());
	}
	public double chutar(){
		System.out.println("Gladiador ataca com chute");
		return poderAtaque+3;
	}
	public double usarArma(){
		Random gerador = new Random();
		int i=gerador.nextInt(armas.size());
		Arma arma= (armas.get(i));
		System.out.println("Gladiador usa "+(arma.golpesArma.get(0)).nomeGolpe+" da "+arma.descricao);
		double power = (arma.golpesArma.get(0)).poderOfensivo;
		if(arma.descricao=="Bomba"){
			this.armas.remove(i);
		}
		return power;
	}	
	public void atacar(Personagem p){ 
		Random gerador = new Random();
		if(gerador.nextInt(2)==1){
			p.defender(this.chutar());
		}else{
			p.defender(this.usarArma());
		}
	}public void esquivar(double dmg, Armadura arm){
		Random esquiva = new Random();
		if(esquiva.nextInt(5)>0){
			if(dmg>=arm.poderDefesa){
				System.out.println("Gladiador nao esquivou");
				this.nivelEnergia-=(dmg-arm.poderDefesa);
				arm.estadoConservacao-=arm.poderDefesa;
				System.out.println("Gladiador recebeu "+dmg+" de dano");
			}
			else{
				arm.estadoConservacao-=dmg;
			}
		}
		else{
			System.out.println("Gladiador esquivou do ataque");
		}
	}
	
	public void fazerGuarda(double dmg, Armadura arm){
		Random geradorDefesa = new Random();
		double defesa = geradorDefesa.nextInt(5)+1;
		if(dmg>=arm.poderDefesa){
			if((dmg-arm.poderDefesa)>defesa){
				System.out.println("Gladiador defende ataque");
				this.nivelEnergia-=(dmg-arm.poderDefesa-defesa);
				arm.estadoConservacao-=arm.poderDefesa;
				System.out.println("Gladiador recebeu "+(dmg-arm.poderDefesa-defesa)+" de dano");
			}
			else{
				System.out.println("Gladiador nao sente ataque");
				arm.estadoConservacao-=arm.poderDefesa;
			}
		}
		else{
			System.out.println("Gladiador nao sente ataque");
			arm.estadoConservacao-=dmg;
		}
	}
	
	public void defender(double d){
		Random gerador = new Random();
		if(gerador.nextInt(2)==1){
			this.fazerGuarda(d,this.armaduras.get(gerador.nextInt((armaduras.size()))));
		}
		else{
			this.esquivar(d,this.armaduras.get(gerador.nextInt((armaduras.size()))));
		}
	}
}
