package allumettes;

/** Cette classe implémente l'interface strategie
 * elle correspond à une stratégie rapide
 * @author ABOUMEJD Wissal
 */

public class Rapide implements Strategie {
	
	/** constructeur par défaut*/
	public Rapide() {
	}
	
	@Override
	public int nbAretirer(Jeu jeu) {
		if (Jeu.PRISE_MAX < jeu.getNombreAllumettes()) {
			return Jeu.PRISE_MAX;
		} else if (Jeu.PRISE_MAX == jeu.getNombreAllumettes()){
			return (Jeu.PRISE_MAX - 1);
		} else {
			return 1;
		}
	}

	@Override
	public String getNom() {
		return "rapide";
	}
}
