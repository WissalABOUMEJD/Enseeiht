package allumettes;

/** Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 * @author	Xavier Crégut
 * @version	$Revision: 1.5 $
 */
public class Jouer {
	static final int Nombre_allumettes_initial = 13;
	/** Lancer une partie. En argument sont donnés les deux joueurs sous
	 * la forme nom@stratégie.
	 * @param args la description des deux joueurs
	 * @throws CoupInvalideException 
	 */
	public static void main(String[] args){
		Joueur joueur1 = null;
		Joueur joueur2 = null;
		try {
			verifierNombreArguments(args);
			JeuReel jeu = new JeuReel(Nombre_allumettes_initial);	//Construction du jeu
			if (args[0].equals("-confiant")) {
				joueur1 = donneJoueur(args, 1);		//construction du joueur 1
				joueur2 = donneJoueur(args, 2);		//construction du joueur 2
				Arbitre arbitre = new Arbitre(joueur1, joueur2);
				arbitre.confiant = true;
				arbitre.arbitrer(jeu);
			} else {
				joueur1 = donneJoueur(args, 0);		//construction du joueur 1
				joueur2 = donneJoueur(args, 1);		//construction du joueur 2
				Arbitre arbitre = new Arbitre(joueur1, joueur2);
				arbitre.confiant = false;
				arbitre.arbitrer(jeu);
				
			}
			
		} catch (ConfigurationException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
			System.exit(1);
		} catch (ArrayIndexOutOfBoundsException e) {	//gère si l'utilisateur ne respecte pas le format joueur@strategie
			afficherUsage();
		}
	}

	private static void verifierNombreArguments(String[] args) {
		final int nbJoueurs = 2;
		if (args.length < nbJoueurs) {
			throw new ConfigurationException("Trop peu d'arguments : "
					+ args.length);
		}
		if (args.length > nbJoueurs + 1) {
			throw new ConfigurationException("Trop d'arguments : "
					+ args.length);
		}
	}

	/** Afficher des indications sur la manière d'exécuter cette classe. */
	public static void afficherUsage() {
		System.out.println("\n" + "Usage :"
				+ "\n\t" + "java allumettes.Jouer joueur1 joueur2"
				+ "\n\t\t" + "joueur est de la forme nom@stratégie"
				+ "\n\t\t" + "strategie = naif | rapide | expert | humain | tricheur"
				+ "\n"
				+ "\n\t" + "Exemple :"
				+ "\n\t" + "	java allumettes.Jouer Xavier@humain "
					   + "Ordinateur@naif"
				+ "\n"
				);
	}
	
	/** split la ligne de commande
	 * @param args la ligne de commande
	 * @param nb represente le numero du joueur
	 * @return le joueur de type Joueur
	 */
	public static Joueur donneJoueur(String[] args, int nb) {
		String[] infos = null;
		infos = args[nb].split("@");
		if (infos[0].length() == 0) {		//traite si l'utilisateur fait entrer un nom vide
	        throw new ConfigurationException("Nom invalide");
		}
		return new Joueur(infos[0], toStrategie(infos[1]));
	}
	
    /** obtenir la strategie entrée en ligne de commande
     * @param strategie est la strategie entrée en ligne de commande
     * @return la strategie entrée en ligne de commande
     */
	public static Strategie toStrategie(String strategie) {
		if (strategie.equals("naif")) {
			return new Naif();
		}
		else if (strategie.equals("rapide")) {
			return new Rapide();
		}
		else if (strategie.equals("expert")) {
			return new Expert();
		}
		else if (strategie.equals("humain")) {
			return new Humain();
		}
		else if (strategie.equals("tricheur")) {
			return new Tricheur();
		}
		else {
			throw new ConfigurationException("La stratégie n'est pas reconnue");
		}
	}

}
