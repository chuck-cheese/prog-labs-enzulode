package com.enzulode.core.util;

import com.enzulode.core.commands.*;
import com.enzulode.core.exceptions.CommandNotFoundException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class CommandResolver
{

	public static final Map<String, Command> commandRegistry;

	static
	{
		commandRegistry = new LinkedHashMap<>();
	}

	private final Printer printer;

	public CommandResolver()
	{
		printer = new ConsolePrinter();

		commandRegistry.put("help", new HelpCommand());
		commandRegistry.put("exit", new ExitCommand());
		commandRegistry.put("show", new ShowCommand());
		commandRegistry.put("test", new TestCommand());
	}

	public Command resolve(String resolvingTarget) throws CommandNotFoundException
	{

		String[] commandWithArgs = resolvingTarget.trim().split(" ");
		String[] commandArguments = Arrays.copyOfRange(commandWithArgs, 1, commandWithArgs.length);

		if (commandRegistry.containsKey(commandWithArgs[0]))
			return commandRegistry.get(commandWithArgs[0]).processArguments(commandArguments);
		else
			throw new CommandNotFoundException("No such command found!");
	}

}
