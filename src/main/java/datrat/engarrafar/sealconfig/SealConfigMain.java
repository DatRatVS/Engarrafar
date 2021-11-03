package datrat.engarrafar.sealconfig;

import com.focamacho.sealconfig.SealConfig;
import com.focamacho.sealconfig.relocated.blue.endless.jankson.api.annotation.Comment;

import java.io.File;

import static datrat.engarrafar.strings.EngarrafarStrings.selectedLangMessage;

public class SealConfigMain {

	@Comment("Define here your preferred Language\n" +
					"Available Languages:\n" +
					"pt-BR | en-US")
	public String lang = "pt-BR";

	private static SealConfig sealConfig;
	public static SealConfigMain config;

	public static void loadConfig() {
		sealConfig = new SealConfig();
		config = sealConfig.getConfig(new File("./plugins/Engarrafar/language.json"), SealConfigMain.class);

		saveConfig();
	}

	public static void reloadConfig() {
		sealConfig.reload();
	}

	public static void saveConfig() {
		sealConfig.save(config);
	}

}
