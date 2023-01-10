package com.enzulode.lab.entities.actions;

public enum ActionMoodModification
{

	CONTRITELY("сокрушённо"),
	NORMAL("спокойно"),
	CLOSER("теснее"),
	HILARIOUSLY("весело");

	private final String descriptor;
	private ActionMoodModification(String stringDescriptor)
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
