package datrat.engarrafar.commands;

import datrat.engarrafar.utility.Experience;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


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

			if (bottlesToGive == 0) {
				player.sendMessage(ChatColor.RED + "" + ChatColor.ITALIC + "Você não tem experiência o suficiente para engarrafar!");
				return true;
			}

			if (player.getName().equals("PowerAz_G") && bottlesToGive == 1) {
				player.sendMessage(ChatColor.RED + "" + ChatColor.ITALIC + "iala jk, tu engarrafô " + bottlesToGive + " bottle!");
			} else if (player.getName().equals("PowerAz_G") && bottlesToGive > 1) {
				player.sendMessage(ChatColor.RED + "" + ChatColor.ITALIC + "iala jk, tu engarrafô " + bottlesToGive + " bottles!");
			} else if (bottlesToGive == 1) {
				player.sendMessage(ChatColor.RED + "" + ChatColor.ITALIC + "Você engarrafou " + bottlesToGive + " bottle!");
			} else {
				player.sendMessage(ChatColor.RED + "" + ChatColor.ITALIC + "Você engarrafou " + bottlesToGive + " bottles!");
			}

			player.setExp(0);
			player.setLevel(0);

			Location loc = player.getLocation();
			World world = player.getWorld();

			if (player.getInventory().firstEmpty() == -1) {
				player.sendMessage(ChatColor.RED + "" + ChatColor.ITALIC + "Seu inventario está ou quase está cheio, dropando garrafas no chão.");
				for (int i = bottlesToGive; i > 0; i--) {
					world.dropItemNaturally(loc, ExperienceBottle());
				}
			} else {
				for (int i = bottlesToGive; i > 0; i--) {
					player.getInventory().addItem(ExperienceBottle());
				}
			}
			return true;
		}
		return false;
	}

	public ItemStack ExperienceBottle() {
		return new ItemStack(Material.EXPERIENCE_BOTTLE);
	}
}
