package giselle.skript.oraxen_item;

import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;

public class SkOraxenItems extends JavaPlugin
{
	private static SkOraxenItems instance;

	public static SkOraxenItems instance()
	{
		return instance;
	}

	public SkOraxenItems()
	{
		instance = this;
	}

	@Override
	public void onEnable()
	{
		super.onEnable();

		SkriptAddon addon = Skript.registerAddon(this);

		try
		{
			addon.loadClasses(this.getClass().getPackageName(), "elements");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

}
