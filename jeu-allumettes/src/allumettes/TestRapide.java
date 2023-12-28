package allumettes;
import org.junit.*;
import static org.junit.Assert.*;

public class TestRapide {
	private Joueur j1;
	
	@Before 
	public void setUp() {
		j1 = new Joueur("Wissal",new Rapide());
    }
	
	@Test
    public void test1() {
        assertEquals(this.j1.getStrategie().getNom(), "rapide");
    }
    
	@Test 
	public void testerPrise(){
        assertEquals("Prise incorrecte pour un"
        		+ " jeu avec 2 allumettes restantes", 
        		1, j1.getPrise(new JeuReel(2)));
        assertEquals("Prise incorrecte pour un jeu "
        		+ "avec 3 allumettes restantes", 2, 
        		j1.getPrise(new JeuReel(3)));
        int i;
        for (i = 4; i <= 13; i++) {
            assertEquals("Prise incorrecte pour un"
            		+ " jeu avec " + i + " allumettes "
            				+ "restantes", 3 ,j1.getPrise(new JeuReel(i)));
            }
        }
}