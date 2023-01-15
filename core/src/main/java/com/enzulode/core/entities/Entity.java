package com.enzulode.core.entities;

import com.enzulode.core.entities.actions.EntityAction;
import com.enzulode.core.utils.ConsolePrinter;
import com.enzulode.core.utils.Printer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import static com.enzulode.natives.NativeMethods.hashcode;

public abstract class Entity
{
	private final String name;
	private final List<EntityAction> actions;
	private final EntityType type;
	private final Printer printer;


	public Entity(String name, EntityType type, EntityAction... actions)
	{
		this.actions = new LinkedList<>();
		this.name = name;
		this.type = type;
		this.printer = new ConsolePrinter();

		if (actions.length != 0)
			this.actions.addAll(Arrays.asList(actions));
	}

	public String getName()
	{
		return name;
	}

	public List<EntityAction> getActions()
	{
		return actions;
	}

	public EntityType getType()
	{
		return type;
	}

	public Printer getPrinter()
	{
		return printer;
	}

	public void addAction(EntityAction action)
	{
		if (action != null)
			actions.add(action);
	}

	public void performAction()
	{
		EntityAction action = ((LinkedList<EntityAction>) actions).poll();

		if (action != null)
			printer.printString(getName() + ": " + action.perform());
	}

	public void appear()
	{
		printer.printString(String.format("%s [%s] появился", getName(), getType()));
	}
	public abstract void speak(String toSpeak);

	public abstract void spot(String spotted);

	@Override
	public String toString()
	{
		return "String representation: " + getName();
	}

	@Override
	public int hashCode()
	{
		return hashcode(this) + hashcode(getName()) + hashcode(getActions()) + hashcode(getType());
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Entity entity)
			return hashCode() == entity.hashCode();

		return false;
	}
}
