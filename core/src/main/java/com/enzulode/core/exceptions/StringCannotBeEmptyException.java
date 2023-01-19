package com.enzulode.core.exceptions;

public class StringCannotBeEmptyException extends RuntimeException
{

	public StringCannotBeEmptyException(String fieldName)
	{
		super(String.format("Строка в поле %s не может быть пустой!", fieldName));
	}

}
