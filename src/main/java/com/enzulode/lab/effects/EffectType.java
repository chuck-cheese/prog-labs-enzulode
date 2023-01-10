package com.enzulode.lab.effects;

public enum EffectType
{
	DEFAULT("default effect type descriptor"),
	SOUND("звуки"),
	FEELINGS("ощущения"),
	VISUAL("визуал");

	private final String descriptor;
	EffectType(String descriptor)
	{
		this.descriptor = descriptor;
	}

	@Override
	public String toString()
	{
		return descriptor;
	}
}
