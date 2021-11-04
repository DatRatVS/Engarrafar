package datrat.engarrafar;

import datrat.engarrafar.commands.Engarrafar;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

import static datrat.engarrafar.sealconfig.SealConfigMain.loadConfig;
import static datrat.engarrafar.strings.EngarrafarStrings.onEnable;
import static datrat.engarrafar.strings.EngarrafarStrings.selectedLangMessage;

public final class EngarrafarMain extends JavaPlugin {

	public static EngarrafarMain instance;

	public static EngarrafarMain getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {

		instance = this;

		loadConfig();

		getLogger().info(selectedLangMessage);
		getLogger().info(onEnable);

		Objects.requireNonNull(this.getCommand("engarrafar")).setExecutor(new Engarrafar());
		Objects.requireNonNull(this.getCommand("bottleup")).setExecutor(new Engarrafar());

	}

	@Override
	public void onDisable() {
		getLogger().info("[Engarrafar] - Desabilitando.");
	}
}
