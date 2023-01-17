package com.enzulode.core.effects;

import static com.enzulode.natives.NativeMethods.hashcode;

public class FeelingEffect extends Effect
{
	public FeelingEffect(String descriptor)
	{
		super(descriptor, EffectType.FEELINGS, EffectEnv.DEFAULT);
	}

	public FeelingEffect(String descriptor, EffectEnv env)
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
		return hashcode(this) + hashcode(getDescriptor()) + hashcode(getType()) + hashcode(getEnv());
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof FeelingEffect effect)
			return (hashCode() == effect.hashCode());

		return false;
	}
}
