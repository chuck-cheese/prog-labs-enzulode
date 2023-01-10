package com.enzulode.lab.entities;

import static com.enzulode.natives.NativeMethods.hashcode;

public class Snusmumric extends Entity
{

	public Snusmumric(String name, EntityType type)
	{
		super(name, type);
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
		if (obj instanceof Snusmumric entity)
			return hashCode() == entity.hashCode();

		return false;
	}
}
