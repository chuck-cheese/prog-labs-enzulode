package com.enzulode.lab.util;

import static com.enzulode.natives.NativeMethods.hashcode;

public class ConsolePrinter implements Printer
{
	@Override
	public void printString(String printable)
	{
		System.out.println(printable);
	}

	@Override
	public String toString()
	{
		return "String representation: console printer";
	}

	@Override
	public int hashCode()
	{
		return hashcode(this);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof ConsolePrinter consolePrinter)
			return hashCode() == consolePrinter.hashCode();

		return false;
	}
}
