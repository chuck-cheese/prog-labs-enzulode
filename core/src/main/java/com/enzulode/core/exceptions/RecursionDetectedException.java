package com.enzulode.core.exceptions;

public class RecursionDetectedException extends RuntimeException
{

	public RecursionDetectedException()
	{
		super("Замечена рекурсия! Избавьтесь от неё и запустите программу снова.");
	}

}
