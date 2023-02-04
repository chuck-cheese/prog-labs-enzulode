package com.enzulode.core.commands;

import com.enzulode.core.Console;
import com.enzulode.core.exceptions.IncorrectCommandArgumentsException;
import com.enzulode.core.util.Printer;
import java.util.Scanner;

public class ShuffleCommand extends Command
{

	public ShuffleCommand()
	{
		super("shuffle", "команда перемешает элементы коллекции в случайном порядке");
	}

	@Override
	public boolean execute(Scanner in, Printer out) throws IncorrectCommandArgumentsException
	{
		Console.TICKET_REPOSITORY.shuffle();
		return true;
	}
}
