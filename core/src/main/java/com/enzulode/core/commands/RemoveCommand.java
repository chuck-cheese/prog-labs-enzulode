package com.enzulode.core.commands;

import com.enzulode.core.Console;
import com.enzulode.core.exceptions.IncorrectCommandArgumentsException;
import com.enzulode.core.util.Printer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

public class RemoveCommand extends Command
{

	public RemoveCommand()
	{
		super("remove_by_id", "команда удаляет элемент из коллекции по его id");
	}

	@Override
	public boolean execute(Scanner in, Printer out)
			throws IncorrectCommandArgumentsException, URISyntaxException, IOException
	{
		List<String> args = getArguments();

		if (args.size() != 1)
			throw new IncorrectCommandArgumentsException();

		Long id = Long.parseLong(args.get(0));
		out.println(Console.TICKET_REPOSITORY.remove(id));
		return true;
	}
}
