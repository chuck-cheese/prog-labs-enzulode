package com.enzulode.core.exceptions;

public class CommandNotFoundException extends Exception
{

	public CommandNotFoundException()
	{
		super("Введённая команда не существует");
	}

}
