package com.enzulode.core.commands;

import com.enzulode.core.Console;
import com.enzulode.core.exceptions.IncorrectCommandArgumentsException;
import com.enzulode.core.util.Printer;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class ClearCommand extends Command
{

	public ClearCommand()
	{
		super("clear", "очищает коллекцию");
	}

	@Override
	public boolean execute(Scanner in, Printer out)
			throws IncorrectCommandArgumentsException, URISyntaxException, IOException
	{
		Console.TICKET_REPOSITORY.clear();
		return true;
	}
}
