package com.enzulode.core.effects;

public enum EffectEnv
{

	DEFAULT("окружение"),
	RIVER("река"),
	FOREST("лес");

	private final String descriptor;

	EffectEnv(String descriptor)
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
