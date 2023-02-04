package com.enzulode.core.commands;

import com.enzulode.core.Console;
import com.enzulode.core.util.Printer;
import java.util.Scanner;

public class PrintDescendingCommand extends Command
{
	public PrintDescendingCommand()
	{
		super("print_descending", "выводит элементы коллекции в порядке убывания");
	}

	@Override
	public boolean execute(Scanner in, Printer out)
	{
		out.println(Console.TICKET_REPOSITORY.descending());
		return true;
	}
}
