package allumettes;

/**Cette classe implémente l'interface strategie
 * elle correspond à une stratégie tricheur
 * @author ABOUMEJD Wissal
 */

public class Tricheur implements Strategie {
	
	@Override
    public int nbAretirer(Jeu jeu) {
		System.out.print("[Je triche...]");
		System.out.println();
    	try {
    	    while (jeu.getNombreAllumettes() > 2) {
    		    jeu.retirer(1);
    	    }
    	System.out.println("[Allumettes restantes : 2]");
    	} catch (CoupInvalideException e) {
    		System.out.print("");
    	}
    	return 1;
    }

	@Override
	public String getNom() {
		return "tricheur";
	}
}