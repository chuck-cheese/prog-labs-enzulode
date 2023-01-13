package com.enzulode.core.effects;

import static com.enzulode.natives.NativeMethods.hashcode;

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

	@Override
	public String toString()
	{
		return "String representation: " + getDescriptor();
	}

	@Override
	public int hashCode()
	{
		return hashcode(this) + hashcode(descriptor) + hashcode(type);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Effect effect)
			return (hashCode() == effect.hashCode());

		return false;
	}
}
