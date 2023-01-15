package com.enzulode.core.effects;

import static com.enzulode.natives.NativeMethods.hashcode;

public abstract class Effect
{

	private final String descriptor;
	private final EffectType type;
	private final EffectEnvironment env;

	public Effect(String descriptor, EffectType type, EffectEnvironment env)
	{
		this.descriptor = descriptor;
		this.type = type;
		this.env = env;
	}

	public String getDescriptor()
	{
		return descriptor;
	}

	public EffectType getType()
	{
		return type;
	}

	public EffectEnvironment getEnv()
	{
		return env;
	}

	public String performEffect()
	{
		return String.format("[%s][%s]: %s", getType(), getEnv(), getDescriptor());
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
