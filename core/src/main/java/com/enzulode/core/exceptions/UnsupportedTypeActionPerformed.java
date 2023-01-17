package com.enzulode.core.exceptions;



public class UnsupportedTypeActionPerformed extends Exception
{

	public UnsupportedTypeActionPerformed()
	{
		super("Unsupported action performed");
	}

	@Override
	public String toString()
	{
		return "[Exception] unsupported action performed";
	}

}
