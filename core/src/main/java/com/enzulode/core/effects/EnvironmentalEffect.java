package com.enzulode.core.effects;

import static com.enzulode.natives.NativeMethods.hashcode;

public class EnvironmentalEffect extends Effect
{

	public EnvironmentalEffect(String descriptor)
	{
		super(descriptor, EffectType.ENVIRONMENTAL, EffectEnv.DEFAULT);
	}

	public EnvironmentalEffect(String descriptor, EffectEnv env)
	{
		super(descriptor, EffectType.ENVIRONMENTAL, env);
	}

	@Override
	public String toString()
	{
		return "String representation: " + getDescriptor();
	}

	@Override
	public int hashCode()
	{
		return hashcode(getDescriptor()) + hashcode(getType()) + hashcode(getEnv());
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof EnvironmentalEffect environmentEffect)
			return hashCode() == environmentEffect.hashCode();

		return false;
	}
}
