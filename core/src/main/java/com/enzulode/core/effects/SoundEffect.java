package com.enzulode.core.effects;

import static com.enzulode.natives.NativeMethods.hashcode;

public class SoundEffect extends Effect
{
	public SoundEffect(String descriptor)
	{
		super(descriptor, EffectType.SOUND, EffectEnv.DEFAULT);
	}

	public SoundEffect(String descriptor, EffectEnv env)
	{
		super(descriptor, EffectType.SOUND, env);
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
		if (obj instanceof SoundEffect effect)
			return (hashCode() == effect.hashCode());

		return false;
	}
}
