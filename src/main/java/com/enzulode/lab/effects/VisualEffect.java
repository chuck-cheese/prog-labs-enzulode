package com.enzulode.lab.effects;

import static com.enzulode.natives.NativeMethods.hashcode;

public class VisualEffect extends Effect
{
	public VisualEffect(String descriptor)
	{
		super(descriptor, EffectType.VISUAL);
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
		if (obj instanceof VisualEffect effect)
			return (hashCode() == effect.hashCode());

		return false;
	}
}
