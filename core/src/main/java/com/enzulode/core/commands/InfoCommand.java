package com.enzulode.core.commands;

import com.enzulode.core.Console;
import com.enzulode.core.util.Printer;
import java.util.Scanner;

public class InfoCommand extends Command
{
	public InfoCommand()
	{
		super("info", "вывод информации о коллекции");
	}

	@Override
	public boolean execute(Scanner in, Printer out)
	{
		out.println(Console.TICKET_REPOSITORY.info());
		return true;
	}
}
