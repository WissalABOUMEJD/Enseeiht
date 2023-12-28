package allumettes;
/** Classe Joueur, un joueur est caractérisé
 * par son nom et sa stratégie
 * @author ABOUMEJD Wissal
 */

public class Joueur {
	/** le nom du joueur */
	private String nom;
	/** la stratégie du joueur */
	private Strategie strategie;
	
	/**constructeur du Joueur
	 * @param nom le nom du joueur
	 * @param strategie la stratégie du joueur
	 */
	public Joueur(String nom, Strategie strategie) {
		assert (nom.length() > 0);
        assert (strategie != null);
		this.nom = nom;
		this.strategie = strategie;
	}

	/**obtenir le nom du joueur
	 * @return le nom du joueur
	 */
	public String getNom( ) {
		return this.nom;
	}

	/**obtenir la stratégie du joueur
	 * @return la stratégie du joueur
	 */
	public Strategie getStrategie() {
		return this.strategie;
	}
	
    /**modifier la startégie du joueur.
     * @param nvlstrategie : la nouvelle stratégie
     */
    public void setStrategie(Strategie nvlstrategie) {
        assert (nvlstrategie != null);
        this.strategie = nvlstrategie;
    }
	
	/**obtenir le nombre d'allumettes à retirer
	 * @param jeu le jeu actuel
	 * @return le nombre d'allumettes à retirer
	 * selon la stratégie choisie
	 */
    public int getPrise(Jeu jeu) {
        assert (jeu != null);
        if (strategie.getNom().equals("humain")) {
            while (true) {
                System.out.print(nom + ", combien d'allumettes ? ");
                try {
                    return this.strategie.nbAretirer(jeu);
                } catch (NumberFormatException e) {
                }
            }
        }
        return this.strategie.nbAretirer(jeu);
    }
}
