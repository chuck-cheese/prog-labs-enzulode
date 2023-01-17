package com.enzulode.core.entities.actions;

import static com.enzulode.natives.NativeMethods.hashcode;

public class PutPawAndLickAction implements EntityAction
{

	private final String place;

	public PutPawAndLickAction(String place)
	{
		this.place = place;
	}

	public String getPlace()
	{
		return place;
	}

	@Override
	public String perform()
	{
		return String.format("сунул в неё [%s] лапу и осторожно лизнул", getPlace());
	}

	@Override
	public String toString()
	{
		return "String representation: " + perform();
	}

	@Override
	public int hashCode()
	{
		return hashcode(this) + hashcode(getPlace());
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof PutPawAndLickAction putPawAndLickAction)
			return hashCode() == putPawAndLickAction.hashCode();

		return false;
	}
}
