package com.enzulode.core.entities.actions;

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
}
