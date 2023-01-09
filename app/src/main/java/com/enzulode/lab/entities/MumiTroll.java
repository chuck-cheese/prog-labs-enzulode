package com.enzulode.lab.entities;

public class MumiTroll extends Entity
{

	public MumiTroll(String name, EntityType type)
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
}
