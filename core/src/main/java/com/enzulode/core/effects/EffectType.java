package com.enzulode.core.effects;

public enum EffectType
{
	DEFAULT("default effect type descriptor"),
	SOUND("звуковой эффект"),
	FEELINGS("эффект ощущения"),
	VISUAL("визуальный эффект"),
	ENVIRONMENTAL("эффект окружения");

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
