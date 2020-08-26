package net.simplyrin.bungeeplugins;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Plugin;
import net.simplyrin.bungeeplugins.command.BungeePluginsCommand;

/**
 * Created by SimplyRin on 2017/12/22.
 *
 * Copyright (c) 2020 SimplyRin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class Main extends Plugin {

	@Override
	public void onEnable() {
		this.getProxy().getPluginManager().registerCommand(this, new BungeePluginsCommand(this));
	}

	@Override
	public void onDisable() {
		this.getProxy().getPluginManager().unregisterCommands(this);
	}

	@SuppressWarnings("deprecation")
	public void info(CommandSender player, String args) {
		if (player == null || args.equals("") || args == null) {
			return;
		}
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getPrefix() + args));
	}

	public String getPrefix() {
		return "§7[§cBungeePlugins§7] §r";
	}

}
