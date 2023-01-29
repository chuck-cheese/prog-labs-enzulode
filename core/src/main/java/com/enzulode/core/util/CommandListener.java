package com.enzulode.core.util;

import com.enzulode.core.App;
import com.enzulode.core.exceptions.CommandNotFoundException;
import java.util.*;

public class CommandListener
{

	public static CommandListener instance = null;
	private Scanner scanner;
	private CommandResolver commandResolver;
	private Printer printer;

	private CommandListener()
	{
		scanner = new Scanner(System.in);
		commandResolver = new CommandResolver();
		printer = new ConsolePrinter();
	}

	public static CommandListener getCommandListenerInstance()
	{

		if (instance == null)
		{
			instance = new CommandListener();
			return instance;
		}

		return instance;
	}

	public void listen()
	{

		while (true)
		{
			try
			{
				String commandString = scanner.nextLine().trim();
				CommandExecutor.executeCommand(printer, App.REPO, commandResolver.resolve(commandString));
			}
			catch (CommandNotFoundException e)
			{
				printer.print(e.getMessage());
//				throw new RuntimeException(e);
			}
		}

	}

}
