package com.enzulode.lab.effects;

public abstract class Effect
{

	private final String descriptor;

	public Effect(String stringDescriptor)
	{
		descriptor = stringDescriptor;
	}

	public String getDescriptor()
	{
		return descriptor;
	}
}
