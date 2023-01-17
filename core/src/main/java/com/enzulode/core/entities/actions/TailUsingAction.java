package com.enzulode.core.entities.actions;

import static com.enzulode.natives.NativeMethods.hashcode;

public class TailUsingAction implements EntityAction
{
	@Override
	public String perform()
	{
		return "подрулил хвостом и тотчас же нащупал лапами дно";
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
		if (obj instanceof TailUsingAction tailUsingAction)
			return hashCode() == tailUsingAction.hashCode();

		return false;
	}
}
