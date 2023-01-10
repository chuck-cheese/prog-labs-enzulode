package com.enzulode.lab.util;

public class ConsolePrinter implements Printer
{
	@Override
	public void printString(String printable)
	{
		System.out.println(printable);
	}
}
