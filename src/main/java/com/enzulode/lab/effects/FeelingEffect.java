package com.enzulode.lab.effects;

public class FeelingEffect extends Effect
{
	public FeelingEffect(String descriptor)
	{
		super(descriptor, EffectType.FEELINGS);
	}

	@Override
	public String performEffect()
	{
		return "[" + getType() + "]: " + getDescriptor();
	}
}
