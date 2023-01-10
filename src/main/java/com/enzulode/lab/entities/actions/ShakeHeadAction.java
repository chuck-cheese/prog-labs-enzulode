package com.enzulode.lab.entities.actions;

import static com.enzulode.natives.NativeMethods.hashcode;

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

	@Override
	public String toString()
	{
		return "String representation: " + perform();
	}

	@Override
	public int hashCode()
	{
		return hashcode(this) + hashcode(modification);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof ShakeHeadAction shakeHeadAction)
			return hashCode() == shakeHeadAction.hashCode();

		return false;
	}
}
