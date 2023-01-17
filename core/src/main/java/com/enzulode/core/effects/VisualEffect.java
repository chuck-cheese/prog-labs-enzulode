package com.enzulode.core.effects;

import static com.enzulode.natives.NativeMethods.hashcode;

public class VisualEffect extends Effect
{
	public VisualEffect(String descriptor)
	{
		super(descriptor, EffectType.VISUAL, EffectEnv.DEFAULT);
	}

	public VisualEffect(String descriptor, EffectEnv env)
	{
		super(descriptor, EffectType.VISUAL, env);
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
		if (obj instanceof VisualEffect effect)
			return (hashCode() == effect.hashCode());

		return false;
	}
}
