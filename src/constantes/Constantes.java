package constantes;
/**
 * 
 * @author Tyrynor, 22/07/2018
 * History:
 *  - Tyrynor, 22/07/2018 Création
 *
 */

import java.awt.Dimension;
import java.awt.Toolkit;

public final class Constantes {
	public static final String IHM_NOM_FENTRE = "Nom de fenetre";
	public static final Dimension IHM_TAILLE_FENETRE = Toolkit.getDefaultToolkit().getScreenSize();
	public static final Dimension TAILLE_BASE_ENTITY = new Dimension(50,50);
	public static final int VITESSE_DE_DEPLACEMENT = 5;
	public static final double FACTEUR_BIAIS = Math.sqrt(2) / 2;
	public static int TARGETTEDFPS = 60;
}
