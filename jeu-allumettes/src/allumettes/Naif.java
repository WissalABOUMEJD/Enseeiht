package allumettes;
import java.util.Random;

/**
 * Cette classe implémente l'interface strategie
 * elle correspond à une stratégie naive
 * @author ABOUMEJD Wissal
 */

public class Naif implements Strategie {
	/** générateur d'un nombre aléatoire */
	private Random alea;
	
	/** constructeur */
	public Naif() {
		this.alea = new Random();
	}
	
	@Override
	public int nbAretirer(Jeu jeu) {
		return this.alea.nextInt(Jeu.PRISE_MAX) + 1;
	}

	@Override
	public String getNom() {
		return "naif";
	}
	
}
