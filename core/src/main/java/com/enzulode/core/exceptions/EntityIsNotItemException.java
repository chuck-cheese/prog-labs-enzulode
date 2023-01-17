package com.enzulode.core.exceptions;

public class EntityIsNotItemException extends RuntimeException
{

	public EntityIsNotItemException()
	{
		super("Entity is not an item exception!");
	}

	@Override
	public String toString()
	{
		return "[Exception] Entity is not an item";
	}
}
