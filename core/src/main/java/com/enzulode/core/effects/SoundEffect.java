package com.enzulode.core.effects;

import static com.enzulode.natives.NativeMethods.hashcode;

public class SoundEffect extends Effect
{
	public SoundEffect(String descriptor)
	{
		super(descriptor, EffectType.SOUND);
	}

	@Override
	public String performEffect()
	{
		return "[" + getType() + "]: " + getDescriptor();
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
		if (obj instanceof SoundEffect effect)
			return (hashCode() == effect.hashCode());

		return false;
	}
}
