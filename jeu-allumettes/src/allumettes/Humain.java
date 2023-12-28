package allumettes;
import java.util.Scanner;

/** Cette classe implémente l'interface strategie
 * elle correspond à une stratégie humaine
 * @author ABOUMEJD Wissal
 */
public class Humain implements Strategie {
	/** sert à lire ce que l'utilisateur ecrit */
    public static Scanner scanner;

    public Humain() {
    	Humain.scanner = new Scanner(System.in);
    }

    @Override
    public int nbAretirer(Jeu jeu) throws NumberFormatException {
        int nbr = 0;
        try {
            nbr = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            String inputString = e.getMessage();
            if (inputString.equals("For input string: \"je triche\"")) {
                System.out.println("[Une allumette en moins, plus que " + (jeu.getNombreAllumettes()-1) + ". Chut !]");
                try {
                    jeu.retirer(1);
                } catch (CoupInvalideException f) {
                    System.out.print("");
                }
                throw new NumberFormatException();
            } else {
                System.out.println("Vous devez donner un entier.");
                throw new NumberFormatException();
            }
        }
        return nbr;
    }

	@Override
	public String getNom() {
		return "humain";
	}
}