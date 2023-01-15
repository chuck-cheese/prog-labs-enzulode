package com.enzulode.core.entities;

import com.enzulode.core.entities.actions.EntityAction;

public class Hat extends Entity
{
	public Hat(String name, EntityAction... actions)
	{
		super(name, EntityType.ITEM, actions);
	}

	@Override
	public void speak(String toSpeak)
	{
//		Hat is not speaking!! R u dumb!?
	}

	@Override
	public void spot(String spotted)
	{
//		Hat is not a creature, dude! Wtf r u doin'!?
	}

	@Override
	public String toString()
	{
		return String.format("[%s]: %s", getType(), getName());
	}
}
