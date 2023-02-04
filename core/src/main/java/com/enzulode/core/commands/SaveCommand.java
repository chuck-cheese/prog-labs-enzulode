package com.enzulode.core.commands;

import com.enzulode.core.Console;
import com.enzulode.core.exceptions.IncorrectCommandArgumentsException;
import com.enzulode.core.util.Printer;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class SaveCommand extends Command
{

	public SaveCommand()
	{
		super("save", "команда сохраняет коллекцию в файл");
	}

	@Override
	public boolean execute(Scanner in, Printer out)
			throws IncorrectCommandArgumentsException, URISyntaxException, IOException
	{
		Console.TICKET_REPOSITORY.save();
		return true;
	}
}
