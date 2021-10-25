package datrat.engarrafar.commands;

import com.google.common.collect.Lists;
import datrat.engarrafar.utility.Experience;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

import static datrat.engarrafar.EngarrafarMain.instance;

public class Engarrafar implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("engarrafar")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage("[Engarrafar] - O Console não pode usar o /engarrafar!");
				return true;
			}

			Player player = (Player) sender;
			int playerExp = Experience.getExp(player);

			int bottlesToGive = playerExp / 8;

			player.setExp(0);
			player.setLevel(0);

			if (bottlesToGive == 0) {
				player.sendMessage(ChatColor.RED + "" + ChatColor.ITALIC + "Você não tem experiência o suficiente para engarrafar!");
				return true;
			}

			if (bottlesToGive == 1) {
				player.sendMessage(ChatColor.RED + "" + ChatColor.ITALIC + "Você engarrafou " + bottlesToGive + " bottle!");
			} else {
				player.sendMessage(ChatColor.RED + "" + ChatColor.ITALIC + "Você engarrafou " + bottlesToGive + " bottles!");
			}

			List<ItemStack> bottles = Lists.newArrayList();
			while(bottlesToGive > 0) {
				int toGive = Math.min(bottlesToGive, 64);
				bottles.add(new ItemStack(Material.EXPERIENCE_BOTTLE, toGive));
				bottlesToGive -= toGive;
			}
			Bukkit.getScheduler().callSyncMethod(instance, () -> {
				for (ItemStack item : bottles) {
					player.getInventory().addItem(item).values().forEach(rejected -> player.getWorld().dropItem(player.getLocation(), rejected));
				}
				return true;
			});
			return true;
		}
		return false;
	}
}
