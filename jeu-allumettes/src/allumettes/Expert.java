package allumettes;
import java.util.Random;

/**
 * Cette classe implémente l'interface strategie
 * elle correspond à la stratégie expert
 * @author ABOUMEJD Wissal
 */

public class Expert implements Strategie {
	
	/** constructeur par défaut */
	public Expert() {
	}
	
	@Override
	public int nbAretirer(Jeu jeu) {
		Random aleas = new Random();
		if ((jeu.getNombreAllumettes()-1) % (Jeu.PRISE_MAX + 1) == 0) {
			return aleas.nextInt(Jeu.PRISE_MAX) + 1;
		}
		else {
			return (jeu.getNombreAllumettes()-1) % (Jeu.PRISE_MAX + 1);
		}
	}

	@Override
	public String getNom() {
		return "expert";
	}

}
