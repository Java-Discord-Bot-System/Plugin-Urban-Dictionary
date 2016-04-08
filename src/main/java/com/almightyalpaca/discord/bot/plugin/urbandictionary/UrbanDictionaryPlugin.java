package com.almightyalpaca.discord.bot.plugin.urbandictionary;

import java.io.IOException;

import com.almightyalpaca.discord.bot.system.command.Command;
import com.almightyalpaca.discord.bot.system.command.CommandHandler;
import com.almightyalpaca.discord.bot.system.command.arguments.special.Rest;
import com.almightyalpaca.discord.bot.system.events.commands.CommandEvent;
import com.almightyalpaca.discord.bot.system.exception.PluginLoadingException;
import com.almightyalpaca.discord.bot.system.exception.PluginUnloadingException;
import com.almightyalpaca.discord.bot.system.plugins.Plugin;
import com.almightyalpaca.discord.bot.system.plugins.PluginInfo;

import dev.maisentito.liburban.Definition;
import dev.maisentito.liburban.Results;
import dev.maisentito.liburban.UrbanDictionary;
import net.dv8tion.jda.MessageBuilder;

public class UrbanDictionaryPlugin extends Plugin {

	class LanguageCommand extends Command {

		public LanguageCommand() {
			super("define", "Defines the expression", "language [text]");
		}

		@CommandHandler(dm = true, guild = true, async = true)
		public void onCommand(final CommandEvent event, final Rest text) {
			final MessageBuilder builder = new MessageBuilder();

			try {
				final Results results = UrbanDictionary.define(text.getString());

				if (results.getList().isEmpty()) {
					builder.appendString("Unfortunately Urban Dictionary doesn't know anything about " + text.getString());
				} else {
					final Definition definition = results.getList().get(0);

					builder.appendString("**Top Entry on Urban Dictionary about *" + definition.getWord() + "* created by *" + definition.getAuthor() + "* :**\n");
					builder.appendString(":+1:" + definition.getThumbsUp() + "   :-1:" + definition.getThumbsDown() + "\n\n");
					builder.appendString("**Definition:**\n" + definition.getDefinition() + "\n");
					builder.appendString("\n**Example:**\n" + definition.getExample() + "\n");
				}
			} catch (final IOException e) {
				e.printStackTrace();
				builder.appendString("An unexpected error occured!");
			}

			event.sendMessage(builder);
		}
	}

	private static final PluginInfo INFO = new PluginInfo("com.almightyalpaca.discord.bot.plugin.urbandictionary", "1.0.0", "Almighty Alpaca", "Urban Dictionary Plugin", "Defines words.");

	public UrbanDictionaryPlugin() {
		super(UrbanDictionaryPlugin.INFO);
	}

	@Override
	public void load() throws PluginLoadingException {
		this.registerCommand(new LanguageCommand());
	}

	@Override
	public void unload() throws PluginUnloadingException {}
}
