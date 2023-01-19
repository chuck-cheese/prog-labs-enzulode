package com.enzulode.core.exceptions;

public class FieldCannotBeNullException extends RuntimeException
{

	public FieldCannotBeNullException(String fieldName)
	{
		super(String.format("Поле %s не может быть null", fieldName));
	}

}
