package datrat.engarrafar;

import datrat.engarrafar.commands.Engarrafar;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class EngarrafarMain extends JavaPlugin {

	public static EngarrafarMain instance;

	public static EngarrafarMain getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {

		instance = this;

		getLogger().info("[Engarrafar] - Engarrafando desde 1/10/21!");

		Objects.requireNonNull(this.getCommand("engarrafar")).setExecutor(new Engarrafar());
	}

	@Override
	public void onDisable() {
		getLogger().info("[Engarrafar] - Desabilitando.");
	}
}
