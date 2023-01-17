package com.enzulode.core.entities.actions;

import static com.enzulode.natives.NativeMethods.hashcode;

public class FeelingUnsureAction implements EntityAction
{

	@Override
	public String perform()
	{
		return "почувствовал себя неуверенно";
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
		if (obj instanceof FeelingUnsureAction feelingUnsureAction)
			return hashCode() == feelingUnsureAction.hashCode();

		return false;
	}
}
