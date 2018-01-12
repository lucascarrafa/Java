
public abstract class Personagem {
	double nivelEnergia = 100;
	
	public boolean estarVivo(){
		if(nivelEnergia>0){
			return true;
		}else{
			return false;
		}
	}
	
	public void atacar(Personagem p){	
	}
	
	public void defender(double d){
	}
}