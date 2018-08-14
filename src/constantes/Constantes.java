package constantes;
/**
 * 
 * @author Tyrynor, 22/07/2018
 * History:
 *  - Tyrynor, 22/07/2018 Cr√©ation
 *
 */

import java.awt.Dimension;
import java.awt.Toolkit;

public final class Constantes {
	// Constantes utiles ‡ l'application
	public static final String IHM_NOM_FENTRE = "KyuTyr";
	public static final Dimension IHM_TAILLE_FENETRE = Toolkit.getDefaultToolkit().getScreenSize();
	public static final Dimension TAILLE_BASE_ENTITY = new Dimension(50,50);
	public static final int VITESSE_DE_DEPLACEMENT = 5;
	public static final double FACTEUR_BIAIS = Math.sqrt(2) / 2;
	public static final int TARGETTEDFPS = 60;
	public static final Dimension REFERENTIEL_JOUEUR = new Dimension((int)Constantes.IHM_TAILLE_FENETRE.getWidth()/2-Constantes.TAILLE_BASE_ENTITY.width, (int)Constantes.IHM_TAILLE_FENETRE.getHeight()/2-Constantes.TAILLE_BASE_ENTITY.height);
	public static final String LISTENING_TEXT= "Listening";
}
