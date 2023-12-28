package allumettes;

/** Classe Arbitre sert à gérer le jeu
 * @author ABOUMEJD Wissal
 */

public class Arbitre {
	/** les 2 joueurs */
	private Joueur j1, j2;
	boolean confiant;

	/** Constucteur d'Arbitre
	 * @param j1 1er joueur
	 * @param j2 2eme joueur
	 */
	public Arbitre(Joueur j1, Joueur j2) {
		assert (j1 != null && j2 != null);
		this.j1 = j1;
		this.j2 = j2;
	}

	/** gère une partie
	 * @param jeu le jeu actuel
	 */
	void arbitrer(Jeu jeu){
		boolean abandon = false; 			//prend true si la partie est abondonnée
		boolean formatincorrect = false ;	//assure le non affichage d "Allumettes restantes : " lorsque le programme affiche "Vous devez donner un entier." 
		Joueur actuel = this.j1;
		Jeu procuration = new Procuration((JeuReel) jeu);
		while (jeu.getNombreAllumettes() > 0) {
			if (formatincorrect == false) {
				System.out.println("Allumettes restantes : "
			+ jeu.getNombreAllumettes());
			}
			int nbAretirer;
			formatincorrect = false;
			try {
				if (confiant) {
					nbAretirer = actuel.getPrise(jeu);
				} else {
					nbAretirer = actuel.getPrise(procuration);	//si l'arbitre n'est pas confiant, on passe au jeu avec procuration
				}
				if (nbAretirer > 1) {	//ajoute un 's' à "allumette" lorsque nbPrises>1
					System.out.println(actuel.getNom() +
							" prend " + nbAretirer + " allumettes. ");
				} else {
					System.out.println(actuel.getNom() +
							" prend " + nbAretirer + " allumette. ");
				}
				jeu.retirer(nbAretirer);
				System.out.println();  		//assure l'espace 
				if (actuel == this.j1) {	//on passe la main au deuxième joueur
					actuel = this.j2;
				} else {
					actuel = this.j1;
				}
			} catch (CoupInvalideException e) {
				System.out.println(e.getProbleme());
				System.out.println();
			} catch (OperationInterditeException f) {
				System.out.println("Abandon de la partie car " + actuel.getNom() + " triche !");
				abandon = true;
				break;
			}
		}

	if (!abandon) {		//Si la partie n'est pas abondonnée, on affiche qui a gagné et qui a perdu
		Joueur joueur;
		joueur = actuel;
		if (joueur == j1) {
			System.out.println(j2.getNom() + " perd !");
			System.out.println(j1.getNom() + " gagne !");
			
		} else {
			System.out.println(j1.getNom() + " perd !");
			System.out.println(j2.getNom() + " gagne !");
		}
		}
	}
}