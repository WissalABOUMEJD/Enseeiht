package allumettes;
/**
 * Cette classe implémente l'interface Jeu
 * elle correspond à un jeu avec procuration
 * @author ABOUMEJD Wissal
 */
public class Procuration implements Jeu {

    private JeuReel jeuReel;

    public Procuration(JeuReel jeuReel) {
    	this.jeuReel = jeuReel;
    }

	@Override
    public int getNombreAllumettes() {
        return this.jeuReel.getNombreAllumettes();
    }

	@Override
	public void retirer(int nbPrises) throws CoupInvalideException {
		 throw new OperationInterditeException();
	}
}
