package com.enzulode.core.entities;

public enum EntityType
{

	CREATURE("существо"),
	ITEM("вещь"),
	NON_DEFINED("не определено");

	private String descriptor;
	private EntityType(String stringDescriptor)
	{
		descriptor = stringDescriptor;
	}

	public String getDescriptor()
	{
		return descriptor;
	}

	@Override
	public String toString()
	{
		return descriptor;
	}
}
