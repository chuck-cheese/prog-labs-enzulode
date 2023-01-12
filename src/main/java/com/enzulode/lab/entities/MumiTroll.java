package com.enzulode.lab.entities;

import com.enzulode.lab.entities.actions.EntityAction;

import static com.enzulode.natives.NativeMethods.hashcode;

public class MumiTroll extends Entity
{

	public MumiTroll(String name, EntityAction... actions)
	{
		super(name, EntityType.CREATURE, actions);
	}

	@Override
	public void speak(String toSpeak)
	{
		if (getPrinter() != null)
			getPrinter().printString(getName() + "[" + toString() + "] говорит: " + toSpeak);
	}

	@Override
	public String toString()
	{
		return getType().toString();
	}

	@Override
	public int hashCode()
	{
		return hashcode(this) + hashcode(getName()) + hashcode(getActions()) + hashcode(getType());
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof MumiTroll entity)
			return hashCode() == entity.hashCode();

		return false;
	}
}
