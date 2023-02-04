package com.enzulode.core.exceptions;

public class IncorrectCommandArgumentsException extends Exception
{

	public IncorrectCommandArgumentsException()
	{
		super("Команде переданы неправильные аргументы. Воспользуйтесь командой help для получения подробной информации.");
	}

}
