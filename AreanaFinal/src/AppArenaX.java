import java.util.*;

public class AppArenaX {

	public static void main(String[] args) {
		Random geraLutador = new Random();
		Random geraGradiador = new Random();
		Random geraFera = new Random();
		ArrayList<Personagem> guerreiros = new ArrayList<Personagem>();
		int l = geraLutador.nextInt(11)+5;
		Lutador[] lutador = new Lutador[l];
		for(int a=0;a<l;a++){
			lutador[a] = new Lutador();
			guerreiros.add(lutador[a]);
		}
		int g = geraGradiador.nextInt(11)+5;
		Gladiador[] gradiador = new Gladiador[g];
		for(int b=0;b<g;b++){
			gradiador[b] = new Gladiador();
			guerreiros.add(gradiador[b]);
		}
		int f = geraFera.nextInt(11)+10;
		Fera[] fera = new Fera[f];
		for(int c=0;c<f;c++){
			fera[c] = new Fera();
			guerreiros.add(fera[c]);
		}
		Collections.shuffle(guerreiros);
		int i,j;
		while(guerreiros.size()>1){
			System.out.println("\n\nGuerreiros vivos: "+guerreiros.size()+"\n");
			if((guerreiros.size()%2)==0){
				for(i=0;(i+2)<=guerreiros.size();i+=2){
					while(((guerreiros.get(i)).estarVivo())&&((guerreiros.get(i+1)).estarVivo())){
						(guerreiros.get(i)).atacar((guerreiros.get(i+1)));
						(guerreiros.get(i+1)).atacar((guerreiros.get(i)));
						if((guerreiros.get(i)) instanceof Gladiador){
							for(j=0;j<((Gladiador)(guerreiros.get(i))).armaduras.size();j++){
								if(0>=(((Gladiador)(guerreiros.get(i))).armaduras.get(j)).estadoConservacao){
									(((Gladiador)(guerreiros.get(i))).armaduras.get(j)).poderDefesa=0;
									(((Gladiador)(guerreiros.get(i))).armaduras.get(j)).estadoConservacao=0;
								}
							}
						}
						if((guerreiros.get(i+1)) instanceof Gladiador){
							for(j=0;j<((Gladiador)(guerreiros.get(i+1))).armaduras.size();j++){
								if(0>=(((Gladiador)(guerreiros.get(i+1))).armaduras.get(j)).estadoConservacao){
									(((Gladiador)(guerreiros.get(i+1))).armaduras.get(j)).poderDefesa=0;
									(((Gladiador)(guerreiros.get(i+1))).armaduras.get(j)).estadoConservacao=0;
								}
							}
						}
						if(((guerreiros.get(i)).nivelEnergia)>0){
							System.out.println("HP de combatente A: "+(guerreiros.get(i)).nivelEnergia);
							if((guerreiros.get(i)) instanceof Gladiador){
								System.out.println("Armaduras de combatente A:");
								for(j=0;j<((Gladiador)(guerreiros.get(i))).armaduras.size();j++){
									System.out.println((((Gladiador)(guerreiros.get(i))).armaduras.get(j)).estadoConservacao);
								}
							}
						}
						else{
							System.out.println("Combatente A Faleceu!\n");
						}
						if(((guerreiros.get(i+1)).nivelEnergia)>0){
							System.out.println("HP de combatente B: "+(guerreiros.get(i+1)).nivelEnergia);
							if((guerreiros.get(i+1)) instanceof Gladiador){
								System.out.println("Armaduras de combatente B:");
								for(j=0;j<((Gladiador)(guerreiros.get(i+1))).armaduras.size();j++){
									System.out.println((((Gladiador)(guerreiros.get(i+1))).armaduras.get(j)).estadoConservacao);
								}
							}
						}
						else{
							System.out.println("Combatente B faleceu!\n");
						}
						
					}
					if(((guerreiros.get(i)) instanceof Gladiador)&&((guerreiros.get(i+1) instanceof Gladiador))){
						if((guerreiros.get(i)).estarVivo()){
							while(0<((Gladiador)(guerreiros.get(i+1))).armaduras.size()){
								((Gladiador)(guerreiros.get(i))).armaduras.add(((Gladiador)(guerreiros.get(i+1))).armaduras.get(0));
								((Gladiador)(guerreiros.get(i+1))).armaduras.remove(0);
							}
							while(0<((Gladiador)(guerreiros.get(i+1))).armas.size()){
								((Gladiador)(guerreiros.get(i))).armas.add(((Gladiador)(guerreiros.get(i+1))).armas.get(0));
								((Gladiador)(guerreiros.get(i+1))).armas.remove(0);
							}
							
						}
						else{
							while(0<((Gladiador)(guerreiros.get(i))).armaduras.size()){
								((Gladiador)(guerreiros.get(i+1))).armaduras.add(((Gladiador)(guerreiros.get(i))).armaduras.get(0));
								((Gladiador)(guerreiros.get(i))).armaduras.remove(0);
							}
							while(0<((Gladiador)(guerreiros.get(i))).armas.size()){
								((Gladiador)(guerreiros.get(i+1))).armas.add(((Gladiador)(guerreiros.get(i))).armas.get(0));
								((Gladiador)(guerreiros.get(i))).armas.remove(0);
							}
						}
					}
				}
			}
			else{
				for(i=0;(i+1)<guerreiros.size();i+=2){
					while(((guerreiros.get(i)).estarVivo())&&((guerreiros.get(i+1)).estarVivo())){
						(guerreiros.get(i)).atacar((guerreiros.get(i+1)));
						(guerreiros.get(i+1)).atacar((guerreiros.get(i)));
						if((guerreiros.get(i)) instanceof Gladiador){
							for(j=0;j<((Gladiador)(guerreiros.get(i))).armaduras.size();j++){
								if(0>=(((Gladiador)(guerreiros.get(i))).armaduras.get(j)).estadoConservacao){
									(((Gladiador)(guerreiros.get(i))).armaduras.get(j)).poderDefesa=0;
									(((Gladiador)(guerreiros.get(i))).armaduras.get(j)).estadoConservacao=0;
								}
							}
						}
						if((guerreiros.get(i+1)) instanceof Gladiador){
							for(j=0;j<((Gladiador)(guerreiros.get(i+1))).armaduras.size();j++){
								if(0>=(((Gladiador)(guerreiros.get(i+1))).armaduras.get(j)).estadoConservacao){
									(((Gladiador)(guerreiros.get(i+1))).armaduras.get(j)).poderDefesa=0;
									(((Gladiador)(guerreiros.get(i+1))).armaduras.get(j)).estadoConservacao=0;
								}
							}
						}
						if(((guerreiros.get(i)).nivelEnergia)>0){
							System.out.println("HP de combatente A: "+(guerreiros.get(i)).nivelEnergia);
							if((guerreiros.get(i)) instanceof Gladiador){
								System.out.println("Armaduras de combatente A:");
								for(j=0;j<((Gladiador)(guerreiros.get(i))).armaduras.size();j++){
									System.out.println((((Gladiador)(guerreiros.get(i))).armaduras.get(j)).estadoConservacao);
								}
							}
						}
						else{
							System.out.println("Combatente A Faleceu!\n");
						}
						if(((guerreiros.get(i+1)).nivelEnergia)>0){
							System.out.println("HP de combatente B: "+(guerreiros.get(i+1)).nivelEnergia);
							if((guerreiros.get(i+1)) instanceof Gladiador){
								System.out.println("Armaduras de combatente B:");
								for(j=0;j<((Gladiador)(guerreiros.get(i+1))).armaduras.size();j++){
									System.out.println((((Gladiador)(guerreiros.get(i+1))).armaduras.get(j)).estadoConservacao);
								}
							}
						}
						else{
							System.out.println("Combatente B faleceu!\n");
						}
					}
					if(((guerreiros.get(i)) instanceof Gladiador)&&((guerreiros.get(i+1) instanceof Gladiador))){
						if((guerreiros.get(i)).estarVivo()){
							while(0<((Gladiador)(guerreiros.get(i+1))).armaduras.size()){
								((Gladiador)(guerreiros.get(i))).armaduras.add(((Gladiador)(guerreiros.get(i+1))).armaduras.get(0));
								((Gladiador)(guerreiros.get(i+1))).armaduras.remove(0);
							}
							while(0<((Gladiador)(guerreiros.get(i+1))).armas.size()){
								((Gladiador)(guerreiros.get(i))).armas.add(((Gladiador)(guerreiros.get(i+1))).armas.get(0));
								((Gladiador)(guerreiros.get(i+1))).armas.remove(0);
							}
							
						}
						else{
							while(0<((Gladiador)(guerreiros.get(i))).armaduras.size()){
								((Gladiador)(guerreiros.get(i+1))).armaduras.add(((Gladiador)(guerreiros.get(i))).armaduras.get(0));
								((Gladiador)(guerreiros.get(i))).armaduras.remove(0);
							}
							while(0<((Gladiador)(guerreiros.get(i))).armas.size()){
								((Gladiador)(guerreiros.get(i+1))).armas.add(((Gladiador)(guerreiros.get(i))).armas.get(0));
								((Gladiador)(guerreiros.get(i))).armas.remove(0);
							}
						}
					}
				}
				Collections.shuffle(guerreiros);
			}
			if((guerreiros.size()<=3)&&(guerreiros.size()>1)){
				while(((guerreiros.get(0)).estarVivo())&&((guerreiros.get(1)).estarVivo())){
					(guerreiros.get(0)).atacar((guerreiros.get(1)));
					(guerreiros.get(1)).atacar((guerreiros.get(0)));
					if((guerreiros.get(0)) instanceof Gladiador){
						for(j=0;j<((Gladiador)(guerreiros.get(0))).armaduras.size();j++){
							if(0>=(((Gladiador)(guerreiros.get(0))).armaduras.get(j)).estadoConservacao){
								(((Gladiador)(guerreiros.get(0))).armaduras.get(j)).poderDefesa=0;
								(((Gladiador)(guerreiros.get(0))).armaduras.get(j)).estadoConservacao=0;
							}
						}
					}
					if((guerreiros.get(1)) instanceof Gladiador){
						for(j=0;j<((Gladiador)(guerreiros.get(1))).armaduras.size();j++){
							if(0>=(((Gladiador)(guerreiros.get(1))).armaduras.get(j)).estadoConservacao){
								(((Gladiador)(guerreiros.get(1))).armaduras.get(j)).poderDefesa=0;
								(((Gladiador)(guerreiros.get(1))).armaduras.get(j)).estadoConservacao=0;
							}
						}
					}
					if(((guerreiros.get(i)).nivelEnergia)>0){
						System.out.println("HP de combatente A: "+(guerreiros.get(i)).nivelEnergia);
						if((guerreiros.get(0)) instanceof Gladiador){
							System.out.println("Armaduras de combatente A:");
							for(j=0;j<((Gladiador)(guerreiros.get(0))).armaduras.size();j++){
								System.out.println((((Gladiador)(guerreiros.get(0))).armaduras.get(j)).estadoConservacao);
							}
						}
					}
					else{
						System.out.println("Combatente A Faleceu!\n");
					}
					if(((guerreiros.get(1)).nivelEnergia)>0){
						System.out.println("HP de combatente B: "+(guerreiros.get(1)).nivelEnergia);
						if((guerreiros.get(1)) instanceof Gladiador){
							System.out.println("Armaduras de combatente B:");
							for(j=0;j<((Gladiador)(guerreiros.get(1))).armaduras.size();j++){
								System.out.println((((Gladiador)(guerreiros.get(1))).armaduras.get(j)).estadoConservacao);
							}
						}
					}
					else{
						System.out.println("Combatente B faleceu!\n");
					}
				}
				if(((guerreiros.get(0)) instanceof Gladiador)&&((guerreiros.get(1) instanceof Gladiador))){
					if((guerreiros.get(0)).estarVivo()){
						while(0<((Gladiador)(guerreiros.get(1))).armaduras.size()){
							((Gladiador)(guerreiros.get(0))).armaduras.add(((Gladiador)(guerreiros.get(1))).armaduras.get(0));
							((Gladiador)(guerreiros.get(1))).armaduras.remove(0);
						}
						while(0<((Gladiador)(guerreiros.get(1))).armas.size()){
							((Gladiador)(guerreiros.get(0))).armas.add(((Gladiador)(guerreiros.get(1))).armas.get(0));
							((Gladiador)(guerreiros.get(1))).armas.remove(0);
						}
						
					}
					else{
						while(0<((Gladiador)(guerreiros.get(0))).armaduras.size()){
							((Gladiador)(guerreiros.get(1))).armaduras.add(((Gladiador)(guerreiros.get(0))).armaduras.get(0));
							((Gladiador)(guerreiros.get(0))).armaduras.remove(0);
						}
						while(0<((Gladiador)(guerreiros.get(0))).armas.size()){
							((Gladiador)(guerreiros.get(1))).armas.add(((Gladiador)(guerreiros.get(0))).armas.get(0));
							((Gladiador)(guerreiros.get(0))).armas.remove(0);
						}
					}
				}
			}
			for(i=0;i<guerreiros.size();i++){
				if((guerreiros.get(i)).estarVivo()==false){
					guerreiros.remove(i);
					i--;
				}
			}
		}
		if(guerreiros.size()==0){
			System.out.println("Deu ruim!");
			System.out.println("CRUEL eh bom!");
		}
		else{
			if(guerreiros.get(0) instanceof Fera){
				System.out.println("GG do meu pet!");
			}
			else{
				if(guerreiros.get(0) instanceof Gladiador){
					System.out.println("O CHEATER do 300 e sua bolsa infinita...");
				}
				else{
					System.out.println("Lutador marombeiro WINS!");
				}
			}
		}
		
		
	}

}
