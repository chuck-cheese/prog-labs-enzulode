package com.enzulode.lab.effects;

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
}
