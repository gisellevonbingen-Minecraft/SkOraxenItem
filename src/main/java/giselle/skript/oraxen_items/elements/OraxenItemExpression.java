package giselle.skript.oraxen_items.elements;

import java.util.Arrays;

import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import io.th0rgal.oraxen.api.OraxenItems;

public class OraxenItemExpression extends SimpleExpression<ItemStack>
{
	static
	{
		Skript.registerExpression(OraxenItemExpression.class, ItemStack.class, ExpressionType.COMBINED, "item with oraxen %string%");
	}

	private Expression<String> id;

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult)
	{
		this.id = (Expression<String>) exprs[0];
		return true;
	}

	@Override
	public String toString(Event e, boolean debug)
	{
		return "item with oraxen " + this.id.toString(e, debug);
	}

	@Override
	public boolean isSingle()
	{
		return true;
	}

	@Override
	public Class<? extends ItemStack> getReturnType()
	{
		return ItemStack.class;
	}

	@Override
	protected ItemStack[] get(Event e)
	{
		return Arrays.stream(this.id.getAll(e)).map(id -> OraxenItems.getItemById(id).build()).toArray(ItemStack[]::new);
	}

}
