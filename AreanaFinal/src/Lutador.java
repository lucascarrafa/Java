import java.util.Random;

public class Lutador extends Personagem implements ArteMarcial{
	int poderAtaque;
	
	public Lutador(){
		Random geradorPoder = new Random();
		poderAtaque = geradorPoder.nextInt(8)+8;
	}
	
	public double socar(){
		System.out.println("Lutador ataca com soco");
		return poderAtaque;
	}
	
	public double chutar(){
		System.out.println("Lutador ataca com chute");
		return poderAtaque+3;
	}
	
	public void esquivar(double d){
		Random esquiva = new Random();
		if(esquiva.nextInt(3)>0){
			System.out.println("Lutador nao esquivou");
			this.nivelEnergia-=d;
			System.out.println("Lutador recebeu "+d+" de dano");
			
		}
		else{
			System.out.println("Lutador esquivou do ataque");
		}
	}
	
	public void fazerGuarda(double d){
		Random geradorDefesa = new Random();
		double defesa = geradorDefesa.nextInt(7);
		if(d>defesa){
			System.out.println("Lutador defende ataque");
			this.nivelEnergia-=(d-defesa);
			System.out.println("Lutador recebeu "+(d-defesa)+" de dano");
		}
		else{
			System.out.println("Lutador nao sente ataque");
		}
	}
	
	@Override
	public double taiOtoshi() {
		System.out.println("Lutador ataca com taiOtoshi");
		return poderAtaque+5;
	}

	@Override
	public double tateZuki() {
		System.out.println("Lutador ataca com tateZuki");
		return poderAtaque+8;
	}

	@Override
	public double Ippon() {
		System.out.println("Lutador ataca com Ippon");
		return poderAtaque+10;
	}
	
	public void atacar(Personagem p){
		Random gerador = new Random();
		int a = gerador.nextInt(5);
		if(a==0){
			p.defender(this.chutar());
		}
		if(a==1){
			p.defender(this.socar());
		}
		if(a==2){
			p.defender(this.taiOtoshi());
		}
		if(a==3){
			p.defender(this.Ippon());
		}
		if(a==4){
			p.defender(this.tateZuki());
		}
	}
	
	public void defender(double d){
		Random gerador = new Random();
		if(gerador.nextInt(2)==1){
			this.fazerGuarda(d);
		}
		else{
			this.esquivar(d);
		}
	}

}
