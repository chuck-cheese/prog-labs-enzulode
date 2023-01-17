package com.enzulode.core.effects;

public enum EffectEnvironment
{

	DEFAULT("окружение"),
	RIVER("река"),
	FOREST("лес");

	private final String descriptor;

	EffectEnvironment(String descriptor)
	{
		this.descriptor = descriptor;
	}

	public String getDescriptor()
	{
		return descriptor;
	}

	@Override
	public String toString()
	{
		return getDescriptor();
	}
}
