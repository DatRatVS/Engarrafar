package datrat.engarrafar.strings;


import static datrat.engarrafar.sealconfig.SealConfigMain.config;

public class EngarrafarStrings {

	static String selectedLang = config.lang;

	public static String insufficientExp;
	public static String youBottled;
	public static String singularBottle;
	public static String pluralBottle;
	public static String selectedLangMessage;
	public static String consoleUnable;
	public static String onEnable;

	static {

		if (selectedLang.equalsIgnoreCase("pt_BR")) {

			insufficientExp = "Você não tem experiência o suficiente para engarrafar!";
			youBottled = "Você engarrafou";
			singularBottle = "garrafa!";
			pluralBottle = "garrafas!";

			consoleUnable = "[Engarrafar] - O Console não pode usar o /engarrafar!";
			selectedLangMessage = "Carregando Engarrafar em " + selectedLang;
			onEnable = "[Engarrafar] - Engarrafando desde 1/10/21!";

		} else if (selectedLang.equalsIgnoreCase("custom_Lang")) {

			insufficientExp = config.customLanguageSetup.insufficientExp;
			youBottled = config.customLanguageSetup.youBottled;
			singularBottle = config.customLanguageSetup.singularBottle;
			pluralBottle = config.customLanguageSetup.pluralBottle;

			consoleUnable = config.customLanguageSetup.consoleUnable;

			selectedLangMessage = "Loading Engarrafar in custom-Lang";
			onEnable = "[Engarrafar] - \"Bottling\" Experience since 10/1/21!";

		} else {

			insufficientExp = "You haven't sufficient experience to bottle them up!";
			youBottled = "You bottled";
			singularBottle = "bottle!";
			pluralBottle = "bottles!";

			consoleUnable = "[Engarrafar] - Does the console have Experience Points?";
			selectedLangMessage = "Loading Engarrafar in en_US";
			onEnable = "[Engarrafar] - \"Bottling\" Experience since 10/1/21!";

		}

	}

}
