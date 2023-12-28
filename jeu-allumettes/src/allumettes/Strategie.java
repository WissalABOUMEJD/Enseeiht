package allumettes;

/** interface Stratégie.
 * @author ABOUMEJD Wissal
 */

public interface Strategie {

	/** obtenir le nombre d'allumettes
	 * selon la stratégie
	 * @param jeu le jeu actuel
	 * @return le nombre d'allumettes selon
	 * la stratégie
	 */
	int nbAretirer(Jeu jeu);

	/** obtenir le nom de la stratégie
	 * @return le nom de la stratégie
	 */
	String getNom();
}