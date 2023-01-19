package com.enzulode.core.exceptions;

public class IntegerIsOutOfBorderException extends RuntimeException
{

	public IntegerIsOutOfBorderException(String fieldName)
	{
		super(String.format("Integer в поле %s выходит за указанные границы!", fieldName));
	}

}
