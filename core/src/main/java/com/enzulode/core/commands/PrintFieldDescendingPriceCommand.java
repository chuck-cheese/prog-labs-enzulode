package com.enzulode.core.commands;

import com.enzulode.core.Console;
import com.enzulode.core.util.Printer;
import java.util.Scanner;

public class PrintFieldDescendingPriceCommand extends Command
{

	public PrintFieldDescendingPriceCommand()
	{
		super("print_field_descending_price", "выводит значения поля price всех элементов в порядке убывания");
	}

	@Override
	public boolean execute(Scanner in, Printer out)
	{
		out.println(Console.TICKET_REPOSITORY.fieldDescendingPrice());
		return true;
	}
}
