package com.enzulode.core.util;

import com.enzulode.core.commands.Command;
import com.enzulode.core.commands.ExitCommand;
import com.enzulode.core.commands.HelpCommand;
import com.enzulode.core.exceptions.CommandNotFoundException;
import java.util.*;

public class CLIExchangeResolver
{

	private final CommandExecutor executor;

	public static final Map<String, Command> commandRegistry = new HashMap<>() {{
		put("exit", new ExitCommand());
		put("help", new HelpCommand());
	}};

	public CLIExchangeResolver(Scanner in, Printer out)
	{
		this.executor = new CommandExecutor(in, out);
	}

	public CLIExchange resolve(String stringToResolve) throws CommandNotFoundException
	{
		String[] splittedCommandString = stringToResolve.trim().split(" ");
		List<String> commandArguments = Arrays.asList(
				Arrays.copyOfRange(splittedCommandString, 1, splittedCommandString.length)
		);

		return new CLIExchangeImpl(
				commandRegistry.get(splittedCommandString[0]),
				commandArguments,
				executor
		);
	}

}
