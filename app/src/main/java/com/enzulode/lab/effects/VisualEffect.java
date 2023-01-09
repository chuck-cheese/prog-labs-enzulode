package com.enzulode.lab.effects;

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
}
