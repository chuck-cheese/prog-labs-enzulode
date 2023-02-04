package com.enzulode.core.util;

import com.enzulode.core.commands.*;
import com.enzulode.core.exceptions.CommandNotFoundException;
import java.util.*;

public class CLIExchangeResolver
{

	private final CommandExecutor executor;

	public static final Map<String, Command> commandRegistry = new HashMap<>() {{

		put("help", new HelpCommand());
		put("info", new InfoCommand());
		put("show", new ShowCommand());
//		TODO: add add command
//		TODO: add update command
		put("remove_by_id", new RemoveCommand());
		put("clear", new ClearCommand());
		put("save", new SaveCommand());
//		TODO: add execute_script command
		put("exit", new ExitCommand());
		put("shuffle", new ShuffleCommand());
		put("reorder", new ReorderCommand());
//		TODO: add history command
		put("count_by_price", new CountByPriceCommand());
		put("print_descending", new PrintDescendingCommand());
		put("print_field_descending_price", new PrintFieldDescendingPriceCommand());
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
