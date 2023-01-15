package com.enzulode.core.effects;

import static com.enzulode.natives.NativeMethods.hashcode;

public class FeelingEffect extends Effect
{
	public FeelingEffect(String descriptor)
	{
		super(descriptor, EffectType.FEELINGS, EffectEnvironment.DEFAULT);
	}

	public FeelingEffect(String descriptor, EffectEnvironment env)
	{
		super(descriptor, EffectType.FEELINGS, env);
	}

	@Override
	public String toString()
	{
		return "String representation: " + getDescriptor();
	}

	@Override
	public int hashCode()
	{
		return hashcode(this) + hashcode(getDescriptor()) + hashcode(getType());
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof FeelingEffect effect)
			return (hashCode() == effect.hashCode());

		return false;
	}
}
