package com.enzulode.core.exceptions;

public class FloatIsOutOfBorderException extends RuntimeException
{

	public FloatIsOutOfBorderException(String fieldName)
	{
		super(String.format("Float в поле %s выходит за указанные границы!", fieldName));
	}

}
