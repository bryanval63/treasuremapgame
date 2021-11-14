package fr.carbonit.treasuremapgame.consts;

public final class ErrorMsgConsts {
	public static final String FICHIER_INEXISTANT = "Le fichier n'existe pas.";
	public static final String FICHIER_VIDE = "Le fichier est vide.";
	public static final String FICHIER_ERREUR_IO = "Une erreur IO s'est produite.";

	public static final String ERROR_DUPLIACTE_POSITION = "Plusieurs lignes possèdent la même position.";
	public static final String ERROR_WRONG_LINES = "Certaines lignes du fichier ne sont pas correctes.";
	public static final String ERROR_MAP_COORDS = "Les coordonnées de la carte ne sont pas correctement définies.";
	public static final String ERROR_NUMBER_ENTITIES = "Le nombre d'éléments définis dans le fichier dépasse la taille maximum de la carte.";
	public static final String ERROR_WRONG_COORDS = "Les coordonnées d'une entitée dépasse la taille de la carte.";
	public static final String ERROR_HAPPENED = "Une erreur est survenue empêchant le programme de continuer => ";

	private ErrorMsgConsts() {
		throw new IllegalStateException("Constants class");
	}
}
