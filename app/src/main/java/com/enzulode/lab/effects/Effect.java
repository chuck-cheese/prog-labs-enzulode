package com.enzulode.lab.effects;

public abstract class Effect
{

	private final String descriptor;
	private final EffectType type;

	public Effect(String descriptor, EffectType type)
	{
		this.descriptor = descriptor;
		this.type = type;
	}

	public String getDescriptor()
	{
		return descriptor;
	}

	public EffectType getType()
	{
		return type;
	}

	public String performEffect()
	{
		return "[" + EffectType.DEFAULT + "]: " + descriptor;
	}
}
