package com.enzulode.lab.entities.actions;

public class ShakeHeadAction implements EntityAction
{

	private final ActionMoodModification modification;

	public ShakeHeadAction(ActionMoodModification modification)
	{
		this.modification = modification;
	}

	public ActionMoodModification getModification()
	{
		return modification;
	}

	@Override
	public String perform()
	{
		return (modification != ActionMoodModification.NORMAL) ?
				modification.getDescriptor() + " покачал головой." : "покачал головой.";
	}
}
