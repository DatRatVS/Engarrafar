package datrat.engarrafar.sealconfig;

import com.focamacho.sealconfig.ConfigObject;
import com.focamacho.sealconfig.SealConfig;
import com.focamacho.sealconfig.relocated.blue.endless.jankson.api.annotation.Comment;

import java.io.File;

public class SealConfigMain {

	@Comment("Define here your preferred Language\n" +
					"Available Languages:\n" +
					"en_US | pt_BR | custom_Lang")
	public String lang = "en_US";

	@Comment("Define here the tax you'll have to pay when bottling\n" +
					"(Default: 8)\n" +
					"If less than 8, bottles can be duped.")
	public int bottlingTax = 8;

	@ConfigObject
	public customLang customLanguageSetup = new customLang();
	public static class customLang {

		@Comment("Shows up when you don't have enough experience to use the command.")
		public String insufficientExp = "You don't have sufficient experience to bottle them up!";

		@Comment("Shows up in \"You Bottled (x) Bottles!\".")
		public String youBottled = "You bottled";

		@Comment("Bottle in singular.")
		public String singularBottle = "bottle!";

		@Comment("Bottle in plural.")
		public String pluralBottle = "bottles!";

		@Comment("Shows up when the console tries to run the command.")
		public String consoleUnable = "[Engarrafar] - Does the console have Experience Points?";

	}

	private static SealConfig sealConfig;
	public static SealConfigMain config;

	public static void loadConfig() {
		sealConfig = new SealConfig();
		config = sealConfig.getConfig(new File("./plugins/Engarrafar/config.json"), SealConfigMain.class);

		saveConfig();
	}

	/*
		public static void reloadConfig() {
		sealConfig.reload();
	}
	*/

	public static void saveConfig() {
		sealConfig.save(config);
	}

}
