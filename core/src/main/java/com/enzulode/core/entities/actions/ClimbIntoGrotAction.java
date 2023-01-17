package com.enzulode.core.entities.actions;

import static com.enzulode.natives.NativeMethods.hashcode;

public class ClimbIntoGrotAction implements EntityAction
{

	@Override
	public String perform()
	{
		return "забрался в грот";
	}

	@Override
	public String toString()
	{
		return "String representation: " + perform();
	}

	@Override
	public int hashCode()
	{
		return hashcode(this);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof ClimbIntoGrotAction climbIntoGrotAction)
			return hashCode() == climbIntoGrotAction.hashCode();

		return false;
	}
}
