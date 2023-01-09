package com.enzulode.lab.entities;

import com.enzulode.lab.entities.actions.EntityAction;
import com.enzulode.lab.util.ConsolePrinter;
import com.enzulode.lab.util.Printer;

import java.util.Arrays;
import java.util.LinkedList;

public abstract class Entity
{

	private final String name;
	private final LinkedList<EntityAction> actions;
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

	public LinkedList<EntityAction> getActions()
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
		EntityAction action = actions.poll();

		if (action != null)
			printer.printString(getName() + ": " + action.perform());
	}

	public abstract void speak(String toSpeak);

}
