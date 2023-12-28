package allumettes;

/** JeuReel implémente l'interface Jeu
 * correspond au jeu réel
 * @author ABOUMEJD Wissal
 */
public class JeuReel implements Jeu {
	/** nombre d'allumettes */
	private int nbAll;

	/** constructeur */
	public JeuReel(int nbAll) {
		this.nbAll = nbAll;
	}

	@Override
	public int getNombreAllumettes() {
		return this.nbAll;
	}

	@Override
	public void retirer(int nbPrises) throws CoupInvalideException {

		if (0 < nbPrises && nbPrises <= Jeu.PRISE_MAX && nbPrises <= this.nbAll) {
			this.nbAll -=  nbPrises;
		}
		else if (nbPrises > this.nbAll) {
			throw new CoupInvalideException(nbPrises,
					"Impossible ! Nombre invalide: " + nbPrises + " (> " + this.nbAll + ")");
		}
		else if (nbPrises <= 0) {
			throw new CoupInvalideException(nbPrises,
					"Impossible ! Nombre invalide : " + nbPrises + " (< 1)");
		}
		else if (nbPrises > Jeu.PRISE_MAX) {
			throw new CoupInvalideException(nbPrises,
					"Impossible ! Nombre invalide : " + nbPrises + " (> " + Jeu.PRISE_MAX + ")");
		}
	}
}