package com.enzulode.core.util;

public class ConsolePrinter implements Printer
{
	@Override
	public void print(String printable)
	{
		System.out.println(printable);
	}
}
