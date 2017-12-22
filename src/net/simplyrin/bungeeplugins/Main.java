package net.simplyrin.bungeeplugins;

import java.util.Collection;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

	private static Main plugin;

	@Override
	public void onEnable() {
		plugin = this;

		plugin.getProxy().getPluginManager().registerCommand(plugin, new Command( "bpl", null, "bungeeplugins" ) {
			@Override
			public void execute(CommandSender sender, String[] args) {
				if(!sender.hasPermission("bungeeplugins.command")) {
					sender.sendMessage(getPrefix() + "§cYou don't have access to this command!");
					return;
				}

				Collection<Plugin> plugins = plugin.getProxy().getPluginManager().getPlugins();

				String pl = "";
				for(Plugin p : plugins) {
					pl += p.getDescription().getName() + "§f, §a";
				}

				pl = pl.substring(0, (pl.length() - 4));

				sender.sendMessage(getPrefix() + "§fPlugins: (" + plugins.size() + "): §a" + pl);
			}
		});
	}

	public String getPrefix() {
		return "§7[§cBungeePlugins§7] §r";
	}

}
