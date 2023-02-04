package com.enzulode.core.commands;

import com.enzulode.core.Console;
import com.enzulode.core.exceptions.IncorrectCommandArgumentsException;
import com.enzulode.core.util.Printer;
import java.util.Scanner;

public class ReorderCommand extends Command
{
	public ReorderCommand()
	{
		super("reorder", "команда отсортирует коллекцию в порядке, обратном нынешнему");
	}

	@Override
	public boolean execute(Scanner in, Printer out) throws IncorrectCommandArgumentsException
	{
		Console.TICKET_REPOSITORY.reorder();
		return true;
	}
}
