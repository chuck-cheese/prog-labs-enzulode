package com.enzulode.core.entities.actions;

import static com.enzulode.natives.NativeMethods.hashcode;

public class JumpAndSwimAction implements EntityAction
{

	public final ActionMoodModification modification;

	public JumpAndSwimAction(ActionMoodModification modification)
	{
		this.modification = modification;
	}

	@Override
	public String perform()
	{
		return String.format(
				"скользнул в тёплую воду и %s поплыл по реке",
				(modification == ActionMoodModification.DEFAULT) ? "" : modification.toString()
		);
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
		if (obj instanceof JumpAndSwimAction jumpAndSwimAction)
			return hashCode() == jumpAndSwimAction.hashCode();

		return false;
	}
}
