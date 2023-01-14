package com.enzulode.core.entities;

import com.enzulode.core.entities.actions.EntityAction;

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
	public void spot(String spotted)
	{
		if (getPrinter() != null)
			getPrinter().printString(String.format("%s [%s] увидел %s", getName(), toString(), spotted));
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
